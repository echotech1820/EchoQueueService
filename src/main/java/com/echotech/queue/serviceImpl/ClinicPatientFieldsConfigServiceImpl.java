package com.echotech.queue.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.echotech.queue.dto.ClinicPatientFieldsConfigRequest;
import com.echotech.queue.dto.PatientFieldConfigItem;
import com.echotech.queue.dto.ResponseDto;
import com.echotech.queue.model.ClinicPatientFieldsConfig;
import com.echotech.queue.model.PatientFieldsMaster;
import com.echotech.queue.repository.ClinicPatientFieldsConfigRepository;
import com.echotech.queue.repository.PatientFieldsMasterRepository;
import com.echotech.queue.service.ClinicPatientFieldsConfigService;
import com.echotech.queue.util.WebServiceUtility;

@Service
public class ClinicPatientFieldsConfigServiceImpl implements ClinicPatientFieldsConfigService {

	@Autowired
	private ClinicPatientFieldsConfigRepository clinicPatientFieldsConfigRepo;

	@Autowired
	private PatientFieldsMasterRepository patientFieldsMasterRepo;

	@Autowired
	private WebServiceUtility webServiceUtility;

	@Override
	public ResponseDto saveClinicPatientFieldsConfig(ClinicPatientFieldsConfigRequest request) {
		ResponseDto response = new ResponseDto();

		//validate given request
		String requestError = validateRequest(request);
		if (requestError != null) {
			response.setStatus("FAILURE");
			response.setMessage(requestError);
			return response;
		}

		//validate clinic 
		String clinicError = validateClinic(request.getClinicSysId());
		if (clinicError != null) {
			response.setStatus("FAILURE");
			response.setMessage(clinicError);
			return response;
		}

		List<Integer> fieldIds = request.getFields().stream()
				.map(PatientFieldConfigItem::getFieldId)
				.toList();

		List<PatientFieldsMaster> masterFields = patientFieldsMasterRepo.findByPfmSysIdIn(fieldIds);
		Map<Integer, PatientFieldsMaster> masterById = masterFields.stream()
				.collect(Collectors.toMap(PatientFieldsMaster::getPfmSysId, Function.identity(), (a, b) -> a));

		List<Integer> invalidFieldIds = fieldIds.stream()
				.filter(id -> !masterById.containsKey(id))
				.distinct()
				.toList();
		if (!invalidFieldIds.isEmpty()) {
			response.setStatus("FAILURE");
			response.setMessage("Invalid field Id(s). Field Id must exist in patient fields master: " + invalidFieldIds);
			return response;
		}

		List<Integer> inactiveFieldIds = masterFields.stream()
				.filter(master -> master.getPfmIsActive() != null
						&& !"Y".equalsIgnoreCase(master.getPfmIsActive().trim()))
				.map(PatientFieldsMaster::getPfmSysId)
				.toList();
		if (!inactiveFieldIds.isEmpty()) {
			response.setStatus("FAILURE");
			response.setMessage("Inactive field Id(s) cannot be configured: " + inactiveFieldIds);
			return response;
		}

//		String fieldNameError = validateFieldNames(request.getFields(), masterById);
//		if (fieldNameError != null) {
//			response.setStatus("FAILURE");
//			response.setMessage(fieldNameError);
//			return response;
//		}

		List<ClinicPatientFieldsConfig> existingConfigs =
				clinicPatientFieldsConfigRepo.findByCpfcClinSysId(request.getClinicSysId());
		Map<Integer, ClinicPatientFieldsConfig> existingByFieldId = existingConfigs.stream()
				.collect(Collectors.toMap(ClinicPatientFieldsConfig::getCpfcPfmSysId, Function.identity(), (a, b) -> a));

		LocalDateTime now = LocalDateTime.now();
		List<ClinicPatientFieldsConfig> configsToSave = new ArrayList<>();

		for (PatientFieldConfigItem item : request.getFields()) {
			String showFlag = normalizeFlag(item.getIsShow());
			String mandatoryFlag = normalizeFlag(item.getIsMandatory());

			ClinicPatientFieldsConfig config = existingByFieldId.get(item.getFieldId());
			if (config == null) {
				config = new ClinicPatientFieldsConfig();
				config.setCpfcClinSysId(request.getClinicSysId());
				config.setCpfcPfmSysId(item.getFieldId());
				config.setCpfcCreatedAt(now);
				config.setCpfcCreatedBy("SYSTEM");
			} else {
				config.setCpfcUpdatedAt(now);
				config.setCpfcUpdatedBy("SYSTEM");
			}

			config.setCpfcShowInForm(showFlag);
			config.setCpfcIsMandatory(mandatoryFlag);
			configsToSave.add(config);
		}

		List<ClinicPatientFieldsConfig> savedConfigs = clinicPatientFieldsConfigRepo.saveAll(configsToSave);

		response.setStatus("SUCCESS");
		response.setMessage("Clinic patient fields configuration saved successfully");
		response.setData(savedConfigs);
		return response;
	}

	private String validateRequest(ClinicPatientFieldsConfigRequest request) {
		if (request == null) {
			return "Request body is required";
		}
		if (request.getClinicSysId() == null) {
			return "Clinic Id is required";
		}
		if (request.getClinicSysId() <= 0) {
			return "Clinic Id must be a positive number";
		}
		if (request.getFields() == null || request.getFields().isEmpty()) {
			return "At least one field configuration is required";
		}

		Set<Integer> uniqueFieldIds = new HashSet<>();
		for (int i = 0; i < request.getFields().size(); i++) {
			PatientFieldConfigItem item = request.getFields().get(i);
			int row = i + 1;

			if (item == null) {
				return "Field configuration at position " + row + " is empty";
			}
			if (item.getFieldId() == null) {
				return "Field Id is required at position " + row;
			}
			if (item.getFieldId() <= 0) {
				return "Field Id must be a positive number at position " + row;
			}
			if (!uniqueFieldIds.add(item.getFieldId())) {
				return "Duplicate field Id " + item.getFieldId() + " found in request";
			}

			String showFlag = normalizeFlag(item.getIsShow());
			if (showFlag == null) {
				return "isShow is required and must be Y/N or true/false at position " + row;
			}

			String mandatoryFlag = normalizeFlag(item.getIsMandatory());
			if (mandatoryFlag == null) {
				return "isMandatory is required and must be Y/N or true/false at position " + row;
			}

			if ("Y".equals(mandatoryFlag) && "N".equals(showFlag)) {
				return "Field Id " + item.getFieldId() + " cannot be mandatory when isShow is N";
			}
		}

		return null;
	}

	private String validateFieldNames(List<PatientFieldConfigItem> fields, Map<Integer, PatientFieldsMaster> masterById) {
		for (PatientFieldConfigItem item : fields) {
			if (item.getFieldName() == null || item.getFieldName().isBlank()) {
				continue;
			}
			PatientFieldsMaster master = masterById.get(item.getFieldId());
			if (master.getPfmFieldName() != null
					&& !item.getFieldName().trim().equalsIgnoreCase(master.getPfmFieldName().trim())) {
				return "Field name '" + item.getFieldName() + "' does not match master field name '"
						+ master.getPfmFieldName() + "' for field Id " + item.getFieldId();
			}
		}
		return null;
	}

	private String validateClinic(Integer clinicSysId) {
		try {
			String url = webServiceUtility.getClinicNameUrl(clinicSysId);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<ResponseDto> clinicResponse = restTemplate.getForEntity(url, ResponseDto.class);

			if (clinicResponse.getBody() == null) {
				return "Unable to validate clinic Id " + clinicSysId;
			}
			if (!"SUCCESS".equalsIgnoreCase(clinicResponse.getBody().getStatus())) {
				return "Invalid clinic Id " + clinicSysId;
			}
			if (clinicResponse.getBody().getData() == null
					|| clinicResponse.getBody().getData().toString().isBlank()) {
				return "Invalid clinic Id " + clinicSysId;
			}
		} catch (RestClientException ex) {
			return "Unable to validate clinic Id " + clinicSysId;
		}
		return null;
	}

	private String normalizeFlag(Object value) {
		if (value == null) {
			return null;
		}
		if (value instanceof Boolean boolValue) {
			return boolValue ? "Y" : "N";
		}
		if (value instanceof Number numberValue) {
			if (numberValue.intValue() == 1) {
				return "Y";
			}
			if (numberValue.intValue() == 0) {
				return "N";
			}
			return null;
		}

		String flag = value.toString().trim().toUpperCase(Locale.ROOT);
		if ("Y".equals(flag) || "YES".equals(flag) || "TRUE".equals(flag) || "1".equals(flag)) {
			return "Y";
		}
		if ("N".equals(flag) || "NO".equals(flag) || "FALSE".equals(flag) || "0".equals(flag)) {
			return "N";
		}
		return null;
	}

}

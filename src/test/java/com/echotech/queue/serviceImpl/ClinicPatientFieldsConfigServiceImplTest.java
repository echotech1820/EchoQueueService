package com.echotech.queue.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.echotech.queue.dto.ClinicPatientFieldsConfigRequest;
import com.echotech.queue.dto.PatientFieldConfigItem;
import com.echotech.queue.dto.ResponseDto;
import com.echotech.queue.repository.ClinicPatientFieldsConfigRepository;
import com.echotech.queue.repository.PatientFieldsMasterRepository;
import com.echotech.queue.util.WebServiceUtility;

@ExtendWith(MockitoExtension.class)
class ClinicPatientFieldsConfigServiceImplTest {

	@Mock
	private ClinicPatientFieldsConfigRepository clinicPatientFieldsConfigRepo;

	@Mock
	private PatientFieldsMasterRepository patientFieldsMasterRepo;

	@Mock
	private WebServiceUtility webServiceUtility;

	@InjectMocks
	private ClinicPatientFieldsConfigServiceImpl service;

	@Test
	void saveConfig_rejectsMissingClinicId() {
		ClinicPatientFieldsConfigRequest request = new ClinicPatientFieldsConfigRequest();
		request.setFields(Collections.singletonList(item(1, "fullName", true, true)));

		ResponseDto response = service.saveClinicPatientFieldsConfig(request);

		assertEquals("FAILURE", response.getStatus());
		assertEquals("Clinic Id is required", response.getMessage());
		assertNull(response.getData());
	}

	@Test
	void saveConfig_rejectsEmptyFields() {
		ClinicPatientFieldsConfigRequest request = new ClinicPatientFieldsConfigRequest();
		request.setClinicSysId(10);
		request.setFields(Collections.emptyList());

		ResponseDto response = service.saveClinicPatientFieldsConfig(request);

		assertEquals("FAILURE", response.getStatus());
		assertEquals("At least one field configuration is required", response.getMessage());
	}

	@Test
	void saveConfig_rejectsDuplicateFieldIds() {
		ClinicPatientFieldsConfigRequest request = new ClinicPatientFieldsConfigRequest();
		request.setClinicSysId(10);
		request.setFields(Arrays.asList(
				item(1, "fullName", true, true),
				item(1, "fullName", false, false)));

		ResponseDto response = service.saveClinicPatientFieldsConfig(request);

		assertEquals("FAILURE", response.getStatus());
		assertEquals("Duplicate field Id 1 found in request", response.getMessage());
	}

	@Test
	void saveConfig_rejectsMandatoryWhenNotShown() {
		ClinicPatientFieldsConfigRequest request = new ClinicPatientFieldsConfigRequest();
		request.setClinicSysId(10);
		request.setFields(Collections.singletonList(item(1, "fullName", "N", "Y")));

		ResponseDto response = service.saveClinicPatientFieldsConfig(request);

		assertEquals("FAILURE", response.getStatus());
		assertEquals("Field Id 1 cannot be mandatory when isShow is N", response.getMessage());
	}

	@Test
	void saveConfig_rejectsInvalidFlag() {
		ClinicPatientFieldsConfigRequest request = new ClinicPatientFieldsConfigRequest();
		request.setClinicSysId(10);
		request.setFields(Collections.singletonList(item(1, "fullName", "MAYBE", true)));

		ResponseDto response = service.saveClinicPatientFieldsConfig(request);

		assertEquals("FAILURE", response.getStatus());
		assertEquals("isShow is required and must be Y/N or true/false at position 1", response.getMessage());
	}

	private PatientFieldConfigItem item(Integer fieldId, String fieldName, Object isShow, Object isMandatory) {
		PatientFieldConfigItem item = new PatientFieldConfigItem();
		item.setFieldId(fieldId);
		item.setFieldName(fieldName);
		item.setIsShow(isShow);
		item.setIsMandatory(isMandatory);
		return item;
	}

}

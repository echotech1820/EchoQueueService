package com.echotech.queue.serviceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.echotech.queue.dto.QueueTokenRequest;
import com.echotech.queue.dto.ResponseDto;
import com.echotech.queue.model.PatientMaster;
import com.echotech.queue.model.QueueToken;
import com.echotech.queue.repository.PatientRepository;
import com.echotech.queue.repository.QueueTokenRepository;
import com.echotech.queue.service.QueueTokenService;
import com.echotech.queue.util.WebServiceUtility;

@Service
public class QueueTokenServiceImpl implements QueueTokenService {
	
	@Autowired
	private PatientRepository patientRepo;

	@Autowired
	private QueueTokenRepository queueTokenRepo;
	
	@Autowired
	private WebServiceUtility webServiceUtility;
	
	@Override
	public ResponseDto createToken(QueueTokenRequest queueTokenRequest) {
		ResponseDto response = new ResponseDto();
		
		Optional<PatientMaster> optPatient = patientRepo.findByPhoneNumberAndName(queueTokenRequest.getMobileNumber(),
																		queueTokenRequest.getFullName());
		QueueToken token = new QueueToken();
		if(!optPatient.isEmpty()) { // Patient Already exists and should create only token
			PatientMaster patient = optPatient.get();
			token.setQutCreatedAt(LocalDateTime.now());
			token.setQutClinSysId(queueTokenRequest.getClinicSysId());
			token.setQutDocSysId(queueTokenRequest.getConsultingDoctorSysId());
			token.setQutTokenDate(webServiceUtility.stringToDate(queueTokenRequest.getTokenDate()));
			token.setQutPtntSysId(patient.getPtntSysId());
			
		    Integer lastSequence =
		            queueTokenRepo.findMaxSequence(
		            		queueTokenRequest.getClinicSysId(),
		            		webServiceUtility.stringToDate(queueTokenRequest.getTokenDate())
		            );
			
		    String url = webServiceUtility.getClinicNameUrl(queueTokenRequest.getClinicSysId());
		    
		    System.out.println("URL: " + url);
			
		    RestTemplate restTemplate = new RestTemplate();

		    ResponseEntity<ResponseDto> clnNameResponse =
		            restTemplate.getForEntity(url, ResponseDto.class);
		    
		    System.out.println(clnNameResponse.getBody().getStatus() + " * " +
		    clnNameResponse.getBody().getData().toString());
			
			token.setQutTokenNo(generateTokenNumber(queueTokenRequest.getClinicSysId(), clnNameResponse.getBody().getData().toString(), 
					webServiceUtility.stringToLocalDate(queueTokenRequest.getTokenDate()), lastSequence));
			token.setQutSeqNo(lastSequence == null ? 1 : lastSequence + 1);
			token.setQutCreatedAt(LocalDateTime.now());
			
			token = queueTokenRepo.save(token);
			
			if(token.getQutSysId() != null) {
				response.setStatus("SUCCESS");
				response.setMessage("Token Created Successfully");
			}else {
				response.setStatus("FAILURE");
				response.setMessage("Token Creation Failed");
			}
			
		}else { // Patient doesn't exist and both patient and token should be created newly
			System.out.println("IN ELSE");
			PatientMaster patient = new PatientMaster();
			
			patient.setPtntMobileNumber(queueTokenRequest.getMobileNumber());
			patient.setPtntFullName(queueTokenRequest.getFullName());
			patient.setPtntAge(queueTokenRequest.getAge());
			patient.setPtntGender(queueTokenRequest.getGender());
			patient.setPtntBloodGroup(queueTokenRequest.getBloodGroup());
			patient.setPtntCity(queueTokenRequest.getCity());
			patient.setPtntCreatedAt(LocalDateTime.now());
			
			patient = patientRepo.save(patient);
			
			
			token.setQutCreatedAt(LocalDateTime.now());
			token.setQutClinSysId(queueTokenRequest.getClinicSysId());
			token.setQutDocSysId(queueTokenRequest.getConsultingDoctorSysId());
			token.setQutTokenDate(webServiceUtility.stringToDate(queueTokenRequest.getTokenDate()));
			token.setQutPtntSysId(patient.getPtntSysId());
			token.setQutCreatedAt(LocalDateTime.now());
			
		    Integer lastSequence =
		            queueTokenRepo.findMaxSequence(
		            		queueTokenRequest.getClinicSysId(),
		            		webServiceUtility.stringToDate(queueTokenRequest.getTokenDate())
		            );
			
		    String url = webServiceUtility.getClinicNameUrl(queueTokenRequest.getClinicSysId());
		    
		    System.out.println("URL: " + url);
			
		    RestTemplate restTemplate = new RestTemplate();

		    ResponseEntity<ResponseDto> clnNameResponse =
		            restTemplate.getForEntity(url, ResponseDto.class);
		    
		    System.out.println(clnNameResponse.getBody());
			
			token.setQutTokenNo(generateTokenNumber(queueTokenRequest.getClinicSysId(), clnNameResponse.getBody().getData().toString(), 
					webServiceUtility.stringToLocalDate(queueTokenRequest.getTokenDate()), lastSequence));
			
			token.setQutSeqNo(lastSequence == null ? 1 : lastSequence + 1);
			
			token = queueTokenRepo.save(token);
			
			if(token.getQutSysId() != null) {
				response.setStatus("SUCCESS");
				response.setMessage("Patient and Token created");
			}else {
				response.setStatus("FAILURE");
				response.setMessage("Failed");
			}
		}
		
		return response;
	}
	
	public String generateTokenNumber(
	        Integer clinicSysId,
	        String clinicName,
	        LocalDate tokenDate,
	        Integer lastSeq) {

	    String prefix = clinicName.substring(0, 2).toUpperCase();

	    int nextSequence = (lastSeq == null)
	            ? 1
	            : lastSeq + 1;

	    return String.format("%s-%02d", prefix, nextSequence);
	}

}

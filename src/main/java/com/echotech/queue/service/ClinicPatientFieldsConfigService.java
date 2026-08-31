package com.echotech.queue.service;

import com.echotech.queue.dto.ClinicPatientFieldsConfigRequest;
import com.echotech.queue.dto.ResponseDto;

public interface ClinicPatientFieldsConfigService {

	ResponseDto saveClinicPatientFieldsConfig(ClinicPatientFieldsConfigRequest request);

}

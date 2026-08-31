package com.echotech.queue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.echotech.queue.dto.ClinicPatientFieldsConfigRequest;
import com.echotech.queue.dto.ResponseDto;
import com.echotech.queue.service.ClinicPatientFieldsConfigService;

@RestController
@RequestMapping("/api/v1/clinicPatientFields")
public class ClinicPatientFieldsConfigController {

	@Autowired
	private ClinicPatientFieldsConfigService clinicPatientFieldsConfigService;

	@PostMapping("/saveConfig")
	public ResponseEntity<ResponseDto> saveConfig(@RequestBody ClinicPatientFieldsConfigRequest request) {
		ResponseDto response = clinicPatientFieldsConfigService.saveClinicPatientFieldsConfig(request);
		return ResponseEntity.ok(response);
	}

}

package com.echotech.queue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.echotech.queue.dto.QueueTokenRequest;
import com.echotech.queue.dto.ResponseDto;
import com.echotech.queue.service.QueueTokenService;

@RestController
@RequestMapping("/api/v1/queue")
public class QueueTokenController {
	
	@Autowired
	private QueueTokenService queueService;
	
	@PostMapping("/createToken")
	public ResponseEntity<ResponseDto> createToken(@RequestBody QueueTokenRequest queueTokenRequest){
		ResponseDto response = queueService.createToken(queueTokenRequest);
		
		return ResponseEntity.ok(response); 
	}

}

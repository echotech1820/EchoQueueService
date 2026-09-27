package com.echotech.queue.service;

import com.echotech.queue.dto.QueueTokenListRequest;
import com.echotech.queue.dto.QueueTokenRequest;
import com.echotech.queue.dto.ResponseDto;

public interface QueueTokenService {

	ResponseDto createToken(QueueTokenRequest queueTokenRequest);

	ResponseDto getTokens(QueueTokenListRequest request);

}

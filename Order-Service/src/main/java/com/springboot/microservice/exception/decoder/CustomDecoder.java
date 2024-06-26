package com.springboot.microservice.exception.decoder;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.microservice.exception.ErrorResponse;
import com.springboot.microservice.exception.OrderServiceCustomException;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomDecoder implements ErrorDecoder{

	@Override
	public Exception decode(String methodKey, Response response) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			ErrorResponse errorResponse = objectMapper.readValue(response.body().asInputStream(), ErrorResponse.class);
			return new OrderServiceCustomException(errorResponse.getMessage(), errorResponse.getErrorCode());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new OrderServiceCustomException("ServiceInternalException","SERVICE_EXCEPTION");
	}
}

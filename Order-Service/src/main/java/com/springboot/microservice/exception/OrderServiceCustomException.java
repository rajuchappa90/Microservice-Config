package com.springboot.microservice.exception;

import lombok.Data;

@Data
public class OrderServiceCustomException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorCode;

	public OrderServiceCustomException(String message,String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}
	
}

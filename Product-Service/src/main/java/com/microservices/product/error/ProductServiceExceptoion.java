package com.microservices.product.error;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class ProductServiceExceptoion extends Exception {
     
	private String errorCode;
	public ProductServiceExceptoion(String message,String errorCode) {
		
		super(message);
		this.errorCode=errorCode;
	}
}

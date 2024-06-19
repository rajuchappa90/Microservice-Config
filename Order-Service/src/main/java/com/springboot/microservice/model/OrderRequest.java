package com.springboot.microservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequest {

	private Long productId;
	private double amount;
	private PaymentMode paymentMode;
	private int quentity;
}


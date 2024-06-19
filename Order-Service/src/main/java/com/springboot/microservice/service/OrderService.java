package com.springboot.microservice.service;

import com.springboot.microservice.model.OrderRequest;

public interface OrderService {

	public Long placeOrder(OrderRequest orderRequest);
}

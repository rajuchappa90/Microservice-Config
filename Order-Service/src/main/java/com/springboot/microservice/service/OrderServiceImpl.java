package com.springboot.microservice.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.microservice.client.ProductService;
import com.springboot.microservice.entity.Order;
import com.springboot.microservice.model.OrderRequest;
import com.springboot.microservice.repository.OrderRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductService productService;
	
	@Override
	public Long placeOrder(OrderRequest orderRequest) {
		log.info("Before placing order");
		// TODO Auto-generated method stub
		productService.reduceQuentity(orderRequest.getProductId(), orderRequest.getQuentity());
	     log.info("After checking availability for product"+orderRequest.getProductId());
		Order order=Order.builder()
				.productId(orderRequest.getProductId())
				.price(orderRequest.getAmount())
				.orderStatus("CREATED")
				.date(Instant.now())
				.quentity(orderRequest.getQuentity())
				.build();
		log.info("Order palced");
		orderRepository.save(order);
	   log.info("Product saved successfully");
		return order.getOrderId();
	}

}

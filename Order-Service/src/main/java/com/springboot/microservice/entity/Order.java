package com.springboot.microservice.entity;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name="order_service")
public class Order {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long orderId;
	private Long productId;
	private double price;
	private Instant date;
	private String orderStatus;
	private int quentity;
}

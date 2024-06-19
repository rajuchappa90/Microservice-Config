package com.springboot.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.microservice.entity.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}

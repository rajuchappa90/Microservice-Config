package com.microservices.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.product.error.ProductServiceExceptoion;
import com.microservices.product.model.ProductRequest;
import com.microservices.product.model.ProductResponse;
import com.microservices.product.service.ProductServiceImpl;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
	private ProductServiceImpl productService;
    @PostMapping("/create")
	public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest){
		
	Long productId=	productService.addProduct(productRequest);
		
		return new ResponseEntity<>(productId,HttpStatus.CREATED);
		
	}
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable("id")Long productId) throws ProductServiceExceptoion{
    
    	ProductResponse response=productService.getProductById(productId);
    	return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @PutMapping("/reduceQuentity/{id}")
    public ResponseEntity<Void> reduceQuentity(@PathVariable("id") Long productId, @RequestParam int quentity) throws ProductServiceExceptoion{
            productService.reduceQuentity(productId, quentity);
    	return new ResponseEntity<Void>(HttpStatus.OK);
    }
}

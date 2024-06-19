package com.microservices.product.service;

import com.microservices.product.error.ProductServiceExceptoion;
import com.microservices.product.model.ProductRequest;
import com.microservices.product.model.ProductResponse;

public interface ProductService {

	public Long addProduct(ProductRequest productRequest);
	public ProductResponse getProductById(Long productId) throws ProductServiceExceptoion;
	public void reduceQuentity(Long productId, int quentity) throws ProductServiceExceptoion;
}

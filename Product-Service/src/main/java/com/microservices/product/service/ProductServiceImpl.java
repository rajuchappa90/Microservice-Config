package com.microservices.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.product.entity.Product;
import com.microservices.product.error.ProductServiceExceptoion;
import com.microservices.product.model.ProductRequest;
import com.microservices.product.model.ProductResponse;
import com.microservices.product.repository.ProductRepository;

import lombok.extern.log4j.Log4j2;
@Service
@Log4j2
public class ProductServiceImpl implements ProductService{
    @Autowired
	private ProductRepository productRepository;
	@Override
	public Long addProduct(ProductRequest productRequest) {
		// TODO Auto-generated method stub
		Product product=Product.builder()
				.productName(productRequest.getProductName())
				.price(productRequest.getPrice())
				.quentity(productRequest.getQuentity())
				.build();
				productRepository.save(product);
		return product.getProductId();
	}
	public ProductResponse getProductById(Long productId) throws ProductServiceExceptoion {
		// TODO Auto-generated method stub
		Product product=productRepository.findById(productId)
				.orElseThrow(() -> new ProductServiceExceptoion("Product id is not Found", "PRODUCT_ID_NOT_FOUND"));
		ProductResponse productResponse=ProductResponse.builder()
				.productName(product.getProductName())
				.price(product.getPrice())
				.quentity(product.getQuentity()).build();
				
		return productResponse;
	}
	@Override
	public void reduceQuentity(Long productId, int quentity) throws ProductServiceExceptoion  {
		// TODO Auto-generated method stub
		log.info("reduceing Quentity initiated");
		Product product=productRepository.findById(productId)
				.orElseThrow(() -> new ProductServiceExceptoion("Product id is not Found", "PRODUCT_ID_NOT_FOUND"));
		if(product instanceof Product) {
			log.info("Checking product quentity");
			if(product.getQuentity() < quentity) {
				
				throw new ProductServiceExceptoion("not having enough Quantity of products","NOT_ENOUGH_QUENTITY");
			}
			product.setQuentity(product.getQuentity() - quentity);
			productRepository.save(product);
			log.info("Product saved in DB");
		}
	}

}

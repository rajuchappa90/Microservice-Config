package com.springboot.microservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springboot.microservice.exception.decoder.CustomDecoder;

import feign.codec.ErrorDecoder;

@Configuration
public class DecoderConfig {
	@Bean
	public ErrorDecoder createConfig() {
		return new CustomDecoder();
	}
}

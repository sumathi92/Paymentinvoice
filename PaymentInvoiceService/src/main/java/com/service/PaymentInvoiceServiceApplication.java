package com.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PaymentInvoiceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentInvoiceServiceApplication.class, args);
	}

	@Bean
	//@LoadBalanced
	public RestTemplate getRestTemplet() {
		
		return new RestTemplate();
	}
	
	
}

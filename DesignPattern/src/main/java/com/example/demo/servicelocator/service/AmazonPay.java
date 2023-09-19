package com.example.demo.servicelocator.service;

import org.springframework.stereotype.Service;

import com.example.demo.servicelocator.dto.PaymentRequest;

@Service("AmazonPay")
public class AmazonPay implements PaymentService{

	@Override
	public String pay(PaymentRequest request) {
		return request.getAmount() + " paid successfully using " + request.getPaymentMethod();
	}

}

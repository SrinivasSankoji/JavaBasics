	package com.example.demo.servicelocator.service;

import org.springframework.stereotype.Service;

import com.example.demo.servicelocator.dto.PaymentRequest;

@Service("Paytm")
public class Paytm implements PaymentService{

	@Override
	public String pay(PaymentRequest request) {
		return request.getAmount() + " paid successfully using " + request.getPaymentMethod();
	}

}

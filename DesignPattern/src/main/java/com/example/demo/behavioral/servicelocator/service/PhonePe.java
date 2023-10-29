package com.example.demo.behavioral.servicelocator.service;

import com.example.demo.behavioral.servicelocator.dto.PaymentRequest;
import org.springframework.stereotype.Service;

@Service("PhonePe")
public class PhonePe implements PaymentService {

	@Override
	public String pay(PaymentRequest request) {
		return request.getAmount() + " paid successfully using " + request.getPaymentMethod();
	}
}

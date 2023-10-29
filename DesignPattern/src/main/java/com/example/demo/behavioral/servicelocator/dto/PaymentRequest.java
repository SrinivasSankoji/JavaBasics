package com.example.demo.behavioral.servicelocator.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long amount;
	private String paymentMethod;
	
}

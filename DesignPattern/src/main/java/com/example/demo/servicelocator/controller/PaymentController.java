package com.example.demo.servicelocator.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.servicelocator.dto.PaymentRequest;
import com.example.demo.servicelocator.registry.ServiceRegistry;
import com.example.demo.servicelocator.service.AmazonPay;
import com.example.demo.servicelocator.service.PaymentService;
import com.example.demo.servicelocator.service.Paytm;
import com.example.demo.servicelocator.service.PhonePe;

@RestController
@RequestMapping("/payment-service")
public class PaymentController {

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private Paytm paytm;

	@Autowired
	private PhonePe phonePe;

	@Autowired
	private AmazonPay ap;

	ServiceRegistry serviceRegistry;

	PaymentController(ServiceRegistry serviceRegistry) {
		super();
		this.serviceRegistry = serviceRegistry;
	}

	/**
	 * Without using Service Location Design Pattern
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping("/pay")
	public String payNow(@RequestBody PaymentRequest request) {
		String response = "";
		if (request.getPaymentMethod().equals("Paytm")) {
			response = paytm.pay(request);
		}
		if (request.getPaymentMethod().equals("PhonePe")) {
			response = phonePe.pay(request);
		}
		if (request.getPaymentMethod().equals("AmazonPay")) {
			response = ap.pay(request);
		}
		return response;
	}

	/**
	 * Finding the Service based on Service Locator Design Pattern
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping("/transfer")
	public String transfer(@RequestBody PaymentRequest request) {
		String response = "Payment transfer for "+request.getPaymentMethod()+" is Coming soon";
		if (isBeanValid(request.getPaymentMethod())) {
			PaymentService paymentService = serviceRegistry.getServiceBean(request.getPaymentMethod());
			response = paymentService.pay(request);
		}
		return response;
	}

	private boolean isBeanValid(String beanName) {
		String[] beans = applicationContext.getBeanDefinitionNames();
		return Arrays.stream(beans).anyMatch(bean -> bean.equalsIgnoreCase(beanName));
	}

}

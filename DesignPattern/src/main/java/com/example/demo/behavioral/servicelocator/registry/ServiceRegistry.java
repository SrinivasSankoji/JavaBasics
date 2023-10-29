package com.example.demo.behavioral.servicelocator.registry;

import com.example.demo.behavioral.servicelocator.service.PaymentService;

public interface ServiceRegistry {

	PaymentService getServiceBean(String serviceName);
}

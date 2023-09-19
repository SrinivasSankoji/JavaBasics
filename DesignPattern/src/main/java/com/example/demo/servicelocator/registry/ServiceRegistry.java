package com.example.demo.servicelocator.registry;

import com.example.demo.servicelocator.service.PaymentService;

public interface ServiceRegistry {

	PaymentService getServiceBean(String serviceName);
}

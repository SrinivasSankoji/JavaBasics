package com.example.demo.servicelocator.configuration;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.servicelocator.registry.ServiceRegistry;

@Configuration
public class ServiceLocatorConfiguration {

	@Bean
	public FactoryBean<?> getBean() {
		ServiceLocatorFactoryBean serviceLocatorFactoryBean = new ServiceLocatorFactoryBean();
		serviceLocatorFactoryBean.setServiceLocatorInterface(ServiceRegistry.class);
		return serviceLocatorFactoryBean;
	}
}

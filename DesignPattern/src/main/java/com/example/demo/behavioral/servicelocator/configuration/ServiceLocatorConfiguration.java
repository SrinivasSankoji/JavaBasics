package com.example.demo.behavioral.servicelocator.configuration;

import com.example.demo.behavioral.servicelocator.registry.ServiceRegistry;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceLocatorConfiguration {

	@Bean
	public FactoryBean<?> getBean() {
		ServiceLocatorFactoryBean serviceLocatorFactoryBean = new ServiceLocatorFactoryBean();
		serviceLocatorFactoryBean.setServiceLocatorInterface(ServiceRegistry.class);
		return serviceLocatorFactoryBean;
	}
}

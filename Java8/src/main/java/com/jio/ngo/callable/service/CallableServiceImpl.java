package com.jio.ngo.callable.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CallableServiceImpl implements CallableService 
{
	Logger log = LoggerFactory.getLogger(this.getClass().getName());

	@Override
	public String doProcess() {
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}

		log.info("Service finishes the process!");
		return "Done";
	}

}

package com.jio.ngo.javabrains.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController 
{
	Logger logger=LoggerFactory.getLogger(LoggingController.class);
	
	@GetMapping("/")
	public String home()
	{
		logger.trace("Error Happened");
		return "Logging Controller";
	}

}

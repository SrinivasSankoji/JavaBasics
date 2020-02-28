package com.jio.ngo.callable.controller;

import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jio.ngo.callable.service.CallableService;

@RestController
public class CallableController 
{
	@Autowired
	CallableService callableService;
	
	 Logger log = LoggerFactory.getLogger(this.getClass().getName());
	  
	  @RequestMapping("/callablerequest")
	  public Callable<String> callable(){
	    log.info("#CallableRequest Received!");
	    
	    Callable<String> result = new Callable<String>() {
	 
	      @Override
	      public String call() throws Exception {
	        return callableService.doProcess();
	      }
	    };
	    
	    log.info("#CallableRequest Finish!");
	    return result;
	  }
	  
	  @RequestMapping("/normalrequest")
	  public String normalRequest(){
	    log.info("#NornalRequest: Request Received!");
	    
	    String result = callableService.doProcess();
	    
	    log.info("#NornamlRequest: Request Finish!");
	    return result;
	  }
	
}

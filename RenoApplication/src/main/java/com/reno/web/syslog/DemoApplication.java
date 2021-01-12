package com.reno.web.syslog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reno.log.logging.SysLog;


@RestController
public class DemoApplication {
	
	@GetMapping("/printMessage")
	public String getUser() {
		String message="Welcome User";
		return SysLog.printLog(message);
	}

}

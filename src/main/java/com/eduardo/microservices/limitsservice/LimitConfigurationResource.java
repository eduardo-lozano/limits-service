package com.eduardo.microservices.limitsservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eduardo.microservices.limitsservice.bean.LimitConfiguration;

@RestController
public class LimitConfigurationResource {
	
	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsFromConfigurations() {
		return new LimitConfiguration(100, 1000);
	}
}

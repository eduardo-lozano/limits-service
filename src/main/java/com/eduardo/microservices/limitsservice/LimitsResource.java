package com.eduardo.microservices.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eduardo.microservices.limitsservice.bean.Limits;

@RestController
public class LimitsResource {
	
	@Autowired
	private LimitsServiceConfigurationProperties limitsServiceConfigurationProperties;
	
	@GetMapping("/limits")
	public Limits retrieveLimitsFromConfigurations() {
		return new Limits(limitsServiceConfigurationProperties.getMinimum(), limitsServiceConfigurationProperties.getMaximum());
	}
}

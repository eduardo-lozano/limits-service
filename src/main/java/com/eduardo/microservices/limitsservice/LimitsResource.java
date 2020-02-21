package com.eduardo.microservices.limitsservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eduardo.microservices.limitsservice.bean.Limits;

@RestController
public class LimitsResource {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private LimitsServiceConfigurationProperties limitsServiceConfigurationProperties;
	
	@GetMapping("/limits")
	public Limits retrieveLimitsFromConfigurations() {
		Limits limits = new Limits(limitsServiceConfigurationProperties.getMinimum(), limitsServiceConfigurationProperties.getMaximum());
		logger.info("{}", limits);
		
		return limits;
	}
}

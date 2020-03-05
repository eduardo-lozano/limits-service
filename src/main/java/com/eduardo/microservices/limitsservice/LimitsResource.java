package com.eduardo.microservices.limitsservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eduardo.microservices.limitsservice.bean.Limits;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

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
	
	@GetMapping("/faulty-limits-example")
	@HystrixCommand(fallbackMethod="fallbackFaultyRetrieveConfiguration")   // Name of the fallback method (below)
	public Limits faultyRetrieveConfiguration() {
		throw new RuntimeException("Not available");   // Exception thrown here on purpose
	}
	
	// Default method to be called when some exception is thrown, for any reason, in a service (in this case, above)
	// This prevents the downstream services from failing miserably in case some upstream or external service(s) fail
	public Limits fallbackFaultyRetrieveConfiguration() {
		return new Limits(8, 888);
	}
}

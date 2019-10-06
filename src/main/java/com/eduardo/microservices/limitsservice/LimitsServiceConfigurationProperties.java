package com.eduardo.microservices.limitsservice;

import org.springframework.boot.context.properties.ConfigurationProperties;

// From SpringBoot, it automatically goes to the application.properties file, and gets the lines that start
// with the specified prefix "limits-service". Then turns them into variables we can use. And it does so every
// time an HttpRequest is sent by the client! No need to reboot the server: if we change the value and save it
// in the server's application.properties file and make an HttpRequest from a client, it returns the new value.
@ConfigurationProperties("limits-service")
public class LimitsServiceConfigurationProperties {

	// Fields' names are the same as the variables that start
	// with "limits-service" from the application.properties file
	private int minimum;
	private int maximum;


	public int getMinimum() {
		return minimum;
	}
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	public int getMaximum() {
		return maximum;
	}
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
}

package com.eduardo.microservices.limitsservice.bean;

// This is the bean that will be sent to the client
public class Limits {

	private int minimum;
	private int maximum;


	// All beans like this one that will be sent through the WebService's HttpResponse
	// to the client, need a default (no-args) constructor (make it protected)
	protected Limits() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Limits(int minimum, int maximum) {
		super();
		this.minimum = minimum;
		this.maximum = maximum;
	}


	// Only getters, the field values are filled up by the constructor
	public int getMinimum() {
		return minimum;
	}

	public int getMaximum() {
		return maximum;
	}	
}

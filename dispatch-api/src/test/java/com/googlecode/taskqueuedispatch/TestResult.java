package com.googlecode.taskqueuedispatch;

import java.io.Serializable;

import net.customware.gwt.dispatch.shared.Result;

public class TestResult implements Result, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2320328423L;
	private String message;
	
	TestResult() {
	}
	public TestResult(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message; 
	}

}

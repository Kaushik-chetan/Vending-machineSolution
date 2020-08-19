package com.vm.exception;

public class LesserAmountPaidException extends RuntimeException{
	
private String message;
	
	public LesserAmountPaidException(String message) {
	super(message);
	this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
}

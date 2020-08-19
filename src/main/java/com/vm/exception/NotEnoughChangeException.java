package com.vm.exception;

public class NotEnoughChangeException extends RuntimeException{
	
private String message;
	
	public NotEnoughChangeException(String message) {
	super(message);
	this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}

}

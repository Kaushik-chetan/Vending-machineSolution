package com.vm.exception;

public class ProductOutOfStockException extends RuntimeException{

	private String message;
	
	public ProductOutOfStockException(String message) {
	super(message);
	this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}

}

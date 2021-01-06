package com.service.exception;

public class DetailsNotFoundException extends RuntimeException {

	public DetailsNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public DetailsNotFoundException(String message) {
		super(message);
	}

	public DetailsNotFoundException(Throwable cause) {
		super(cause);
	}
	
	

}

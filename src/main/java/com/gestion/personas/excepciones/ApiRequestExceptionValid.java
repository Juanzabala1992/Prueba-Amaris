package com.gestion.personas.excepciones;

public class ApiRequestExceptionValid  extends RuntimeException {
	
	public ApiRequestExceptionValid (String message) {
		super (message);
	}
	public ApiRequestExceptionValid (String message, Throwable cause) {
		super(message);
	}
}


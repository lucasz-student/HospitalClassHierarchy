package com.solvd.laba.Exceptions;

public class UnequippedToolException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public UnequippedToolException() {
	}

	public UnequippedToolException(String message) {
		super(message);
	}
	
	public UnequippedToolException(String message, Throwable cause) {
		super(message, cause);
		
}
}
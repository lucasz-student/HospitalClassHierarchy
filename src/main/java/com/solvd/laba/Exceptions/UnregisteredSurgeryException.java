package com.solvd.laba.Exceptions;

public class UnregisteredSurgeryException extends Exception{

	private static final long serialVersionUID = 1L;

	public UnregisteredSurgeryException() {
	}
	
	public UnregisteredSurgeryException(String message) {
		super(message);
	}
	
	public UnregisteredSurgeryException(String message, Throwable cause) {
		super(message, cause);
	}
}

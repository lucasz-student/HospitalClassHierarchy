package com.solvd.laba.Exceptions;

public class PatientNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public PatientNotFoundException() {
	}
	
	public PatientNotFoundException(String message) {
		super(message);
	}
	
	public PatientNotFoundException(String message, Throwable cause) {
		super(message, cause);	
	}
}
package com.solvd.laba.Exceptions;

public class NoAppointmentException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoAppointmentException() {
	}
	
	public NoAppointmentException(String message) {
		super(message);
	}
	
	public NoAppointmentException(String message, Throwable cause) {
		super(message, cause);
		
}
}
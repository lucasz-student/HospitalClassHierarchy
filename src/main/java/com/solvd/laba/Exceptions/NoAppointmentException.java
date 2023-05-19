package com.solvd.laba.Exceptions;

import com.solvd.laba.Utils.Utils;

public class NoAppointmentException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoAppointmentException() {
	}
	
	public NoAppointmentException(String message) {
		super(message);
		Utils.logger.warn(message);
	}
	
	public NoAppointmentException(String message, Throwable cause) {
		super(message, cause);	
		Utils.logger.warn(message);
	}
}
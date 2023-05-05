package com.solvd.laba.Exceptions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.solvd.laba.Utils.Utils;

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
	
	public UnregisteredSurgeryException(String message, Throwable cause, String name) {
		super(message);
		Utils.logger.warn("[" + message + ":" + name +"]");
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(Utils.patientList));) {
			writer.write("\n[" + message + ":" + name +"]");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


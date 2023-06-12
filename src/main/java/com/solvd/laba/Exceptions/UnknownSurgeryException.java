package com.solvd.laba.Exceptions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.solvd.laba.Utils.Utils;

public class UnknownSurgeryException extends Exception{

	public UnknownSurgeryException() {
	}
	
	public UnknownSurgeryException(String message) {
		super(message);
	}
	
	public UnknownSurgeryException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public UnknownSurgeryException(String message, String surgeryName) {
		super(message);
		Utils.logger.warn("[" + message + ":" + surgeryName +"]");
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(Utils.patientList));) {
			writer.write("\n[" + message + ":" + surgeryName +"]");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


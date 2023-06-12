package com.solvd.laba.Exceptions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.solvd.laba.Utils.Utils;

public class PatientNotFoundException extends Exception {

	public PatientNotFoundException() {		
	}
	
	public PatientNotFoundException(String name, String time) {
		Utils.logger.warn("Unregistered Patient action : [" + name + ":" + time + "]");
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(Utils.patientList));) {
			writer.write("Unregistered Patient action : [" + name + ":" + time + "]");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public PatientNotFoundException(String message) {
		super(message);
		Utils.logger.warn(message);
	}
	
	public PatientNotFoundException(String message, Throwable cause) {
		super(message, cause);	
		Utils.logger.warn(message);
	}
	
}
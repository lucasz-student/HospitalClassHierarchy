package com.solvd.laba.Exceptions;

import java.io.IOException;

import com.solvd.laba.Utils.Days;
import com.solvd.laba.Utils.Utils;

import Entities.Nurse;
import Entities.RegularPatient;

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
	
	public NoAppointmentException(String message, boolean newAppointment, RegularPatient patient, Nurse nurse, String time, String sick, Days day) {
		if (newAppointment) {
			System.out.println("\nScheduling new appointment..\n");
			try {
				patient.scheduleAppointmentWithNurse(nurse, time, sick, day);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
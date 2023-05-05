package com.solvd.laba.Exceptions;

import java.io.IOException;

import com.solvd.laba.MedicalWorkers.Nurse;
import com.solvd.laba.Patients.CheckupPatient;
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
	
	public NoAppointmentException(String message, boolean newAppointment, CheckupPatient patient, Nurse nurse, String time, String sick) {
		if (newAppointment) {
			System.out.println("\nScheduling new appointment..\n");
			try {
				patient.scheduleAppointmentWithNurse(nurse, time, sick);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
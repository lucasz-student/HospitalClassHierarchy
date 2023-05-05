package com.solvd.laba.MedicalWorkers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.solvd.laba.MedicalForms.AppointmentForm;
import com.solvd.laba.MedicalForms.WellnessForm;
import com.solvd.laba.Patients.CheckupPatient;
import com.solvd.laba.Tools.Sphygmomanometer;
import com.solvd.laba.Tools.Stethoscope;
import com.solvd.laba.Tools.Thermometer;
import com.solvd.laba.Tools.Tools;
import com.solvd.laba.Utils.Utils;
import com.solvd.laba.InstantiateObjects;
import com.solvd.laba.Exceptions.NoAppointmentException;
import com.solvd.laba.Exceptions.PatientNotFoundException;
import com.solvd.laba.Exceptions.UnequippedToolException;

public class Doctor {
	private String branchOfHospital;
	private String name;
	private int Experience;
	private boolean inResidency; 
	private int DoctorID;

	public Doctor(String branchOfHospital, String name, int Experience, boolean inResidency, int DoctorID) {
		this.branchOfHospital = branchOfHospital;
		this.name = name;
		this.inResidency = inResidency; 
		this.Experience = Experience; 
		this.DoctorID = DoctorID;
	}
	
	public void setExperience(int years) {
		this.Experience = years;
	}
	
	public String getbranchOfHospital() {
		return this.branchOfHospital;
	}
	
	public boolean comfirmAppointment(AppointmentForm AppointmentForm) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Hello Doctor " + this.name + ", do you want to comfirm an appointment with " + AppointmentForm.getName() + " at " + AppointmentForm.getTime() + "?");
		System.out.println("Enter 0 to comfirm and 1 to decline");
		
		int comfirmation = scanner.nextInt();
		scanner.close();
		
		if (comfirmation == 0) { 
			return true;
		}
		else {
			return false;
		}
	}
	
	public WellnessForm patientCheckup(CheckupPatient patient, Sphygmomanometer bpMachine, Stethoscope stethoscope, Thermometer thermometer) throws IOException, NoAppointmentException, UnequippedToolException {
		
		
		Utils.logger.error("Finding Patient in files: " + patient.getName());
		if (Utils.checkFileForString(Utils.patientList, patient.getName()) == false) {
			throw new NoAppointmentException("Patient not on AppointmentList and PatientList", new PatientNotFoundException());

		} 
		else if (Utils.checkFileForString(Utils.appointmentList, patient.getName()) == false) {
			throw new NoAppointmentException("Patient not on AppointmentList");
		}
		else {
			Utils.logger.info("Successfully found PatientName, returning WellnessForm");
			String bloodPressure = bpMachine.measureBP();
			String soundQuality = stethoscope.listen() ;
			String temp = thermometer.measureTemp();
			
			WellnessForm wellnessForm = new WellnessForm(Integer.toString(patient.getAge()), patient.getName(), bloodPressure, soundQuality, temp);
			
			return wellnessForm;
		}
		
				

	}
	
	public void diagnosePatient(CheckupPatient patient, WellnessForm wellnessSlip) {
		Utils.logger.info("Successfully Diagnosing patient");
		System.out.println("\nHello, " + patient.getName() + " welcome to your scheduled appointment");
		switch (wellnessSlip.getBp()) {
		case ("high"):
			System.out.println("Your blood pressure is too high\n");
			patient.setSick(true);
			break;
		case ("low"):
			System.out.print("Your blood pressure is too low\n");
			patient.setSick(true);
			break;
		case ("normal"):
			System.out.println("Your blood pressure is normal\n");
			break;
		}
		
		switch (wellnessSlip.getTemperature()) {
		case ("high"):
			System.out.println("You have a fever\n");
			patient.setSick(true);
			break;
		case ("low"):
			System.out.print("You have hyperthermia\n");
			patient.setSick(true);
			break;
		case ("normal"):
			System.out.println("Your temperature is normal\n");
			break;	
		}
		
		if (wellnessSlip.getStethoscopeReading() == "poor") {
			System.out.println("Something may be wrong with your heart or lungs\n");	
			patient.setSick(true);
		}
		else {
			System.out.println("Your heart and lungs sound normal\n");
		}
	}
	
	public void prescribeMedicine(CheckupPatient patient, WellnessForm wellnessSlip) {
		System.out.println("\nHello, " + patient.getName());
		switch (wellnessSlip.getBp()) {
		case ("high"):
			System.out.print("For your high BP, please take Hygroton\n");
			break;
		case ("normal"):
			System.out.print("Your blood pressure is normal and you do not need medication\n");
			break;
		case ("low"):
			System.out.print("For your low BP, please take Atacand\n");
			break;
		}
		
		switch (wellnessSlip.getTemperature()) {
		case ("high"):
			System.out.print("For your high Body Temperature, please take Ibuprofen\n");
			break;
		case ("normal"):
			System.out.print("Your Body Temperature is normal and you do not need medication\n");
			break;
		case ("low"):
			System.out.print("For your low Body Temperature, please take Cordarone\n");
			break;
		}
		
		if (wellnessSlip.getStethoscopeReading() == "poor") { 
			System.out.print("Please schedule an appointment to check your heart and lungs");
		}
	}
	
	@Override
	public String toString() {
		return "Hi, I'm Dr. " + this.name;
	}
	
	@Override
	public int hashCode() {
		return this.DoctorID;
	}
	
	@Override 
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
	
        if(obj == null || obj.getClass()!= this.getClass())
            return false;
		
		if (obj.hashCode() == this.hashCode()) {
			return true;
		}
		return false;
	}
}

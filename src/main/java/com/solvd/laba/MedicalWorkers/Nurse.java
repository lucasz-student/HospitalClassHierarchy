package com.solvd.laba.MedicalWorkers;

import com.solvd.laba.MedicalForms.AppointmentForm;
import com.solvd.laba.Patients.CheckupPatient;

public class Nurse {

	private String branchOfHospital; 
	private String name;
	private int nurseID;
	
	public Nurse(String branch, String name, int ID) { 
		this.branchOfHospital = branch;
		this.name = name;
		this.nurseID = ID;
	}
	
	public int getID() {
		return this.nurseID; 
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setBranch(String branch) { 
		this.branchOfHospital = branch;
	}
	
	public void comfirmAppointmentWithDoctor(CheckupPatient patient, Doctor doctor, AppointmentForm AppointmentForm) { 
		boolean comfirmation = doctor.comfirmAppointment(AppointmentForm);
		if (comfirmation) { 
			System.out.println("Hello, " + patient.getName() + ", your appointment for " + AppointmentForm.getTime() + " is comfirmed with the doctor!\n\n");
		}
		else { 
			System.out.println("Sorry, the doctor's schedule is preoccupied. Please reschedule your appointment");
		}
	}
	
	public static void askQuestion(String Question) { 
		switch (Question) {
		
		case ("What is the name of this Hospital"):
			System.out.println("The Community Care Clinic!\n");
			break;
		
		case ("What hours does this hospital operate?"):
			System.out.println("6:00 am - 12:00 am\n");
			break;
		
		case ("What insurance do you guys take?"):
			System.out.println("Almost all insurances\n");
			break;
		}
	}
	
	@Override
	public String toString() {
		return "Hi, I'm Nurse " + this.name;
	}
	
	@Override
	public int hashCode() {
		return this.nurseID;
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

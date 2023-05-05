package com.solvd.laba.MedicalWorkers;

import com.solvd.laba.MedicalForms.AppointmentForm;
import com.solvd.laba.Patients.CheckupPatient;

public class Nurse extends MedicalEmployee {


	
	public Nurse(String name, int age, int ID, String branch) { 
		super(name, age, ID, branch);
	}
	
	public int getID() {
		return super.medicalID; 
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
}

package HospitalClassHierarchy;

import java.util.Arrays;
import java.util.Scanner;

public class Doctor {
	private String branchOfHospital;
	private String name;
	private int Experience;
	private boolean inResidency; 

	public Doctor(String branchOfHospital, String name, int Experience, boolean inResidency) {
		this.branchOfHospital = branchOfHospital;
		this.name = name;
		this.inResidency = inResidency; 
		this.Experience = Experience; 
	}
	
	public void setExperience(int years) {
		this.Experience = years;
	}
	
	public String getbranchOfHospital() {
		return this.branchOfHospital;
	}
	

	public boolean comfirmAppointment(String[] appointmentSlip) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Hello Doctor " + this.name + ", do you want to comfirm an appointment with " + appointmentSlip[0] + " at " + appointmentSlip[4] + "?");
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
	
	public String[] patientCheckup(Patient patient, Sphygmomanometer bpMachine, Stethoscope stethoscope, Thermometer thermometer) {
		String bloodPressure = bpMachine.measureBP();
		String soundQuality = stethoscope.listen() ;
		String temp = thermometer.measureTemp();
		
		String [] patientWellnessSlip = {bloodPressure, soundQuality, temp};
		
		return patientWellnessSlip;
	}
	
	public void diagnosePatient(Patient patient, String[] wellnessSlip) {
		System.out.println("\nHello, " + patient.getName() + " welcome to your scheduled appointment");
		switch (wellnessSlip[0]) {
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
		
		switch (wellnessSlip[2]) {
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
		
		if (wellnessSlip[1] == "poor") {
			System.out.println("Something may be wrong with your heart or lungs\n");	
			patient.setSick(true);
		}
		else {
			System.out.println("Your heart and lungs sound normal\n");
		}
	}
	
	public void prescribeMedicine(Patient patient, String[] wellnessSlip) {
		System.out.println("\nHello, " + patient.getName());
		switch (wellnessSlip[0]) {
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
		
		switch (wellnessSlip[2]) {
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
		
		if (wellnessSlip[1] == "poor") { 
			System.out.print("Please schedule an appointment to check your heart and lungs");
		}

	}
}

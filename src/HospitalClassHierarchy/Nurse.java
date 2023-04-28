package HospitalClassHierarchy;

import MedicalForms.AppointmentForm;

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
	
	public void comfirmAppointmentWithDoctor(GeneralPatient patient, Doctor doctor, AppointmentForm AppointmentForm) { 
		boolean comfirmation = doctor.comfirmAppointment(AppointmentForm);
		if (comfirmation) { 
			System.out.println("Hello, " + patient.getName() + ", your appointment for " + AppointmentForm.getTime() + " is comfirmed with the doctor!\n\n");
		}
		else { 
			System.out.println("Sorry, the doctor's schedule is preoccupied. Please reschedule your appointment");
		}
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
		
		if (obj.hashCode() == this.hashCode()) {
			return true;
		}
		
		return false;
	}
}

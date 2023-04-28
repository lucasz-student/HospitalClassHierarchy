package HospitalClassHierarchy;

import MedicalForms.AppointmentForm;

public class GeneralPatient {
	private String name;
	private int age; 
	private boolean sick; 
	private String reasonForVisit;
	
	public GeneralPatient(String name, int age, boolean sick, String reasonForVisit) {
		this.name = name; 
		this.age = age;
		this.sick = sick;
		this.reasonForVisit = reasonForVisit;
	}
	
	public void setSick(boolean sick) {
		this.sick = sick; 
	}
	
	public String getName() { 
		return this.name;
	}
	
	public int getAge() {
		return this.age; 
	}
	
	public AppointmentForm scheduleAppointmentWithNurse(Nurse nurse, String time, String sick) {
		String age = Integer.toString(this.age);
		if (this.sick) { 
			sick = "Sick";
		} else {
			sick = "Not sick";
		}
		
		AppointmentForm appointmentForm = new AppointmentForm(age, this.name, time, sick, this.reasonForVisit);
		return appointmentForm;
	}
}

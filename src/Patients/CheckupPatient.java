package Patients;

import MedicalForms.AppointmentForm;
import MedicalForms.BasicPatientForm;
import MedicalWorkers.Nurse;

public class CheckupPatient implements Patient{
	private String name;
	private int age; 
	private boolean sick; 
	private String reasonForVisit;
	
	public CheckupPatient(String name, int age, boolean sick, String reasonForVisit) {
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

	@Override
	public void checkIn() {
		System.out.println("My name is " + this.name + " and I am checking in for: " + this.reasonForVisit + "\n");
		
	}

	@Override
	public void checkOut() {
		System.out.println("My name is " + this.name + " and I am checking in out\n");
		
	}

	@Override
	public void fillOutPatientForm(String time) {
		String age = Integer.toString(this.age);
		BasicPatientForm form = new BasicPatientForm(this.name, age, this.reasonForVisit, time);
		form.printForm();
	}

}

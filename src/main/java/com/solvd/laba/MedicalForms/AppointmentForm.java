package com.solvd.laba.MedicalForms;

import java.util.Arrays;

import com.solvd.laba.Utils.Utils;

public class AppointmentForm extends MedicalForms {
	protected String sick; 
	protected String reasonForVisit; 
	protected String time; 
	
	public AppointmentForm(String age, String name, String time, String sick, String reasonForVisit) {
		super(age, name);
		this.time = time; 
		this.sick = sick; 
		this.reasonForVisit = reasonForVisit;
		Utils.logger.info("Constructing Appointment Form");
	}
	
	
	public String getTime() {
		return this.time;
	}
	
	public String getAge() {
		return this.age;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setSick(String sick) {
		this.sick = sick;
	}

	@Override
	public void printForm() {
		String[] form = {this.age, this.name, this.time, this.sick, this.reasonForVisit};
		System.out.println(Arrays.toString(form));
	}

	@Override
	public String returnForm() {		
		return "" + this.age + " " + this.name + " " + this.time + " " + this.sick + " " + this.reasonForVisit;
	}
}

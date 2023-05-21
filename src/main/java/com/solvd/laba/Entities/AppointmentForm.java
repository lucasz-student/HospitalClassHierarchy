package com.solvd.laba.Entities;

import com.solvd.laba.Utils.Days;
import com.solvd.laba.Utils.Sickness;
import com.solvd.laba.Utils.Utils;

public class AppointmentForm extends MedicalForms {
	protected Sickness sick; 
	protected String reasonForVisit; 
	protected String time; 
	
	public AppointmentForm(String age, String name, String time, Sickness sick, String reasonForVisit, Days day) {
		super(age, name, day);
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
	
	public void setSick(Sickness sick) {
		this.sick = sick;
	}

	@Override
	public void printForm() {
		System.out.println("" + this.age + " " + this.name + " " + this.time + " " + this.sick + " " + this.reasonForVisit+ " " + this.day);
	}

	@Override
	public String returnForm() {		
		return "" + this.age + " " + this.name + " " + this.time + " " + this.sick + " " + this.reasonForVisit+ " " + this.day;
	}
}

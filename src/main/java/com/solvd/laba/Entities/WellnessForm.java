package com.solvd.laba.Entities;

import com.solvd.laba.Utils.Days;
import com.solvd.laba.Utils.ToolReadings;
import com.solvd.laba.Utils.Utils;

public class WellnessForm extends MedicalForms {

	private ToolReadings bloodPressure; 
	private ToolReadings stethoscopeReading; 
	private ToolReadings temperature;
	
	public WellnessForm(String age, String name, ToolReadings bloodPressure,ToolReadings stethoscopeReading, ToolReadings temperature, Days day) {
		super(age, name, day);
		this.bloodPressure = bloodPressure;
		this.stethoscopeReading = stethoscopeReading;
		this.temperature = temperature;
		Utils.logger.info("Constructing Wellness Form");
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getAge() {
		return this.age;
	}
	
	public ToolReadings getBp() {
		return this.bloodPressure;
	}
	
	public ToolReadings getStethoscopeReading() { 
		return this.stethoscopeReading;
	}
	
	public ToolReadings getTemperature() {
		return this.temperature;
	}

	@Override
	public void printForm() {
		System.out.println("" + this.age + " " + this.name + " " + this.bloodPressure + " " + this.stethoscopeReading + " " + this.temperature + " " + this.day);	
	}

	@Override
	public String returnForm() {
		return "" + this.age + " " + this.name + " " + this.bloodPressure + " " + this.stethoscopeReading + " " + this.temperature + " " + this.day;
	}
}

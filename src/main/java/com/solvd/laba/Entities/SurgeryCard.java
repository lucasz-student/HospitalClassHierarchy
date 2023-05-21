package com.solvd.laba.Entities;

import com.solvd.laba.Utils.Days;
import com.solvd.laba.Utils.Utils;

public class SurgeryCard extends MedicalForms{

	protected String surgeryName;
	public SurgeryCard(String age, String name, Days day, String surgeryName) {
		super(age, name, day);
		this.surgeryName = surgeryName;
		Utils.logger.info("Constructing Surgery Card");
	}
	
	public String getAge() {
		return this.age;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getSurgeryName() {
		return this.surgeryName;
	}

	@Override
	public void printForm() {
		System.out.print("" + this.age + " " + this.name + " " + this.surgeryName+ " " + this.day);
	}

	@Override
	public String returnForm() {
		return "" + this.age + " " + this.name + " " + this.surgeryName+ " " + this.day;
	}
}

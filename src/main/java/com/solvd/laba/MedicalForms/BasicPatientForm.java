package com.solvd.laba.MedicalForms;

import java.util.Arrays;

import com.solvd.laba.Utils.Utils;

public class BasicPatientForm extends MedicalForms {

	private String visitPurpose;
	private String checkinTime;
	
	public BasicPatientForm(String age, String name, String visitPurpose, String checkinTime) {
		super(age, name);
		this.visitPurpose = visitPurpose;
		this.checkinTime = checkinTime;
		Utils.logger.info("Constructing Patient Form");
	}

	@Override
	public void printForm() {
		String[] form = {this.name, this.age, this.visitPurpose, this.checkinTime};
		System.out.println("This is my Check in Form " + Arrays.toString(form) + "\n");
	}
		

	@Override
	public String returnForm() {
		return "" + this.name + " " + this.age + " " + this.visitPurpose + " " + this.checkinTime;
	}

}

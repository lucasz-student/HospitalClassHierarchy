package com.solvd.laba.MedicalForms;

import java.util.Arrays;

import com.solvd.laba.Utils.Utils;

public class SurgeryCard extends MedicalForms{

	protected String surgeryName;
	public SurgeryCard(String age, String name, String surgeryName) {
		super(age, name);
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
		String[] form = {this.age, this.name, this.surgeryName};
		System.out.print(Arrays.toString(form));
	}

	@Override
	public String[] returnForm() {
		String[] surgeryCard = {this.age, this.name, this.surgeryName};
		return surgeryCard;
	}

}

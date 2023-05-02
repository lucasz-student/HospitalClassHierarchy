package com.solvd.laba.MedicalForms;

import com.solvd.laba.Utils.Utils;

public abstract class MedicalForms {
	protected String age; 
	protected String name;
	
	public MedicalForms(String age, String name) {
		this.age = age;
		this.name = name; 
	}
	
	public abstract void printForm();
	
	public abstract String[] returnForm();	
}

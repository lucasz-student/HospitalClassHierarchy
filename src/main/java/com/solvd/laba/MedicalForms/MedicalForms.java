package com.solvd.laba.MedicalForms;

import java.util.ArrayList;
import java.util.Arrays;
import com.solvd.laba.Utils.Utils;

public abstract class MedicalForms {
	protected String age; 
	protected String name;
	
	public static final ArrayList<MedicalForms> dailyFormFolder = new ArrayList<>();
	
	
	public MedicalForms(String age, String name) {
		this.age = age;
		this.name = name;
		dailyFormFolder.add(this);
	}
	
	public abstract void printForm();
	
	public abstract String[] returnForm();
	
	public static void printAllFormsToday() {
		for (MedicalForms form: MedicalForms.dailyFormFolder) {
			System.out.println(form.getClass().getSimpleName() + " : " + Arrays.toString(form.returnForm()));
		}
	}
	
	public static void clearAllFormsForDay() {
		MedicalForms.dailyFormFolder.removeAll(dailyFormFolder);
		Utils.logger.info("dailyFormFolderCleared");
	}
}

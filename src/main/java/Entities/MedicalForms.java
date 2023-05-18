package Entities;

import java.util.ArrayList;

import com.solvd.laba.Utils.Days;
import com.solvd.laba.Utils.Utils;

public abstract class MedicalForms {
	protected String age; 
	protected String name;
	protected Days day;
	
	public static final ArrayList<MedicalForms> dailyFormFolder = new ArrayList<>();
	
	public MedicalForms(String age, String name, Days day) {
		this.age = age;
		this.name = name;
		this.day = day;
		dailyFormFolder.add(this);
	}
	
	public abstract void printForm();
	
	public abstract String returnForm();
	
	public static void printAllFormsToday() {
		for (MedicalForms form: MedicalForms.dailyFormFolder) {
			System.out.println(form.getClass().getSimpleName() + " : " + form.returnForm());
		}
	}
	
	public static void clearAllFormsForDay() {
		MedicalForms.dailyFormFolder.removeAll(dailyFormFolder);
		Utils.logger.info("dailyFormFolderCleared");
	}
}

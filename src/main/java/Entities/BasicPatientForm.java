package Entities;

import com.solvd.laba.Utils.Days;
import com.solvd.laba.Utils.Utils;

public class BasicPatientForm extends MedicalForms {

	private String visitPurpose;
	private String checkinTime;
	
	public BasicPatientForm(String age, String name, String visitPurpose, String checkinTime, Days day) {
		super(age, name, day);
		this.visitPurpose = visitPurpose;
		this.checkinTime = checkinTime;
		Utils.logger.info("Constructing Patient Form");
	}

	@Override
	public void printForm() {
		System.out.println("" + this.name + " " + this.age + " " + this.visitPurpose + " " + this.checkinTime+ " " + this.day);
	}
		

	@Override
	public String returnForm() {
		return "" + this.name + " " + this.age + " " + this.visitPurpose + " " + this.checkinTime+ " " + this.day;
	}

}

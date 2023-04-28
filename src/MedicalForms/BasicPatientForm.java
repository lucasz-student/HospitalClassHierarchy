package MedicalForms;

import java.util.ArrayList;
import java.util.Arrays;

public class BasicPatientForm extends MedicalForms {

	private String visitPurpose;
	private String checkinTime;
	
	public BasicPatientForm(String age, String name, String visitPurpose, String checkinTime) {
		super(age, name);
		this.visitPurpose = visitPurpose;
		this.checkinTime = checkinTime;
	}

	@Override
	public void printForm() {
		String[] form = {this.name, this.age, this.visitPurpose, this.checkinTime};
		System.out.println("This is my Check in Form " + Arrays.toString(form) + "\n");
	}
		

	@Override
	public String[] returnForm() {
		String[] form = {this.name, this.age, this.visitPurpose, this.checkinTime};
		return form;
	}

}

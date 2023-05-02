package com.solvd.laba.Patients;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import com.solvd.laba.MedicalForms.BasicPatientForm;
import com.solvd.laba.MedicalWorkers.Nurse;
import com.solvd.laba.Utils.Utils;

public class SurgeryPatient implements Patient{
	
	private String name;
	private int age;
	private String surgeryName;
	private boolean surgeryCompletion;
	
	public SurgeryPatient(String name, int age, String surgeryName) {
		this.name = name;
		this.age = age;
		this.surgeryName = surgeryName;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setSurgeryCompletion(boolean status) { 
		this.surgeryCompletion = status;
		if (status) {
			System.out.println("Current status for patient is complete\n");
		}
		else {
			System.out.println("Current status for patient is incomplete\n");
		}
	}
	
	public String[] SurgeryCardFromNurse(Nurse nurse) { 
		String[] surgeryCard = {String.valueOf(this.age), this.name, this.surgeryName}; 
		this.surgeryCompletion = false;
		System.out.println("\nHello, " + this.name + " your surgery is scheduled and your current surgery status for patient is incomplete\n");
		return surgeryCard;
	}

	@Override
	public void checkIn() {
		System.out.println("My name is " + this.name + " and I am checking in for" + this.surgeryName + "\n");
		
	}

	@Override
	public void checkOut() {
		System.out.println("My name is " + this.name + " and I am checking in out after finishing my surgery\n");
		
	}

	@Override
	public void fillOutPatientForm(String time) throws IOException {
		String age = Integer.toString(this.age);
		BasicPatientForm form = new BasicPatientForm(this.name, age, this.surgeryName, time);
		
		BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Users/lucas/OneDrive/Desktop/MavenHierarchy/my-app/src/main/java/outputFiles/PatientList.txt"));
		try  {
			Utils.logger.info("Logging Name Patient to Patient file: " + this.name);
			writer.write("\n" + Arrays.toString(form.returnForm()));
		} catch (IOException e) {

			e.printStackTrace();
		} finally { 
			writer.close();
		}
		form.printForm();
	}
}

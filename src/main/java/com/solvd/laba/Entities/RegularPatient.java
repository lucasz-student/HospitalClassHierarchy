package com.solvd.laba.Entities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.solvd.laba.Utils.Days;
import com.solvd.laba.Utils.Sickness;
import com.solvd.laba.Utils.Utils;

public class RegularPatient implements Patient{
	private String name;
	private int age; 
	private Sickness sick; 
	private String reasonForVisit;
	
	public RegularPatient(String name, int age, Sickness sick, String reasonForVisit) {
		this.name = name; 
		this.age = age;
		this.sick = sick;
		this.reasonForVisit = reasonForVisit;
	}
	
	public void setSick(Sickness sick) {
		this.sick = sick; 
	}
	
	public String getName() { 
		return this.name;
	}
	
	public int getAge() {
		return this.age; 
	}
	
	public Sickness getSick() {
		return this.sick;
	}
	
	public String getReasonForVisit() {
		return this.reasonForVisit;
	}

	@Override
	public void checkIn() {
		System.out.println("My name is " + this.name + " and I am checking in for: " + this.reasonForVisit + "\n");
		
	}

	@Override
	public void checkOut() {
		System.out.println("My name is " + this.name + " and I am checking in out\n");
		
	}

	@Override
	public void fillOutPatientForm(String time, Days day) throws IOException{
		String age = Integer.toString(this.age);
		Utils.logger.info("Logging Patient's name to Patient file: " + this.name);
		BasicPatientForm form = new BasicPatientForm(this.name, age, this.reasonForVisit, time, day);
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(Utils.patientList, true));) {
			writer.write("\n" + form.returnForm());
		} catch (IOException e) {
			e.printStackTrace();
		}
		form.printForm();
	}
}

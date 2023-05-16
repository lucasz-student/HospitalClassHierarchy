package com.solvd.laba.Patients;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

import com.solvd.laba.MedicalForms.AppointmentForm;
import com.solvd.laba.MedicalForms.BasicPatientForm;
import com.solvd.laba.MedicalWorkers.Nurse;
import com.solvd.laba.Utils.Utils;

public class CheckupPatient implements Patient{
	private String name;
	private int age; 
	private boolean sick; 
	private String reasonForVisit;
	
	public CheckupPatient(String name, int age, boolean sick, String reasonForVisit) {
		this.name = name; 
		this.age = age;
		this.sick = sick;
		this.reasonForVisit = reasonForVisit;
	}
	
	public void setSick(boolean sick) {
		this.sick = sick; 
	}
	
	public String getName() { 
		return this.name;
	}
	
	public int getAge() {
		return this.age; 
	}
	
	public boolean getSick() {
		return this.sick;
	}
	
	public AppointmentForm scheduleAppointmentWithNurse(Nurse nurse, String time, String sick) throws IOException {
		String age = Integer.toString(this.age);
		if (this.sick) { 
			sick = "Sick";
		} else {
			sick = "Not sick";
		}
		AppointmentForm appointmentForm = new AppointmentForm(age, this.name, time, sick, this.reasonForVisit);
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(Utils.appointmentList, true));
		try  {
			Utils.logger.info("Logging Name Patient to Appointment file: " + this.name);
			writer.write("\n" + appointmentForm.returnForm());
		} catch (IOException e) {
			e.printStackTrace();
		} finally { 
			writer.close();
		}
		
		return appointmentForm;
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
	public void fillOutPatientForm(String time) throws IOException{
		String age = Integer.toString(this.age);
		Utils.logger.info("Logging Patient's name to Patient file: " + this.name);
		BasicPatientForm form = new BasicPatientForm(this.name, age, this.reasonForVisit, time);
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(Utils.patientList, true));) {
			writer.write("\n" + form.returnForm());
		} catch (IOException e) {
			e.printStackTrace();
		}
		form.printForm();
	}

}

package Entities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.solvd.laba.Utils.Days;
import com.solvd.laba.Utils.Utils;

public class RegularPatient implements Patient{
	private String name;
	private int age; 
	private boolean sick; 
	private String reasonForVisit;
	
	public RegularPatient(String name, int age, boolean sick, String reasonForVisit) {
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
	
	public AppointmentForm scheduleAppointmentWithNurse(Nurse nurse, String time, String sick, Days day) throws IOException {
		String age = Integer.toString(this.age);
		if (this.sick) { 
			sick = "Sick";
		} else {
			sick = "Not sick";
		}
		AppointmentForm appointmentForm = new AppointmentForm(age, this.name, time, sick, this.reasonForVisit, day);
		
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

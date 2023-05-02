package com.solvd.laba.Tools;

import java.util.Random;

import com.solvd.laba.Exceptions.ToolPermissionDeniedException;
import com.solvd.laba.Exceptions.UnequippedToolException;
import com.solvd.laba.MedicalWorkers.Doctor;
import com.solvd.laba.Patients.CheckupPatient;
import com.solvd.laba.Utils.Utils;

public final class Thermometer implements Tools{

	static {
		System.out.print("This Thermometer can only be owned and operated by a Doctor; please Equip the tool to use\n");
	};
	
	private String useLocation;
	private int toolAge;
	private boolean equipped;
	private Doctor owner;
	
	public Thermometer(String useLocation, int toolAge, Doctor owner) {
		this.useLocation = useLocation;
		this.toolAge = toolAge;
		this.equipped = false;
		this.owner = owner;
	}
	
	public void setAge(int age) { 
		this.toolAge = age;
	}
	
	public String getUseLocation() {
		return this.useLocation;
	}
	
	
	public String measureTemp() throws UnequippedToolException {
		if (this.equipped) {
		String[] arrayTemp = {"high", "normal", "low"};
		Random random = new Random(); 
		int index = random.nextInt(arrayTemp.length);
		return arrayTemp[index];
		}
		else {
			throw new UnequippedToolException("Tool Unequipped");
		}
	}
	
	public void measureTemp(CheckupPatient patient, Doctor doctor) throws UnequippedToolException {
		if (this.equipped) {
		int min = 30; 
		int max = 43;
		double randomfloatTemp = Math.floor(Math.random() *(max - min + 1) + min); 
		String randomStringTemp = String.valueOf(randomfloatTemp);
		System.out.println("\nHello, " + patient.getName());
		System.out.println("Your temperature is " + randomStringTemp+ " degrees celcius");
		} 
		else {throw new UnequippedToolException("Tool Unequipped");};
	}

	@Override
	public void cleanTool() {
		System.out.print("This tool has been cleaned");
	}
	
	@Override
	public void equipTool(Doctor doctor) throws ToolPermissionDeniedException {
		Utils.logger.fatal("Validating tool Owner...");
		if (doctor.equals(this.owner)) {
			this.equipped = true;
		} else {
			throw new ToolPermissionDeniedException();
		}

}
}

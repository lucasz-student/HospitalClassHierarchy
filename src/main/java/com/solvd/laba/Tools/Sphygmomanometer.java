package com.solvd.laba.Tools;

import java.util.Random;

import com.solvd.laba.Exceptions.ToolPermissionDeniedException;
import com.solvd.laba.Exceptions.UnequippedToolException;
import com.solvd.laba.MedicalWorkers.Doctor;
import com.solvd.laba.Patients.CheckupPatient;
import com.solvd.laba.Utils.Utils;

public final class Sphygmomanometer implements Tools {

	static {
		System.out.print("This Sphygmomanometer can only be owned and operated by a Doctor; please Equip the tool to use\n");
	};
	
	private String machineStyle;
	private int toolAge;
	public boolean equipped;
	private Doctor owner;
	
	public Sphygmomanometer(String machineStyle, int toolAge, Doctor owner) {
	this.machineStyle = machineStyle; 
	this.toolAge = toolAge;
	this.equipped = false;
	this.owner = owner;
	}
	
	public String getStyle() {
		return this.machineStyle; 
	}
	
	public void setAge(int age) {
		this.toolAge = age;
	}
	
	@Override
	public Doctor getOwner() {
		return this.owner;
	}
	
	public String measureBP() throws UnequippedToolException {
		if (this.equipped) {
		String[] arrayBP = {"high", "low", "normal"};
		Random random = new Random(); 
		int index = random.nextInt(arrayBP.length);
		return arrayBP[index];
		}
		else {
			throw new UnequippedToolException("Tool Unequipped");
		}
	}
	
	
	public void measureBP(CheckupPatient patient, Doctor doctor) throws UnequippedToolException {
		if (this.equipped) {
			int min = 30; 
			int max = 150;
			double randomfloatBP = Math.floor(Math.random() *(max - min + 1) + min); 
			String randomStringBP = String.valueOf(randomfloatBP);
			System.out.println("\nHello, " + patient.getName());
			System.out.println("Your blood pressure is " + randomStringBP+ " mmHg"); 
		} else {
			throw new UnequippedToolException("Tool Unequipped");};
	}


	@Override
	public void equipTool() {
		this.equipped = true;
	}
}



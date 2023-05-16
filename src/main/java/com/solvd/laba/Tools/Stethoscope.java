package com.solvd.laba.Tools;

import java.util.Random;

import com.solvd.laba.Exceptions.ToolPermissionDeniedException;
import com.solvd.laba.Exceptions.UnequippedToolException;
import com.solvd.laba.MedicalWorkers.Doctor;
import com.solvd.laba.Patients.CheckupPatient;
import com.solvd.laba.Utils.Utils;

public final class Stethoscope implements Tools {
	
	static {
		System.out.print("This Stethoscope can only be owned and operated by a Doctor; please Equip the tool to use\n");
	};
	
	private boolean clean; 
	private int toolAge;
	public boolean equipped;
	private Doctor owner;
	
	public Stethoscope(boolean clean, int toolAge, Doctor owner) {
		this.clean = clean;
		this.toolAge = toolAge;
		this.equipped = false;
		this.owner = owner;
	}
	
	public int getAge() {
		return this.toolAge;
	}
	
	public void setClean(boolean clean) {
		this.clean = clean;
	}
	
	@Override
	public Doctor getOwner() {
		return this.owner;
	}
	
	public String listen() throws UnequippedToolException {
		if (this.equipped) {
		String[] arraySound = {"poor", "normal"};
		Random random = new Random(); 
		int index = random.nextInt(arraySound.length);
		return arraySound[index];
		} 
		else {
			throw new UnequippedToolException("Tool Unequipped");
		}
	}
	
	public void listen(CheckupPatient patient, Doctor doctor) throws UnequippedToolException {
		if (this.equipped) {
		String[] arraySound = {"poor", "normal"};
		Random random = new Random(); 
		int index = random.nextInt(arraySound.length);
		System.out.println("\nHello, " + patient.getName());
		System.out.println("Your internal sounds are " + arraySound[index] + "");
		} else {throw new UnequippedToolException("Tool Unequipped");};
	}

	@Override
	public void equipTool() {
		this.equipped = true;
	}
}

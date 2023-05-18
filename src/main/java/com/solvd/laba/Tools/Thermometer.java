package com.solvd.laba.Tools;

import java.util.ArrayList;
import java.util.Random;

import com.solvd.laba.Exceptions.UnequippedOrUncleanToolException;

import com.solvd.laba.Utils.Sanitization;
import com.solvd.laba.Utils.ToolReadings;


import Entities.Doctor;
import Entities.RegularPatient;

public final class Thermometer implements Tools{

	static {
		System.out.print("This Thermometer can only be owned and operated by a Doctor; please Equip the tool to use\n");
	};
	
	private String useLocation;
	public boolean equipped;
	private Doctor owner;
	private Sanitization clean;
	
	public Thermometer(String useLocation, int toolAge, Doctor owner) {
		this.useLocation = useLocation;
		this.equipped = false;
		this.owner = owner;
		this.clean = Sanitization.UNCLEAN;
	}
	
	
	public String getUseLocation() {
		return this.useLocation;
	}
	
	@Override
	public Doctor getOwner() {
		return this.owner;
	}
	
	public ToolReadings measureTemp() throws UnequippedOrUncleanToolException {
		if ((this.equipped) && (this.clean == Sanitization.CLEAN)) {
		ArrayList<ToolReadings> arrayTemp = new ArrayList<>();
		arrayTemp.add(ToolReadings.HIGH);
		arrayTemp.add(ToolReadings.NORMAL);
		arrayTemp.add(ToolReadings.LOW);
		Random random = new Random(); 
		int index = random.nextInt(arrayTemp.size());
		return arrayTemp.get(index);
		}
		else {
			throw new UnequippedOrUncleanToolException("Tool Unequipped or Unclean");
		}
	}
	
	public void measureTemp(RegularPatient patient, Doctor doctor) throws UnequippedOrUncleanToolException {
		if ((this.equipped) && (this.clean == Sanitization.CLEAN)) {
		int min = 30; 
		int max = 43;
		double randomfloatTemp = Math.floor(Math.random() *(max - min + 1) + min); 
		String randomStringTemp = String.valueOf(randomfloatTemp);
		System.out.println("\nHello, " + patient.getName());
		System.out.println("Your temperature is " + randomStringTemp+ " degrees celcius");
		} 
		else {
			throw new UnequippedOrUncleanToolException("Tool Unequipped or Unclean");
		}
	}

	@Override
	public void equipTool() {
		this.equipped = true;
	}
	
	@Override
	public void cleanTool() {
		if (CleaningQueue.peek() == this) {
		System.out.print("\nThis tool has been cleaned");
		this.clean = Sanitization.CLEAN;
		CleaningQueue.poll();
		} else {
			System.out.print("\nThis tool is not next in the queue line");
		}
	}
}

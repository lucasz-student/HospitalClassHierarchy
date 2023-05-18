package com.solvd.laba.Tools;

import java.util.ArrayList;
import java.util.Random;

import com.solvd.laba.Exceptions.UnequippedOrUncleanToolException;
import com.solvd.laba.Utils.Sanitization;
import com.solvd.laba.Utils.ToolReadings;

import Entities.Doctor;
import Entities.RegularPatient;

public final class Sphygmomanometer implements Tools {

	static {
		System.out.print("This Sphygmomanometer can only be owned and operated by a Doctor; please Equip the tool to use\n");
	};
	
	private String machineStyle;
	public boolean equipped;
	private Doctor owner;
	private Sanitization clean;
	
	public Sphygmomanometer(String machineStyle, int toolAge, Doctor owner) {
	this.machineStyle = machineStyle; 
	this.equipped = false;
	this.owner = owner;
	this.clean = Sanitization.UNCLEAN;
	}
	
	public String getStyle() {
		return this.machineStyle; 
	}

	
	@Override
	public Doctor getOwner() {
		return this.owner;
	}
	
	public ToolReadings measureBP() throws UnequippedOrUncleanToolException {
		if ((this.equipped) && (this.clean == Sanitization.CLEAN)) {
		ArrayList<ToolReadings> arrayBP = new ArrayList<>();
		arrayBP.add(ToolReadings.HIGH);
		arrayBP.add(ToolReadings.NORMAL);
		arrayBP.add(ToolReadings.LOW);
		Random random = new Random(); 
		int index = random.nextInt(arrayBP.size());
		return arrayBP.get(index);
		}
		else {
			throw new UnequippedOrUncleanToolException("Tool Unequipped or Unclean");
		}
	}
	
	public void measureBP(RegularPatient patient, Doctor doctor) throws UnequippedOrUncleanToolException {
		if ((this.equipped) && (this.clean == Sanitization.CLEAN)) {
			int min = 30; 
			int max = 150;
			double randomfloatBP = Math.floor(Math.random() *(max - min + 1) + min); 
			String randomStringBP = String.valueOf(randomfloatBP);
			System.out.println("\nHello, " + patient.getName());
			System.out.println("Your blood pressure is " + randomStringBP+ " mmHg"); 
		} else {
			throw new UnequippedOrUncleanToolException("Tool Unequipped or Unclean");};
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



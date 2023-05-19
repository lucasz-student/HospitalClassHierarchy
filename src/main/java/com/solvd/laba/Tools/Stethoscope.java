package com.solvd.laba.Tools;

import java.util.ArrayList;
import java.util.Random;

import com.solvd.laba.Exceptions.UnequippedOrUncleanToolException;
import com.solvd.laba.Utils.Sanitization;
import com.solvd.laba.Utils.ToolReadings;

import Entities.Doctor;
import Entities.RegularPatient;

public final class Stethoscope implements Tools {
	
	static {
		System.out.print("This Stethoscope can only be owned and operated by a Doctor; please Equip the tool to use\n");
	};
	
	private int toolAge;
	public boolean equipped;
	private Doctor owner;
	private Sanitization clean;
	
	public Stethoscope(int toolAge, Doctor owner) {
		this.toolAge = toolAge;
		this.equipped = false;
		this.owner = owner;
		this.clean = Sanitization.UNCLEAN;
	}
	
	public int getAge() {
		return this.toolAge;
	}
	
	public void setClean(Sanitization clean) {
		this.clean = clean;
	}
	
	@Override
	public Doctor getOwner() {
		return this.owner;
	}
	
	public ToolReadings listen() throws UnequippedOrUncleanToolException {
		if ((this.equipped) && (this.clean == Sanitization.CLEAN)) {
		ArrayList<ToolReadings> arraySound = new ArrayList<>();
		arraySound.add(ToolReadings.POOR);
		arraySound.add(ToolReadings.NORMAL);
		Random random = new Random(); 
		int index = random.nextInt(arraySound.size());
		return arraySound.get(index);
		}
		else {
			throw new UnequippedOrUncleanToolException("Tool Unequipped or Unclean");
		}
	}
	
	public void listen(RegularPatient patient, Doctor doctor) throws UnequippedOrUncleanToolException {
		if ((this.equipped) && (this.clean == Sanitization.CLEAN)) {
		String[] arraySound = {"poor", "normal"};
		Random random = new Random(); 
		int index = random.nextInt(arraySound.length);
		System.out.println("\nHello, " + patient.getName());
		System.out.println("Your internal sounds are " + arraySound[index] + "");
		} else {
			throw new UnequippedOrUncleanToolException("Tool Unequipped or Unclean");
		}
	}

	@Override
	public void cleanTool() {
		if (CleaningQueue.peek() == this) {
		System.out.print("\nThis tool has been cleaned\n");
		this.clean = Sanitization.CLEAN;
		CleaningQueue.poll();
		} else {
			System.out.print("\nThis tool is not next in the queue line");
		}
	}
}

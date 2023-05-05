package com.solvd.laba.MedicalWorkers;

import com.solvd.laba.Utils.LinkedListNotepad;

public class Intern extends MedicalEmployee{
	
	private LinkedListNotepad<String> notesJournal = new LinkedListNotepad<>();
	
	public Intern(String name, int age, int employeeID, String branchOfHospital) {
		super(name, age, employeeID, branchOfHospital);
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getId() {
		return this.medicalID;
	}
	
	public void setBranch(String branch) { 
		this.branchOfHospital = branch;
	}
	
	
	public void identifySelf() {
		System.out.println("Hello my name is " + this.branchOfHospital + ", my ID is " + this.employeeId + " and I work in branch: " + this.branchOfHospital);
	}
	
	public void takeNotesInJournal(int pageNumber, String notes) {
		this.notesJournal.add(pageNumber, notes);
	}
	
	public void takeNotesInJournal(String notes) {
		this.notesJournal.add(notes);
	}
	
	public void tearPage(int pageNumber) {
		this.notesJournal.remove(pageNumber);
	}
	
	public void openNotePad() {
		this.notesJournal.displayList();
	}
}

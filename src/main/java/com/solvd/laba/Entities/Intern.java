package com.solvd.laba.Entities;

import java.util.function.Function;

import com.solvd.laba.Utils.BranchesOfHospital;
import com.solvd.laba.Utils.LinkedListNotepad;

public class Intern extends MedicalEmployee{
	
	private LinkedListNotepad<String> notesJournal = new LinkedListNotepad<>();
	
	public Intern(String name, int age, BranchesOfHospital branchOfHospital) {
		super(name, age, branchOfHospital);
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getId() {
		return this.medicalID;
	}
	
	public void identifySelf() {
		System.out.println("Hello my name is " + this.branchOfHospital + ",  and I work in branch: " + this.branchOfHospital);
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
	
	public void changeAllNoteValues(Function<String, String> function) {
		this.notesJournal.changeAllNodeValues(function);
	}
}

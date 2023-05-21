package com.solvd.laba.Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.solvd.laba.Utils.BranchesOfHospital;

public class Nurse extends MedicalEmployee {

	private List<RegularPatient> patientList = new ArrayList<>();
	
	public Nurse(String name, int age, BranchesOfHospital branch) { 
		super(name, age, branch);
	}
	
	public String getName() {
		return this.name;
	}
	
	public void addPatient(RegularPatient patient) {
		patientList.add(patient);
	}
	
	public List<RegularPatient> getPatientList() {
		return this.patientList;
	}
	
	public List<RegularPatient> getPatientBySickness(boolean isSick) {
		List<RegularPatient> filteredList = this.patientList.stream()
				.filter((RegularPatient patient) -> (patient.getSick().getOverallSickStatus() == isSick))
				.collect(Collectors.toList());	
		return filteredList;
	}
	
	public List<RegularPatient> getPatientsOlderThanAge(int age) {
		List<RegularPatient> filteredList = this.patientList.stream()
				.filter((RegularPatient patient) -> (patient.getAge() > age))
				.collect(Collectors.toList());	
		return filteredList;
	}
}

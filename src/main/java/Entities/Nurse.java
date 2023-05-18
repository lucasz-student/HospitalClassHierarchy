package Entities;

import java.util.ArrayList;
import java.util.List;

import com.solvd.laba.Utils.BranchesOfHospital;

public class Nurse extends MedicalEmployee {

	private List<Patient> patientList = new ArrayList<>();
	
	public Nurse(String name, int age, BranchesOfHospital branch) { 
		super(name, age, branch);
	}
	
	public String getName() {
		return this.name;
	}
	
	public void addPatient(Patient patient) {
		patientList.add(patient);
	}
	
	public List<Patient> getPatientList() {
		return this.patientList;
	}
}

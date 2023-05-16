package com.solvd.laba.MedicalWorkers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.solvd.laba.MedicalForms.MedicalForms;
import com.solvd.laba.Utils.Utils;

public abstract class MedicalEmployee {

	protected String name;
	protected int age;
	protected int medicalID;
	protected String branchOfHospital;
	public static HashMap<String, Integer> employeeMap = new HashMap<>();
	public static Set<String> uniqueBranches = new HashSet<>();
	
	
	public MedicalEmployee(String name, int age, String Branch) {
		this.name = name;
		this.age = age;
		this.branchOfHospital = Branch;
		this.medicalID = this.name.length() * age;
		
		MedicalEmployee.employeeMap.put(name, medicalID);
		Utils.logger.info("New MedicalEmployee mapped" +  MedicalEmployee.employeeMap);
		MedicalEmployee.uniqueBranches.add(Branch);
	}
	
	public static void printAllEmployees() {
		MedicalEmployee.employeeMap.forEach((k,v) 
				-> System.out.println(k + " : " + v));
	}
	
	public static void printUniqueBranches() {
		for (String branch: MedicalEmployee.uniqueBranches) {
			System.out.println(branch);
		}
	}
	
	@Override
	public String toString() {
		return "Hi, I'm " + this.name;
	}
	
	@Override
	public int hashCode() {
		return this.medicalID;
	}
	
	@Override 
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
        if((obj == null) || (obj.getClass()!= this.getClass())) {
            return false;
        }
		if ((obj.hashCode() == this.hashCode()) && (obj.toString() == this.toString())) {
			return true;
		}
		return false;
	}
}

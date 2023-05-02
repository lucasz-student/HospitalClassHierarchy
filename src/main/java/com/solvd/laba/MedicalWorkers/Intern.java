package com.solvd.laba.MedicalWorkers;

public class Intern {
	

	private String branchOfHospital; 
	private String name;
	private String employeeId; 
	private String role;
	
	public Intern(String name, String branchOfHospital, String employeeID, String role) {
		this.employeeId = employeeID;
		this.branchOfHospital = branchOfHospital;
		this.name = name;
		this.role = role;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getId() {
		return this.employeeId;
	}
	
	
	public void setBranch(String branch) { 
		this.branchOfHospital = branch;
	}
	
	public void setRole(String role) { 
		this.role = role;
	}
	
	
	
	public void identifySelf() {
		System.out.println("Hello my name is " + this.branchOfHospital + ", my ID is " + this.employeeId + " and I work in branch: " + this.branchOfHospital);
	}
}

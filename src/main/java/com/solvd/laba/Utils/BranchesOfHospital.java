package com.solvd.laba.Utils;

public enum BranchesOfHospital {
	NEUROLOGY("Brain health, brain scans, neurosurgeries"),
	URGENTCARE("For Urgent but not emergency care"),
	GENERALCARE("General Checkups and illnesses"),
	ORTHODONTICS("Bone health and sports medicine"),
	PSYCHOLOGY("Mental Health and mental illnesses"),
	UROLOGY("Bladder health");
	
	private String description;
	
	BranchesOfHospital(String d) {
		this.setDescription(d);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}

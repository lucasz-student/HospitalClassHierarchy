package com.solvd.laba.Utils;

public enum Sickness {
	ISSICK("Patient is Ill: Please diagnose and prescribe medicine", ToolReadings.UNDIAGNOSED, ToolReadings.UNDIAGNOSED, ToolReadings.UNDIAGNOSED, false), 
	ISNOTSICK("Patient is not Ill", ToolReadings.UNDIAGNOSED, ToolReadings.UNDIAGNOSED, ToolReadings.UNDIAGNOSED, false); 
	
	private String illnessDescription;
	private ToolReadings temperature;
	private ToolReadings bloodPressure; 
	private ToolReadings heartAndLungs;
	private boolean medicinePrescribed;
	
	Sickness(String desc, ToolReadings temp, ToolReadings BP, ToolReadings internalSounds, boolean presc) {
		this.setIllnessDescription(desc);
		this.setTemperature(temp);
		this.setBloodPressure(BP);
		this.setHeartAndLungs(internalSounds);
		this.setMedicinePrescribed(presc); 
	}

	public String getIllnessDescription() {
		return illnessDescription;
	}

	public void setIllnessDescription(String illnessDescription) {
		this.illnessDescription = illnessDescription;
	}

	public ToolReadings getTemperature() {
		return temperature;
	}

	public void setTemperature(ToolReadings temperature) {
		this.temperature = temperature;
	}

	public ToolReadings getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(ToolReadings bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public ToolReadings getHeartAndLungs() {
		return heartAndLungs;
	}

	public void setHeartAndLungs(ToolReadings heartAndLungs) {
		this.heartAndLungs = heartAndLungs;
	}

	public boolean isMedicinePrescribed() {
		return medicinePrescribed;
	}

	public void setMedicinePrescribed(boolean medicinePrescribed) {
		this.medicinePrescribed = medicinePrescribed;
	}
	
	public boolean getOverallSickStatus() {
		if ((this.bloodPressure != ToolReadings.NORMAL) || (this.heartAndLungs != ToolReadings.NORMAL) || (this.temperature != ToolReadings.NORMAL)) {
			return true;
		} 
		return false;
	}
}

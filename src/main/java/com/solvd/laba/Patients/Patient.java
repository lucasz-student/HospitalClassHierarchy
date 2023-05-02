package com.solvd.laba.Patients;

import java.io.IOException;

public interface Patient {

	public void checkIn();
	
	public void checkOut();

	public void fillOutPatientForm(String time) throws IOException;
}

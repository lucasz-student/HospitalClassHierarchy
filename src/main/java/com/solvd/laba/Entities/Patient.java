package com.solvd.laba.Entities;

import java.io.IOException;

import com.solvd.laba.Utils.Days;

public interface Patient {

	public void checkIn();
	
	public void checkOut();

	public void fillOutPatientForm(String time, Days day) throws IOException;
	
}

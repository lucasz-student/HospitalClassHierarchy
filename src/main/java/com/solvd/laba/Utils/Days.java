package com.solvd.laba.Utils;

public enum Days {
	MONDAY("6:00am-12:00am"),
	TUESDAY("6:00am-12:00am"),
	WEDNESDAY("6:00am-12:00am"),
	THURSDAY("6:00am-12:00am"),
	FRIDAY("6:00am-10:00am");
	
	private String hoursOpen;
	
	Days(String hoursOpen) {
		this.hoursOpen = hoursOpen;
	}
	
	public String getHoursOpen() {
		return this.hoursOpen;
	}
}

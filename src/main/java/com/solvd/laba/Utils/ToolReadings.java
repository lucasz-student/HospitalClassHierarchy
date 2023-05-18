package com.solvd.laba.Utils;

public enum ToolReadings {

	POOR(0),
	LOW(0),
	NORMAL(1),
	HIGH(2);
	
	private int ReadingCode; 
	
	ToolReadings(int ReadingCode) {
		this.ReadingCode = ReadingCode;
	}
	
	public int getReadingCode() {
		return this.ReadingCode;
	}
}

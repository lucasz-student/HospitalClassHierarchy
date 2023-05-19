package com.solvd.laba.Utils;

public enum ToolReadings {
	
	UNDIAGNOSED(0),
	POOR(1),
	LOW(2),
	NORMAL(3),
	HIGH(4);
	
	private int ReadingCode; 
	
	ToolReadings(int ReadingCode) {
		this.ReadingCode = ReadingCode;
	}
	
	public int getReadingCode() {
		return this.ReadingCode;
	}
}

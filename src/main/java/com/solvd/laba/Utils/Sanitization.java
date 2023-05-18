package com.solvd.laba.Utils;

public enum Sanitization {

	CLEAN(true),
	UNCLEAN(false);
	
	private boolean usability;
	
	Sanitization(boolean u) {
		this.usability = u; 
	}
	
	public boolean getUsability() {
		return this.usability;
	}
}

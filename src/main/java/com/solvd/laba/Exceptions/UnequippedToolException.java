package com.solvd.laba.Exceptions;

import com.solvd.laba.Utils.Utils;

public class UnequippedToolException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public UnequippedToolException() {
		Utils.logger.warn("Call Doctor method to equip tool");
	}

	public UnequippedToolException(String message) {
		super(message);
		Utils.logger.warn("Call Doctor method to equip tool");
	}
	
	public UnequippedToolException(String message, Throwable cause) {
		super(message, cause);
		Utils.logger.warn("Call Doctor method to equip tool");
	}
}
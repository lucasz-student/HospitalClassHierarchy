package com.solvd.laba.Exceptions;

import com.solvd.laba.Utils.Utils;

public class UnequippedOrUncleanToolException extends Exception{

	public UnequippedOrUncleanToolException() {
		Utils.logger.warn("Call Doctor method to equip tool");
	}

	public UnequippedOrUncleanToolException(String message) {
		super(message);
		Utils.logger.warn("Call Doctor method to equip tool");
	}
	
	public UnequippedOrUncleanToolException(String message, Throwable cause) {
		super(message, cause);
		Utils.logger.warn("Call Doctor method to equip tool");
	}
}
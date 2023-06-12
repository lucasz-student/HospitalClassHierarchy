package com.solvd.laba.Exceptions;

import com.solvd.laba.Utils.Utils;

public class ToolPermissionDeniedException extends Exception {

	
	public ToolPermissionDeniedException() {
		}
	
	public ToolPermissionDeniedException(String message) {
		super(message);
		Utils.logger.warn(message);
	}
	
	public ToolPermissionDeniedException(String message, Throwable cause) {
		super(message, cause);
		Utils.logger.warn(message);
	}
	
	public ToolPermissionDeniedException(String message, Object object) {
		super(message);
		Utils.logger.warn(Object.class + " Tried to equip Tool");
	}
}
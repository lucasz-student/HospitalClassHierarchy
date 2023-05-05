package com.solvd.laba.Exceptions;

import com.solvd.laba.Utils.Utils;

public class ToolPermissionDeniedException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ToolPermissionDeniedException() {
	}
	
	public ToolPermissionDeniedException(String message) {
		super(message);
	}
	
	public ToolPermissionDeniedException(String message, Throwable cause) {
		super(message, cause);
	}
}
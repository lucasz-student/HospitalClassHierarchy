package com.solvd.laba.Tools;

import com.solvd.laba.Exceptions.ToolPermissionDeniedException;
import com.solvd.laba.MedicalWorkers.Doctor;

public interface Tools {

	public static final String ownerPermisson = "Doctor";
	
	public void cleanTool();

	public void equipTool(Doctor doctor) throws ToolPermissionDeniedException;
}

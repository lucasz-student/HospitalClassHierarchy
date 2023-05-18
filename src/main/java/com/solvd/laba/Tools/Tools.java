package com.solvd.laba.Tools;

import java.util.LinkedList;
import java.util.Queue;

import Entities.Doctor;

public interface Tools {
	
	public static final Queue<Tools> CleaningQueue = new LinkedList<Tools>();

	public static final String ownerPermisson = "Doctor";
	
	default public void joinCleanLine() {
		CleaningQueue.add(this);
	};
	
	public void cleanTool();

	public void equipTool();
	
	public Doctor getOwner();
	

}

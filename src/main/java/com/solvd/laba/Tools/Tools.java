package com.solvd.laba.Tools;

import java.util.LinkedList;
import java.util.Queue;

import com.solvd.laba.Exceptions.ToolPermissionDeniedException;
import com.solvd.laba.MedicalWorkers.Doctor;

public interface Tools {
	
	public static final Queue<Tools> CleaningQueue = new LinkedList<Tools>();

	public static final String ownerPermisson = "Doctor";
	
	default public void joinCleanLine() {
		CleaningQueue.add(this);
	};
	
	default public void cleanTool() {
		if (CleaningQueue.peek() == this) {
		System.out.print("\nThis tool has been cleaned");
		CleaningQueue.poll();
		} else {
			System.out.print("\nThis tool is not next in the queue line");
		}
	};

	public void equipTool();
	
	public Doctor getOwner();
	

}

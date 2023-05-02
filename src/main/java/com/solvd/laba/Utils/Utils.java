package com.solvd.laba.Utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.laba.InstantiateObjects;


public class Utils {
	
	public static Logger logger = LogManager.getLogger(InstantiateObjects.class);
	
	public static final String patientList = "C:/Users/lucas/OneDrive/Desktop/MavenHierarchy/my-app/src/main/java/outputFiles/PatientList.txt";
	public static final String appointmentList = "C:/Users/lucas/OneDrive/Desktop/MavenHierarchy/my-app/src/main/java/outputFiles/AppointmentList.txt";
	
	public static boolean checkFileForString(String filePath, String target) throws IOException {
		
		try(BufferedReader reader = new BufferedReader(new FileReader(filePath));) {
			
			String line = reader.readLine();
			while (line != null) {
				if (line.contains(target)) {
					return true;
				}
			line = reader.readLine();
			}
			return false;
		} 
		
	}
	
	public static void flushOutput() throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(Utils.patientList);
		PrintWriter writer1 = new PrintWriter(Utils.appointmentList);
		writer.print("");
		writer1.print("");
		writer.close();
		writer1.close();
	}
	
	
}

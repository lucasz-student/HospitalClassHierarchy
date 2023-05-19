package com.solvd.laba.Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.laba.Main;


public class Utils {
	
	public static Logger logger = LogManager.getLogger(Main.class);
	
	public static final String patientList = "C:/Users/lucas/OneDrive/Desktop/MavenHierarchy/my-app/src/main/java/outputFiles/PatientList.txt";
	public static final String appointmentList = "C:/Users/lucas/OneDrive/Desktop/MavenHierarchy/my-app/src/main/java/outputFiles/AppointmentList.txt";
	public static final String uniqueWordsFile = "C:/Users/lucas/OneDrive/Desktop/MavenHierarchy/my-app/src/main/java/com/solvd/laba/Utils/uniqueWordsTest";
	public static final String uniqueWordsResultFile = "C:/Users/lucas/OneDrive/Desktop/MavenHierarchy/my-app/src/main/java/com/solvd/laba/Utils/uniqueWordsResult";
	
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
	
	public static void flushOutput() throws IOException {
		FileUtils.writeStringToFile(new File(appointmentList), "");
		FileUtils.writeStringToFile(new File(patientList), "");
		FileUtils.writeStringToFile(new File(uniqueWordsResultFile), "");
	} 
	
	public static void readFile(String filePath) throws IOException{
		String fileContent = FileUtils.readFileToString(new File(filePath), 
				Charset.forName("UTF-8"));
		System.out.println(fileContent);
	} 
	
	public static void uniqueWordsInFile(String filePath, String destinationPath) throws IOException {
		Set<String> uniqueWords = new HashSet<>();
		String fileContent = FileUtils.readFileToString((new File(filePath)), 
				Charset.forName("UTF-8"));
		String[] arr = fileContent.split("\n");
		for (String i : arr) {
			String[] arr1 = i.split(" ");
			for (String k : arr1) {
				if ((k!=" ") && (k!="") && (k!="\n")) {
					uniqueWords.add(k);
				}
			}
		}
		
		FileUtils.writeStringToFile((new File(destinationPath)), ("\n" + uniqueWords.size()), true);
		
		uniqueWords.forEach((String string) -> {
			try {
				FileUtils.writeStringToFile((new File(destinationPath)), "\n" + string, true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
}

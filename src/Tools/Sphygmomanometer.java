package Tools;

import java.util.Random;

import HospitalClassHierarchy.Doctor;
import HospitalClassHierarchy.GeneralPatient;
import HospitalClassHierarchy.Tool;

public class Sphygmomanometer implements Tools {

	static {
		System.out.print("This Sphygmomanometer can only be owned and operated by a Doctor");
	};
	
	private String machineStyle;
	private int toolAge;
	
	public Sphygmomanometer(String machineStyle, int toolAge) {
	this.machineStyle = machineStyle; 
	this.toolAge = toolAge;
	}
	
	public String getStyle() {
		return this.machineStyle; 
	}
	
	public void setAge(int age) {
		this.toolAge = age;
	}
	public String measureBP() {
		String[] arrayBP = {"high", "low", "normal"};
		Random random = new Random(); 
		int index = random.nextInt(arrayBP.length);
		return arrayBP[index];
	}
	
	
	public void measureBP(GeneralPatient patient, Doctor doctor) {
		int min = 30; 
		int max = 150;
		double randomfloatBP = Math.floor(Math.random() *(max - min + 1) + min); 
		String randomStringBP = String.valueOf(randomfloatBP);
		System.out.println("\nHello, " + patient.getName());
		System.out.println("Your blood pressure is " + randomStringBP+ " mmHg");
	}

	@Override
	public void cleanTool() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void equipTool() {
		// TODO Auto-generated method stub
		
	}

	}



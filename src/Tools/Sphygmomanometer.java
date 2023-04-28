package Tools;

import java.util.Random;

import MedicalWorkers.Doctor;
import MedicalWorkers.Tool;
import Patients.CheckupPatient;

public class Sphygmomanometer implements Tools {

	static {
		System.out.print("This Sphygmomanometer can only be owned and operated by a Doctor; please Equip the tool to use\n");
	};
	
	private String machineStyle;
	private int toolAge;
	private boolean equipped;
	
	public Sphygmomanometer(String machineStyle, int toolAge) {
	this.machineStyle = machineStyle; 
	this.toolAge = toolAge;
	this.equipped = false;
	}
	
	public String getStyle() {
		return this.machineStyle; 
	}
	
	public void setAge(int age) {
		this.toolAge = age;
	}
	public String measureBP() {
		if (this.equipped) {
		String[] arrayBP = {"high", "low", "normal"};
		Random random = new Random(); 
		int index = random.nextInt(arrayBP.length);
		return arrayBP[index];
		}
		else {
			return null;
		}
	}
	
	
	public void measureBP(CheckupPatient patient, Doctor doctor) {
		if (this.equipped) {
		int min = 30; 
		int max = 150;
		double randomfloatBP = Math.floor(Math.random() *(max - min + 1) + min); 
		String randomStringBP = String.valueOf(randomfloatBP);
		System.out.println("\nHello, " + patient.getName());
		System.out.println("Your blood pressure is " + randomStringBP+ " mmHg"); 
		}
	}

	@Override
	public void cleanTool() {
		System.out.print("This tool has been cleaned");
		
	}

	@Override
	public void equipTool() {
		this.equipped = true;
		
	}

	}



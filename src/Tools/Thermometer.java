package Tools;

import java.util.Random;

import MedicalWorkers.Doctor;
import Patients.CheckupPatient;

public final class Thermometer implements Tools{

	static {
		System.out.print("This Thermometer can only be owned and operated by a Doctor; please Equip the tool to use\n");
	};
	
	private String useLocation;
	private int toolAge;
	private boolean equipped;
	
	public Thermometer(String useLocation, int toolAge) {
		this.useLocation = useLocation;
		this.toolAge = toolAge;
		this.equipped = false;
	}
	
	public void setAge(int age) { 
		this.toolAge = age;
	}
	
	public String getUseLocation() {
		return this.useLocation;
	}
	
	
	public String measureTemp() {
		if (this.equipped) {
		String[] arrayTemp = {"high", "normal", "low"};
		Random random = new Random(); 
		int index = random.nextInt(arrayTemp.length);
		return arrayTemp[index];
		}
		else {
			return null;
		}
	}
	
	public void measureTemp(CheckupPatient patient, Doctor doctor) {
		if (this.equipped) {
		int min = 30; 
		int max = 43;
		double randomfloatTemp = Math.floor(Math.random() *(max - min + 1) + min); 
		String randomStringTemp = String.valueOf(randomfloatTemp);
		System.out.println("\nHello, " + patient.getName());
		System.out.println("Your temperature is " + randomStringTemp+ " degrees celcius");
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

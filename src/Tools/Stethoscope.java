package Tools;

import java.util.Random;

import MedicalWorkers.Doctor;
import MedicalWorkers.Tool;
import Patients.CheckupPatient;

public class Stethoscope implements Tools {
	
	static {
		System.out.print("This Stethoscope can only be owned and operated by a Doctor; please Equip the tool to use\n");
	};
	
	private boolean clean; 
	private int toolAge;
	private boolean equipped;
	
	public Stethoscope(boolean clean, int toolAge) {
		this.clean = clean;
		this.toolAge = toolAge;
		this.equipped = false;
	}
	
	public int getAge() {
		return this.toolAge;
	}
	
	public void setClean(boolean clean) {
		this.clean = clean;
	}
	
	public String listen() {
		if (this.equipped) {
		String[] arraySound = {"poor", "normal"};
		Random random = new Random(); 
		int index = random.nextInt(arraySound.length);
		return arraySound[index];
		} 
		else {
			return null;
		}
	}
	
	public void listen(CheckupPatient patient, Doctor doctor) {
		if (this.equipped) {
		String[] arraySound = {"poor", "normal"};
		Random random = new Random(); 
		int index = random.nextInt(arraySound.length);
		
		System.out.println("\nHello, " + patient.getName());
		System.out.println("Your internal sounds are " + arraySound[index] + "");
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

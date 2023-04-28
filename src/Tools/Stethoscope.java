package Tools;

import java.util.Random;

import HospitalClassHierarchy.Doctor;
import HospitalClassHierarchy.GeneralPatient;
import HospitalClassHierarchy.Tool;

public class Stethoscope implements Tools {
	
	static {
		System.out.print("This Stethoscope can only be owned and operated by a Doctor");
	};
	
	private boolean clean; 
	private int toolAge;
	
	public Stethoscope(boolean clean, int toolAge) {
		this.clean = clean;
		this.toolAge = toolAge;
	}
	
	public int getAge() {
		return this.toolAge;
	}
	
	public void setClean(boolean clean) {
		this.clean = clean;
	}
	
	public String listen() {
		String[] arraySound = {"poor", "normal"};
		Random random = new Random(); 
		int index = random.nextInt(arraySound.length);
		return arraySound[index];
	}
	
	public void listen(GeneralPatient patient, Doctor doctor) {
		String[] arraySound = {"poor", "normal"};
		Random random = new Random(); 
		int index = random.nextInt(arraySound.length);
		
		System.out.println("\nHello, " + patient.getName());
		System.out.println("Your internal sounds are " + arraySound[index] + "");
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

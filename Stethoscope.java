package HospitalClassHierarchy;

import java.util.Random;

public class Stethoscope {
	
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
	
	public void listen(Patient patient, Doctor doctor) {
		String[] arraySound = {"poor", "normal"};
		Random random = new Random(); 
		int index = random.nextInt(arraySound.length);
		
		System.out.println("\nHello, " + patient.getName());
		System.out.println("Your internal sounds are " + arraySound[index] + "");
	}

}

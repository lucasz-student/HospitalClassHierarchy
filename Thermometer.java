package HospitalClassHierarchy;

import java.util.Random;

public class Thermometer {

	private String useLocation;
	private int toolAge;
	
	public Thermometer(String useLocation, int toolAge) {
		this.useLocation = useLocation;
		this.toolAge = toolAge;
	}
	
	public void setAge(int age) { 
		this.toolAge = age;
	}
	
	public String getUseLocation() {
		return this.useLocation;
	}
	
	
	public String measureTemp() {
		String[] arrayTemp = {"high", "normal", "low"};
		Random random = new Random(); 
		int index = random.nextInt(arrayTemp.length);
		return arrayTemp[index];
	}
	
	public void measureTemp(Patient patient, Doctor doctor) {
		int min = 30; 
		int max = 43;
		double randomfloatTemp = Math.floor(Math.random() *(max - min + 1) + min); 
		String randomStringTemp = String.valueOf(randomfloatTemp);
		System.out.println("\nHello, " + patient.getName());
		System.out.println("Your temperature is " + randomStringTemp+ " degrees celcius");
	}

}

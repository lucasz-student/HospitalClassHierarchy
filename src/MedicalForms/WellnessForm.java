package MedicalForms;

import java.util.Arrays;

public class WellnessForm extends MedicalForms {

	private String bloodPressure; 
	private String stethoscopeReading; 
	private String temperature;
	
	public WellnessForm(String age, String name, String bloodPressure, String stethoscopeReading, String temperature) {
		super(age, name);
		this.bloodPressure = bloodPressure;
		this.stethoscopeReading = stethoscopeReading;
		this.temperature = temperature;
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getAge() {
		return this.age;
	}
	
	public String getBp() {
		return this.bloodPressure;
	}
	
	public String getStethoscopeReading() { 
		return this.stethoscopeReading;
	}
	
	public String getTemperature() {
		return this.temperature;
	}

	@Override
	public void printForm() {
		String[] form = {this.age, this.name, this.bloodPressure, this.stethoscopeReading, this.temperature};
		System.out.println(Arrays.toString(form));
		
	}

	@Override
	public String[] returnForm() {
		String[] WellnessForm = {this.age, this.name, this.bloodPressure, this.stethoscopeReading, this.temperature};
		return WellnessForm;
	}

	
	
	
}

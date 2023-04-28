package NonMedicalWorkers;

import MedicalWorkers.GeneralSurgeon;

public final class SurgeryRoomSanitizor implements CleaningAndSanitization{

	private String name; 
	private int age; 
	
	public SurgeryRoomSanitizor(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public int getAge() {
		return this.age;
	}
	
	
	public void sterilizeSurguryRoom(GeneralSurgeon surgeon) {
		surgeon.setRoomSterileStatus(true);
		System.out.println("This surgery room has been sterilized and prepared for surgery\n");
	}
	
	@Override
	public void SanitizeSpace() {
		System.out.println("This surgery room has been cleaned\n");
	}


	@Override
	public void identifySelf() {
		System.out.print("Hello, I am a Surgeon Room Sanitizor. My name and age are: " + this.name + " " + this.age);
		
	}
	
}

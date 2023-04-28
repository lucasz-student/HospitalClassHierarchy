package NonMedicalWorkers;

public class Janitor implements CleaningAndSanitization{

	private String name; 
	private int age; 
	
	public Janitor(String name, int age) {
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
	
	@Override
	public void SanitizeSpace() {
		System.out.println("This space is now cleaned");
		
	}

	@Override
	public void identifySelf() {
		System.out.print("Hello, I am a Janitor. My name and age are: " + this.name + " " + this.age);
	}

}

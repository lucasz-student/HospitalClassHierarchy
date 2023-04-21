package HospitalClassHierarchy;

public class SurgeryPatient {
	
	private String name;
	private int age;
	private String surgeryName;
	private boolean surgeryCompletion;
	
	public SurgeryPatient(String name, int age, String surgeryName) {
		this.name = name;
		this.age = age;
		this.surgeryName = surgeryName;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setSurgeryCompletion(boolean status) { 
		this.surgeryCompletion = status;
		if (status) {
			System.out.println("Current status for patient is complete\n");
		}
		else {
			System.out.println("Current status for patient is incomplete\n");
		}
	}
	
	public String[] SurgeryCardFromNurse(Nurse nurse) { 
		String[] surgeryCard = {String.valueOf(this.age), this.name, this.surgeryName}; 
		this.surgeryCompletion = false;
		System.out.println("\nHello, " + this.name + " your surgery is scheduled and your current surgery status for patient is incomplete\n");
		return surgeryCard;
	}
}

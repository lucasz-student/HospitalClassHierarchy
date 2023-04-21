package HospitalClassHierarchy;

public class Patient {
	private String name;
	private int age; 
	private boolean sick; 
	private String reasonForVisit;
	
	public Patient(String name, int age, boolean sick, String reasonForVisit) {
		this.name = name; 
		this.age = age;
		this.sick = sick;
		this.reasonForVisit = reasonForVisit;
	}
	
	public void setSick(boolean sick) {
		this.sick = sick; 
	}
	
	public String getName() { 
		return this.name;
	}
	
	public int getAge() {
		return this.age; 
	}
	
	public String[] scheduleAppointmentWithNurse(Nurse nurse, String time, String sick) {

		String age = String.valueOf(this.age);
		
		String[] appointmentSlip = {this.name, age, sick, this.reasonForVisit, time};
		
		return appointmentSlip;
	}
}

package HospitalClassHierarchy;

public class Nurse {

	private String branchOfHospital; 
	private String name;
	private String nurseID;
	
	public Nurse(String branch, String name, String ID) { 
		this.branchOfHospital = branch;
		this.name = name;
		this.nurseID = ID;
	}
	
	public String getID() {
		return this.nurseID; 
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setBranch(String branch) { 
		this.branchOfHospital = branch;
	}
	
	public void comfirmAppointmentWithDoctor(Patient patient, Doctor doctor, String[] appointmentSlip) { 
		boolean comfirmation = doctor.comfirmAppointment(appointmentSlip);
		if (comfirmation) { 
			System.out.println("Hello, " + patient.getName() + ", your appointment for " + appointmentSlip[4] + " is comfirmed with the doctor!\n\n");
		}
		else { 
			System.out.println("Sorry, the doctor's schedule is preoccupied. Please reschedule your appointment");
		}
	}
}

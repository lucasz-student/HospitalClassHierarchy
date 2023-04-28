package HospitalClassHierarchy;

public class GeneralSurgeon {
	private String branchOfHospital;
	private int Experience;
	private String SurgerySpecialty;
	
	public GeneralSurgeon(String branchOfHospital, int Experience, String SurgerySpecialty) {
		this.branchOfHospital = branchOfHospital; 
		this.Experience = Experience;
		this.SurgerySpecialty = SurgerySpecialty;
	}
	
	public void setExperience(int years) {
		this.Experience = years;
	}
	
	public String getbranchOfHospital() {
		return this.branchOfHospital;
	}
	
	public void commonSurgery(SurgeryPatient patient, String[] surgeryCard) {
		System.out.println(surgeryCard[1] + "'s " + surgeryCard[2] + " is complete. Please return to the lobby");
		patient.setSurgeryCompletion(true);
	}
	
}

package Entities;
import java.util.ArrayList;
import java.util.List;

import com.solvd.laba.Utils.BranchesOfHospital;


public class GeneralSurgeon extends MedicalEmployee{
	

	private boolean surgeryRoomSterileStatus;
	private List<SurgeryPatient> patientList = new ArrayList<>();
	private List<SurgeryCard> appointmentList = new ArrayList<>();
	private List<String> knownSurgeries = new ArrayList<>();
	
	public GeneralSurgeon(String name, int age, BranchesOfHospital branchOfHospital, List<String> knownSurgeries) {
		super(name, age, branchOfHospital);
		this.surgeryRoomSterileStatus = false;
		this.knownSurgeries = knownSurgeries;
	}
	
	public void setRoomSterileStatus(boolean status) {
		this.surgeryRoomSterileStatus = status;
	}
	
	public void addAppointment(SurgeryCard form) {
		this.appointmentList.add(form);
	}
	
	public void addPatient(SurgeryPatient patient) {
		this.patientList.add(patient);
	}
	
	public List<SurgeryPatient> getPatientList() {
		return this.patientList;
	}
	
	public List<SurgeryCard> getAppointmentList() {
		return this.appointmentList;
	}
	
	public List<String> getKnownSurgeries() {
		return this.knownSurgeries;
	}
	
	public boolean getSurgeryRoomSterileStatus() {
		return this.surgeryRoomSterileStatus;
	}
}

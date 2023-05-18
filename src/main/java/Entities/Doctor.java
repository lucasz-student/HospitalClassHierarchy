package Entities;

import java.util.ArrayList;
import java.util.List;

import com.solvd.laba.Exceptions.ToolPermissionDeniedException;
import com.solvd.laba.Tools.Sphygmomanometer;
import com.solvd.laba.Tools.Tools;
import com.solvd.laba.Utils.BranchesOfHospital;

public class Doctor extends MedicalEmployee {

	private List<AppointmentForm> appointmentList = new ArrayList<>();
	private List<Patient> patientList = new ArrayList<>();
	
	public Doctor(String name, int age, BranchesOfHospital branchOfHospital) {
		super(name, age, branchOfHospital);
	}
	
	public void addAppointment(AppointmentForm form) {
		this.appointmentList.add(form);
	}
	
	public void addPatient(Patient patient) {
		this.patientList.add(patient);
	}
	
	public List<Patient> getPatientList() {
		return this.patientList;
	}
	
	public List<AppointmentForm> getAppointmentList() {
		return this.appointmentList;
	}
	
	public void equipSphygmomanometer(Sphygmomanometer BPMachine) throws ToolPermissionDeniedException {
		if (this.equals(BPMachine.getOwner())) {
			BPMachine.equipped = true;
		}
	} 
	
	public void EquipTool(Tools tool) throws ToolPermissionDeniedException{
		if (this.equals(tool.getOwner())) {
			tool.equipTool();
		} else {
			throw new ToolPermissionDeniedException();
		}
	}
}

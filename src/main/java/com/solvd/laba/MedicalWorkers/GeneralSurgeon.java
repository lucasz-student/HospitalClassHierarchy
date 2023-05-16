package com.solvd.laba.MedicalWorkers;

import java.io.IOException;

import com.solvd.laba.Exceptions.UnregisteredSurgeryException;
import com.solvd.laba.Patients.SurgeryPatient;
import com.solvd.laba.Utils.Utils;

public class GeneralSurgeon extends MedicalEmployee{
	

	private String SurgerySpecialty;
	private boolean surgeryRoomSterileStatus;

	
	public GeneralSurgeon(String name, int age, String branchOfHospital,  String SurgerySpecialty) {
		super(name, age, branchOfHospital);
		this.SurgerySpecialty = SurgerySpecialty;
		this.surgeryRoomSterileStatus = false;

	}
	
	public String getName() {
		return this.name;
	}
	
	public void setRoomSterileStatus(boolean status) {
		this.surgeryRoomSterileStatus = status;
	}
	
	public String getbranchOfHospital() {
		return this.branchOfHospital;
	}
	
	public final void commonSurgery(SurgeryPatient patient, String[] surgeryCard) {
		try {
			if (Utils.checkFileForString(Utils.patientList, patient.getName()) == false) {
				throw new UnregisteredSurgeryException("Surgery Unregistered");
			} else if (surgeryRoomSterileStatus) {
			System.out.println(surgeryCard[1] + "'s " + surgeryCard[2] + " is complete. Please return to the lobby");
			patient.setSurgeryCompletion(true);
			} else { 
				System.out.print("Please make sure this room is sterile before surgery\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UnregisteredSurgeryException e) {
			e.printStackTrace();
		}
	}
}

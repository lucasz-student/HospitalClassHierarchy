package com.solvd.laba.MedicalWorkers;

import java.io.IOException;

import com.solvd.laba.Exceptions.UnregisteredSurgeryException;
import com.solvd.laba.Patients.SurgeryPatient;
import com.solvd.laba.Utils.Utils;

public class GeneralSurgeon {
	
	private String name;
	private int age;
	private String branchOfHospital;
	private String SurgerySpecialty;
	private boolean surgeryRoomSterileStatus;
	private int surgeonID;
	
	public GeneralSurgeon(String name, int age, String branchOfHospital, String SurgerySpecialty, int surgeonID) {
		this.branchOfHospital = branchOfHospital; 
		this.SurgerySpecialty = SurgerySpecialty;
		this.surgeryRoomSterileStatus = false;
		this.surgeonID = surgeonID;
		this.name = name;
		this.age = age;
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
			}
			else if (surgeryRoomSterileStatus) {
			System.out.println(surgeryCard[1] + "'s " + surgeryCard[2] + " is complete. Please return to the lobby");
			patient.setSurgeryCompletion(true);
			}
			else { 
				System.out.print("Please make sure this room is sterile before surgery\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UnregisteredSurgeryException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		return "Hi, I'm Surgeon " + this.name;
	}
	
	@Override
	public int hashCode() {
		return this.surgeonID;
	}
	
	@Override 
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		
        if(obj == null || obj.getClass()!= this.getClass())
            return false;
		
		if (obj.hashCode() == this.hashCode()) {
			return true;
		}
		return false;
	}
}

package com.solvd.laba.Services;

import com.solvd.laba.Entities.GeneralSurgeon;
import com.solvd.laba.Entities.SurgeryCard;
import com.solvd.laba.Entities.SurgeryPatient;
import com.solvd.laba.Exceptions.NoAppointmentException;
import com.solvd.laba.Exceptions.PatientNotFoundException;
import com.solvd.laba.Exceptions.UnknownSurgeryException;
import com.solvd.laba.Utils.Utils;

public class SurgeonServices {
	
	private GeneralSurgeon surgeon;
	
	public SurgeonServices(GeneralSurgeon surgeon) {
		this.surgeon = surgeon;
	}

	public final void Surgery(SurgeryPatient patient, SurgeryCard surgeryCard) throws PatientNotFoundException, NoAppointmentException {
		try {
			if (!this.surgeon.getPatientList().contains(patient)) {
				Utils.logger.error("This Patient is not on " + this.surgeon.getName() + "'s patient list");
				throw new PatientNotFoundException();
			} else if (!this.surgeon.getAppointmentList().contains(surgeryCard)){
				Utils.logger.error("This Patient is not on " + this.surgeon.getName() + "'s appointment list");
				throw new NoAppointmentException();
			} else if (!this.surgeon.getKnownSurgeries().contains(surgeryCard.getSurgeryName())) {
				Utils.logger.error(this.surgeon.getName() + " does not know how to perform this surgery");
				throw new UnknownSurgeryException("Unknown Surgery", surgeryCard.getSurgeryName());
			} else if (this.surgeon.getSurgeryRoomSterileStatus()) {
			System.out.println(surgeryCard.getName() + "'s " + surgeryCard.getSurgeryName() + " is complete. Please return to the lobby");
			patient.setSurgeryCompletion(true);
			} else { 
				System.out.print("Please make sure this room is sterile before surgery\n");
			}
		} catch (UnknownSurgeryException e) {
			e.printStackTrace();
		}
	}
}

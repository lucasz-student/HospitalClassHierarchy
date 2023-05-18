package Services;

import Entities.AppointmentForm;
import Entities.Nurse;
import Entities.RegularPatient;

public class NurseServices {

	private Nurse nurse;
	
	public NurseServices(Nurse nurse) {
		this.nurse = nurse;
	}
	
	public void comfirmAppointmentWithDoctor(RegularPatient patient, DoctorServices doctor, AppointmentForm AppointmentForm) { 
		boolean comfirmation = doctor.comfirmAppointment(AppointmentForm, patient);
		if (comfirmation) { 
			System.out.println("Hello, " + patient.getName() + ", your appointment for " + AppointmentForm.getTime() + " is comfirmed with the doctor!\n\n");
			this.nurse.addPatient(patient);
		}
		else { 
			System.out.println("Sorry, the doctor's schedule is preoccupied. Please reschedule your appointment");
		}
	}
	
	public static void askQuestion(String Question) { 
		switch (Question) {
		
		case ("What is the name of this Hospital"):
			System.out.println("The Community Care Clinic!\n");
			break;
		
		case ("What hours does this hospital operate?"):
			System.out.println("6:00 am - 12:00 am\n");
			break;
		
		case ("What insurance do you guys take?"):
			System.out.println("Almost all insurances\n");
			break;
		default: 
			System.out.println("I'm not sure the answer to this question");
		}
	}
}

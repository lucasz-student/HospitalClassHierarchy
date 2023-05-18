package Services;

import java.io.IOException;
import java.util.Scanner;

import com.solvd.laba.Exceptions.NoAppointmentException;
import com.solvd.laba.Exceptions.PatientNotFoundException;
import com.solvd.laba.Exceptions.UnequippedOrUncleanToolException;
import com.solvd.laba.Tools.Sphygmomanometer;
import com.solvd.laba.Tools.Stethoscope;
import com.solvd.laba.Tools.Thermometer;
import com.solvd.laba.Utils.Days;
import com.solvd.laba.Utils.ToolReadings;
import com.solvd.laba.Utils.Utils;
import Entities.AppointmentForm;
import Entities.Doctor;
import Entities.Nurse;
import Entities.Patient;
import Entities.RegularPatient;
import Entities.WellnessForm;

public class DoctorServices {

	private Doctor doctor;
	
	public DoctorServices(Doctor doctor) {
		this.doctor = doctor;
	}
	
	public boolean comfirmAppointment(AppointmentForm AppointmentForm, Patient patient) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Hello Doctor " + doctor.getName() + ", do you want to comfirm an appointment with " + AppointmentForm.getName() + " at " + AppointmentForm.getTime() + "?");
		System.out.println("Enter 0 to comfirm and 1 to decline");
		
		int comfirmation = scanner.nextInt();
		scanner.close();
		if (comfirmation == 0) { 
			this.doctor.addAppointment(AppointmentForm);
			this.doctor.addPatient(patient);
			return true;
		} else {
			return false;
		}
	}
	
	public WellnessForm patientCheckup(RegularPatient patient, Sphygmomanometer bpMachine, Stethoscope stethoscope, Thermometer thermometer, Nurse nurse, Days day) throws IOException, NoAppointmentException, UnequippedOrUncleanToolException, PatientNotFoundException {
		Utils.logger.info("Finding Patient in files: " + patient.getName());
		if ((Utils.checkFileForString(Utils.patientList, patient.getName()) || (!this.doctor.getPatientList().contains(patient))) == false) {
			Utils.logger.error("This Patient is not on " + this.doctor.getName() + "'s patient list");
			throw new PatientNotFoundException();
		} else if (Utils.checkFileForString(Utils.appointmentList, patient.getName()) == false) {
			Utils.logger.error("This Patient is not on " + this.doctor.getName() + "'s appointment list");
			throw new NoAppointmentException("Patient not on Appointment List", true, patient, nurse, "next available", ("" + patient.getSick()), Days.MONDAY);
		} else {
			this.doctor.addPatient(patient);
			Utils.logger.info("Successfully found Patient Name, returning WellnessForm");
			ToolReadings bloodPressure = bpMachine.measureBP();
			ToolReadings soundQuality = stethoscope.listen() ;
			ToolReadings temp = thermometer.measureTemp();
			
			WellnessForm wellnessForm = new WellnessForm(Integer.toString(patient.getAge()), patient.getName(), bloodPressure, soundQuality, temp, day);
			
			return wellnessForm;
		}
	}
	
	public void diagnosePatient(RegularPatient patient, WellnessForm wellnessSlip) throws PatientNotFoundException {
		Utils.logger.info("Successfully Diagnosing patient");
		
		if (this.doctor.getPatientList().contains(patient)) {
			System.out.println("\nHello, " + patient.getName() + " welcome to your scheduled appointment");
			switch (wellnessSlip.getBp()) {
			case HIGH:
				System.out.println("Your blood pressure is too high\n");
				patient.setSick(true);
				break;
			case LOW:
				System.out.print("Your blood pressure is too low\n");
				patient.setSick(true);
				break;
			case NORMAL:
				System.out.println("Your blood pressure is normal\n");
				break;
			default: break;
			}
			
			switch (wellnessSlip.getTemperature()) {
			case HIGH:
				System.out.println("You have a fever\n");
				patient.setSick(true);
				break;
			case LOW:
				System.out.print("You have hyperthermia\n");
				patient.setSick(true);
				break;
			case NORMAL:
				System.out.println("Your temperature is normal\n");
				break;	
			default: break;
			}
			
			if (wellnessSlip.getStethoscopeReading() == ToolReadings.POOR) {
				System.out.println("Something may be wrong with your heart or lungs\n");	
				patient.setSick(true);
			}
			else {
				System.out.println("Your heart and lungs sound normal\n");
			}
		} else {
			Utils.logger.error("This Patient is not on " + this.doctor.getName() + "'s patient list");
			throw new PatientNotFoundException();
		}
	}
	
	public void prescribeMedicine(RegularPatient patient, WellnessForm wellnessSlip) throws PatientNotFoundException {
		if (this.doctor.getPatientList().contains(patient)) {
			System.out.println("\nHello, " + patient.getName());
			switch (wellnessSlip.getBp()) {
			case HIGH:
				System.out.print("For your high BP, please take Hygroton\n");
				break;
			case NORMAL:
				System.out.print("Your blood pressure is normal and you do not need medication\n");
				break;
			case LOW:
				System.out.print("For your low BP, please take Atacand\n");
				break;
			default: break;
			}
			
			switch (wellnessSlip.getTemperature()) {
			case HIGH:
				System.out.print("For your high Body Temperature, please take Ibuprofen\n");
				break;
			case NORMAL:
				System.out.print("Your Body Temperature is normal and you do not need medication\n");
				break;
			case LOW:
				System.out.print("For your low Body Temperature, please take Cordarone\n");
				break;
			default: break;
			}
			
			if (wellnessSlip.getStethoscopeReading() == ToolReadings.POOR) { 
				System.out.print("Please schedule an appointment to check your heart and lungs");
			}
		} else {
			Utils.logger.error("This Patient is not on " + this.doctor.getName() + "'s patient list");
			throw new PatientNotFoundException();
		}
	}
}

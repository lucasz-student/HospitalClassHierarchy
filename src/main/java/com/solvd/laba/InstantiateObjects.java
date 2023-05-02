package com.solvd.laba;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.laba.Exceptions.NoAppointmentException;
import com.solvd.laba.Exceptions.ToolPermissionDeniedException;
import com.solvd.laba.Exceptions.UnequippedToolException;
import com.solvd.laba.MedicalForms.AppointmentForm;
import com.solvd.laba.MedicalForms.WellnessForm;
import com.solvd.laba.MedicalWorkers.Doctor;
import com.solvd.laba.MedicalWorkers.GeneralSurgeon;
import com.solvd.laba.MedicalWorkers.Nurse;
import com.solvd.laba.NonMedicalWorkers.Janitor;
import com.solvd.laba.NonMedicalWorkers.SurgeryRoomSanitizor;
import com.solvd.laba.Patients.CheckupPatient;
import com.solvd.laba.Patients.SurgeryPatient;
import com.solvd.laba.Tools.Sphygmomanometer;
import com.solvd.laba.Tools.Stethoscope;
import com.solvd.laba.Tools.Thermometer;
import com.solvd.laba.Utils.Utils;

public class InstantiateObjects {
	
	public static void main(String[] args) throws IOException {	
		
		Utils.logger.info("Testing program...");
		
		Janitor janitorLiam = new Janitor("Liam", 25);
		SurgeryRoomSanitizor sanitizorJacob = new SurgeryRoomSanitizor("Jacob" , 30);

		//Doctors and Nurses//
		Doctor doctorPaul = new Doctor("Urgent Care", "Paul", 10, false, 10011);
		Doctor doctorException = new Doctor("Neurology", "Exception", 10, false, 10012);
		int NurseID = 18394;
		Nurse nurseEmma = new Nurse("Urgent Care", "Emma", NurseID);
		int NurseID1 = 18295;
		Nurse nurseEric = new Nurse("Urgent Care", "Emma", NurseID1);
		
		//Schedule and Confirm Appointment for John//
		CheckupPatient patientJohn = new CheckupPatient("John", 30, false, "Checkup With Doctor");
		patientJohn.checkIn();
		patientJohn.fillOutPatientForm("11:am");
		AppointmentForm AppointmentSlip  = patientJohn.scheduleAppointmentWithNurse(nurseEmma, "11:am", "not sick");
		nurseEmma.comfirmAppointmentWithDoctor(patientJohn, doctorPaul, AppointmentSlip);
		
		
		//Instantiate and equip tools//
		Stethoscope stethoscope = new Stethoscope(true, 5, doctorPaul);
		Sphygmomanometer BPMachine = new Sphygmomanometer("pocket-aneroid", 5, doctorPaul);
		Thermometer thermometer = new Thermometer("forehead-scan", 5, doctorPaul);
		
		try {
			stethoscope.equipTool(doctorPaul);
			BPMachine.equipTool(doctorPaul);
			thermometer.equipTool(doctorPaul);		// 2 EXCEPTION
		} catch (ToolPermissionDeniedException e1) {
			e1.printStackTrace();
		}

		
		
		//Diagnose and prescribe medicine to Greg NO APPOINTMENT // //2 EXCEPTION
		CheckupPatient patientGreg = new CheckupPatient("Greg", 31, true, "checkup, diagnosis, and appointment");
		patientGreg.checkIn();
		patientGreg.fillOutPatientForm("12:pm");
		WellnessForm WellnessSlip;
		try {
			WellnessSlip = doctorPaul.patientCheckup(patientGreg, BPMachine, stethoscope, thermometer);
			doctorPaul.diagnosePatient(patientGreg, WellnessSlip);
			doctorPaul.prescribeMedicine(patientGreg, WellnessSlip);
		} catch (IOException | NoAppointmentException | UnequippedToolException e) {
			e.printStackTrace();
		}

		
		System.out.println("\n");
		
		//Diagnose and prescribe medicine to John//
		WellnessForm WellnessSlip1;
		try {
			WellnessSlip1 = doctorPaul.patientCheckup(patientJohn, BPMachine, stethoscope, thermometer);
			doctorPaul.diagnosePatient(patientJohn, WellnessSlip1);
			doctorPaul.prescribeMedicine(patientJohn, WellnessSlip1);
		} catch (IOException | NoAppointmentException | UnequippedToolException e) {
			e.printStackTrace();
		}

		
		System.out.println("\n");
		
		// Demonstrate tools with Patient James//
		CheckupPatient patientJames = new CheckupPatient("James", 11, false, "Check internals");
		patientJames.checkIn();
		patientJames.fillOutPatientForm("1 pm");
		System.out.println("\n");
		try {
			BPMachine.measureBP(patientJames, doctorPaul);
			stethoscope.listen(patientJames, doctorPaul);
			thermometer.measureTemp(patientJames, doctorPaul);
		} catch (UnequippedToolException e) {			e.printStackTrace();
		}

		
		System.out.println("\n");
		
		//Perform Surgery for Elijiah//
		
		SurgeryPatient surgeryPatientElijiah = new SurgeryPatient("Elijiah", 25, "Appendectomy");
		surgeryPatientElijiah.fillOutPatientForm("5:00pm"); // EXCEPTION
		GeneralSurgeon surgeonSaul = new GeneralSurgeon("Saul", 15, "General Surgery", "Appendectomy", 10001);
		String[] Surgerycard = surgeryPatientElijiah.SurgeryCardFromNurse(nurseEmma);
		sanitizorJacob.sterilizeSurguryRoom(surgeonSaul);
		surgeonSaul.commonSurgery(surgeryPatientElijiah, Surgerycard);
		
		//Override toString, hashcode, equals// 
		System.out.println(doctorPaul);
		System.out.println(doctorPaul.hashCode());
		
		System.out.println(nurseEmma);
		System.out.println(nurseEmma.hashCode());
		System.out.println(nurseEmma.equals(nurseEric));
		System.out.println(nurseEmma.equals(nurseEmma));
		
		System.out.println(surgeonSaul);
		System.out.println(surgeonSaul.hashCode());
		
		System.out.println("\n");
		
		// Ask nurse Questions; statically //
		Nurse.askQuestion("What is the name of this Hospital");
		Nurse.askQuestion("What hours does this hospital operate?");
		Nurse.askQuestion("What insurance do you guys take?");
		
		Utils.flushOutput();
	}
}

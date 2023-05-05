package com.solvd.laba;

import java.io.IOException;

import com.solvd.laba.Exceptions.NoAppointmentException;
import com.solvd.laba.Exceptions.ToolPermissionDeniedException;
import com.solvd.laba.Exceptions.UnequippedToolException;
import com.solvd.laba.MedicalForms.AppointmentForm;
import com.solvd.laba.MedicalForms.MedicalForms;
import com.solvd.laba.MedicalForms.WellnessForm;
import com.solvd.laba.MedicalWorkers.Doctor;
import com.solvd.laba.MedicalWorkers.GeneralSurgeon;
import com.solvd.laba.MedicalWorkers.Intern;
import com.solvd.laba.MedicalWorkers.MedicalEmployee;
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

		Doctor doctorPaul = new Doctor("Paul", 45, 10011, "Urgent Care");
		Doctor doctorException = new Doctor("Exception", 35, 10034, "Neurology");
		Nurse nurseEmma = new Nurse("Emma", 32, 18394, "Urgent Care");
		Nurse nurseEric = new Nurse("Emma", 31, 18295, "Urgent Care");
		
		CheckupPatient patientJohn = new CheckupPatient("John", 30, false, "Checkup With Doctor");
		patientJohn.checkIn();
		patientJohn.fillOutPatientForm("11:am");
		AppointmentForm AppointmentSlip  = patientJohn.scheduleAppointmentWithNurse(nurseEmma, "11:am", "not sick");
		nurseEmma.comfirmAppointmentWithDoctor(patientJohn, doctorPaul, AppointmentSlip);
		
		Stethoscope stethoscope = new Stethoscope(true, 5, doctorPaul);
		Sphygmomanometer BPMachine = new Sphygmomanometer("pocket-aneroid", 5, doctorPaul);
		Thermometer thermometer = new Thermometer("forehead-scan", 5, doctorPaul);
		
		try {
			doctorPaul.EquipTool(stethoscope);
			doctorPaul.EquipTool(BPMachine);
			doctorPaul.EquipTool(thermometer);		
		} catch (ToolPermissionDeniedException e1) {
			e1.printStackTrace();
		}

		
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
		
		
		WellnessForm WellnessSlip1;
		try {
			WellnessSlip1 = doctorPaul.patientCheckup(patientJohn, BPMachine, stethoscope, thermometer);
			doctorPaul.diagnosePatient(patientJohn, WellnessSlip1);
			doctorPaul.prescribeMedicine(patientJohn, WellnessSlip1);
		} catch (IOException | NoAppointmentException | UnequippedToolException e) {
			e.printStackTrace();
		}

		
		System.out.println("\n");
		
		
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
		

		
		SurgeryPatient surgeryPatientElijiah = new SurgeryPatient("Elijiah", 25, "Appendectomy");
		surgeryPatientElijiah.fillOutPatientForm("5:00pm"); 
		GeneralSurgeon surgeonSaul = new GeneralSurgeon("Saul", 15, 10001, "General Surgery", "Appendectomy");
		String[] Surgerycard = surgeryPatientElijiah.SurgeryCardFromNurse(nurseEmma);
		sanitizorJacob.sterilizeSurguryRoom(surgeonSaul);
		surgeonSaul.commonSurgery(surgeryPatientElijiah, Surgerycard);
		

		System.out.println(doctorPaul);
		System.out.println(doctorPaul.hashCode());
		
		System.out.println(nurseEmma);
		System.out.println(nurseEmma.hashCode());
		System.out.println(nurseEmma.equals(nurseEric));
		System.out.println(nurseEmma.equals(nurseEmma));
		
		System.out.println(surgeonSaul);
		System.out.println(surgeonSaul.hashCode());
		
		System.out.println("\n");
		
		
		Nurse.askQuestion("What is the name of this Hospital");
		Nurse.askQuestion("What hours does this hospital operate?");
		Nurse.askQuestion("What insurance do you guys take?");
		
		BPMachine.joinCleanLine();
		thermometer.joinCleanLine();
		thermometer.cleanTool();
		BPMachine.cleanTool();
		
		System.out.println("\n");
		
		MedicalEmployee.printAllEmployees();
		
		System.out.println("\n");
		
		MedicalForms.printAllFormsToday();
		
		Utils.flushOutput();
		
		System.out.println("\n");
		
		Intern internJane = new Intern("Jane", 24, 10572, "Psychiatry");
		internJane.takeNotesInJournal("prologue : Hello World");
		internJane.takeNotesInJournal("Jan-1 : Mitochondria is the powerhouse of the cell");
		internJane.takeNotesInJournal("Jan-2 : Glycogen stores sugars in animals");
		internJane.takeNotesInJournal("Jan-3 : Cellulose stores sugars in plants");
		internJane.takeNotesInJournal("Jan-4 : Green are plant's least favorite color");
		internJane.openNotePad();
		
		System.out.println("\n");
		
		internJane.takeNotesInJournal(2, "Jan-7 : Insert this note before Jan-2");
		internJane.openNotePad();
		
		System.out.println("\n");
		
		internJane.tearPage(0);
		internJane.openNotePad();
	}
}

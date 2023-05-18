package com.solvd.laba;

import java.io.IOException;
import org.apache.commons.io.FileUtils;
import com.solvd.laba.Exceptions.NoAppointmentException;
import com.solvd.laba.Exceptions.ToolPermissionDeniedException;
import com.solvd.laba.Exceptions.UnequippedOrUncleanToolException;
import com.solvd.laba.NonMedicalWorkers.Janitor;
import com.solvd.laba.NonMedicalWorkers.SurgeryRoomSanitizor;
import com.solvd.laba.Tools.Sphygmomanometer;
import com.solvd.laba.Tools.Stethoscope;
import com.solvd.laba.Tools.Thermometer;
import com.solvd.laba.Utils.Days;
import com.solvd.laba.Utils.Utils;

import Entities.AppointmentForm;
import Entities.Doctor;
import Entities.GeneralSurgeon;
import Entities.Intern;
import Entities.MedicalEmployee;
import Entities.MedicalForms;
import Entities.Nurse;
import Entities.RegularPatient;
import Entities.SurgeryPatient;
import Entities.WellnessForm;

public class Main {
	
	public static void main(String[] args) throws IOException {	
		
		Utils.logger.info("Testing program...");
		
		Janitor janitorLiam = new Janitor("Liam", 25);
		SurgeryRoomSanitizor sanitizorJacob = new SurgeryRoomSanitizor("Jacob" , 30);

		Doctor doctorPaul = new Doctor("Paul", 45, "Urgent Care");
		Doctor doctorException = new Doctor("Exception", 35, "Neurology");
		Nurse nurseEmma = new Nurse("Emma", 32, "Urgent Care");
		Nurse nurseEric = new Nurse("Emma", 31, "Urgent Care");
		
		RegularPatient patientJohn = new RegularPatient("John", 30, false, "Checkup With Doctor");
		patientJohn.checkIn();
		patientJohn.fillOutPatientForm("11:am", Days.MONDAY);
		AppointmentForm AppointmentSlip  = patientJohn.scheduleAppointmentWithNurse(nurseEmma, "11:am", "not sick", Days.MONDAY);
		nurseEmma.comfirmAppointmentWithDoctor(patientJohn, doctorPaul, AppointmentSlip);
		
		Stethoscope stethoscope = new Stethoscope(5, doctorPaul);
		Sphygmomanometer BPMachine = new Sphygmomanometer("pocket-aneroid", 5, doctorPaul);
		Thermometer thermometer = new Thermometer("forehead-scan", 5, doctorPaul);
		
		try {
			doctorPaul.EquipTool(stethoscope);
			doctorPaul.EquipTool(BPMachine);
			doctorPaul.EquipTool(thermometer);		
		} catch (ToolPermissionDeniedException e1) {
			e1.printStackTrace();
		}

		
		RegularPatient patientGreg = new RegularPatient("Greg", 31, true, "checkup, diagnosis, and appointment");
		patientGreg.checkIn();
		patientGreg.fillOutPatientForm("12:pm", Days.FRIDAY);
		WellnessForm WellnessSlip;
		try {
			WellnessSlip = doctorPaul.patientCheckup(patientGreg, BPMachine, stethoscope, thermometer, nurseEmma, Days.FRIDAY);
			doctorPaul.diagnosePatient(patientGreg, WellnessSlip);
			doctorPaul.prescribeMedicine(patientGreg, WellnessSlip);
		} catch (IOException | NoAppointmentException | UnequippedOrUncleanToolException e) {
			e.printStackTrace();
		}

		
		System.out.println("\n");
		
		
		WellnessForm WellnessSlip1;
		try {
			WellnessSlip1 = doctorPaul.patientCheckup(patientJohn, BPMachine, stethoscope, thermometer, nurseEmma, Days.THURSDAY);
			doctorPaul.diagnosePatient(patientJohn, WellnessSlip1);
			doctorPaul.prescribeMedicine(patientJohn, WellnessSlip1);
		} catch (IOException | NoAppointmentException | UnequippedOrUncleanToolException e) {
			e.printStackTrace();
		}

		
		System.out.println("\n");
		
		
		RegularPatient patientJames = new RegularPatient("James", 11, false, "Check internals");
		patientJames.checkIn();
		patientJames.fillOutPatientForm("1 pm", Days.WEDNESDAY);
		System.out.println("\n");
		try {
			BPMachine.measureBP(patientJames, doctorPaul);
			stethoscope.listen(patientJames, doctorPaul);
			thermometer.measureTemp(patientJames, doctorPaul);
		} catch (UnequippedOrUncleanToolException e) {			e.printStackTrace();
		}

		
		System.out.println("\n");
		

		
		SurgeryPatient surgeryPatientElijiah = new SurgeryPatient("Elijiah", 25, "Appendectomy");
		surgeryPatientElijiah.fillOutPatientForm("5:00pm", Days.FRIDAY); 
		GeneralSurgeon surgeonSaul = new GeneralSurgeon("Saul", 15, "General Surgery", "Appendectomy");
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
		
		System.out.println("\n");
		
		Intern internJane = new Intern("Jane", 24, "Psychiatry");
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
		
		System.out.println("\n");
		
		Utils.readFile(Utils.appointmentList);
		Utils.readFile(Utils.patientList);
		
		Utils.uniqueWordsInFile(Utils.uniqueWordsFile, Utils.uniqueWordsResultFile);
		
		Utils.flushOutput();
	}
}

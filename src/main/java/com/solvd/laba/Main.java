package com.solvd.laba;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import com.solvd.laba.Entities.AppointmentForm;
import com.solvd.laba.Entities.Doctor;
import com.solvd.laba.Entities.GeneralSurgeon;
import com.solvd.laba.Entities.Intern;
import com.solvd.laba.Entities.MedicalEmployee;
import com.solvd.laba.Entities.MedicalForms;
import com.solvd.laba.Entities.Nurse;
import com.solvd.laba.Entities.RegularPatient;
import com.solvd.laba.Entities.SurgeryCard;
import com.solvd.laba.Entities.SurgeryPatient;
import com.solvd.laba.Entities.WellnessForm;
import com.solvd.laba.Exceptions.NoAppointmentException;
import com.solvd.laba.Exceptions.PatientNotFoundException;
import com.solvd.laba.Exceptions.ToolPermissionDeniedException;
import com.solvd.laba.Exceptions.UnequippedOrUncleanToolException;
import com.solvd.laba.NonMedicalWorkers.SurgeryRoomSanitizor;
import com.solvd.laba.Services.AppointmentService;
import com.solvd.laba.Services.DoctorServices;
import com.solvd.laba.Services.NurseServices;
import com.solvd.laba.Services.SurgeonServices;
import com.solvd.laba.Tools.Sphygmomanometer;
import com.solvd.laba.Tools.Stethoscope;
import com.solvd.laba.Tools.Thermometer;
import com.solvd.laba.Utils.BranchesOfHospital;
import com.solvd.laba.Utils.Days;
import com.solvd.laba.Utils.Sickness;
import com.solvd.laba.Utils.Utils;

public class Main {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {
		
		Utils.logger.info("Testing program...");
		
		
		SurgeryRoomSanitizor sanitizorJacob = new SurgeryRoomSanitizor("Jacob" , 30);

		Doctor doctorPaul = new Doctor("Paul", 45, BranchesOfHospital.GENERALCARE);
		DoctorServices doctorPaulService = new DoctorServices(doctorPaul);
		
		Nurse nurseEmma = new Nurse("Emma", 32, BranchesOfHospital.URGENTCARE);
		Nurse nurseEric = new Nurse("Emma", 31, BranchesOfHospital.GENERALCARE);
		NurseServices nurseEmmaServices = new NurseServices(nurseEmma);
		
		AppointmentService appointmentServices = new AppointmentService(Days.MONDAY);
		RegularPatient patientJohn = new RegularPatient("John", 30, Sickness.ISNOTSICK, "Checkup With Doctor");
		patientJohn.checkIn();
		patientJohn.fillOutPatientForm("11:am", Days.MONDAY);
		AppointmentForm AppointmentSlip;
		try {
			AppointmentSlip = appointmentServices.scheduleAppointmentWithNurse(patientJohn, nurseEmma, "11:am", Sickness.ISNOTSICK, Days.MONDAY);
			nurseEmmaServices.comfirmAppointmentWithDoctor(patientJohn, doctorPaulService, AppointmentSlip);
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		
		Stethoscope stethoscope = new Stethoscope(5, doctorPaul);
		Sphygmomanometer BPMachine = new Sphygmomanometer("pocket-aneroid", 5, doctorPaul);
		Thermometer thermometer = new Thermometer("forehead-scan", 5, doctorPaul);
		
		BPMachine.joinCleanLine();
		thermometer.joinCleanLine();
		stethoscope.joinCleanLine();
		
		BPMachine.cleanTool();
		thermometer.cleanTool();
		stethoscope.cleanTool();
		
		try {
			doctorPaul.equipStethoscope(stethoscope);
			doctorPaul.equipSphygmomanometer(BPMachine);
			doctorPaul.equipThermometer(thermometer);		
		} catch (ToolPermissionDeniedException e1) {
			e1.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		RegularPatient patientGreg = new RegularPatient("Greg", 31, Sickness.ISSICK, "checkup, diagnosis, and appointment");
		patientGreg.checkIn();
		patientGreg.fillOutPatientForm("12:pm", Days.FRIDAY);
		WellnessForm WellnessSlip;
		try {
			WellnessSlip = doctorPaulService.patientCheckup(patientGreg, BPMachine, stethoscope, thermometer, nurseEmma, Days.FRIDAY);
			doctorPaulService.diagnosePatient(patientGreg, WellnessSlip);
			doctorPaulService.prescribeMedicine(patientGreg, WellnessSlip);
		} catch (IOException | NoAppointmentException | UnequippedOrUncleanToolException | PatientNotFoundException e) {
			e.printStackTrace();
		}

		
		System.out.println("\n");
		
		
		WellnessForm WellnessSlip1;
		try {
			WellnessSlip1 = doctorPaulService.patientCheckup(patientJohn, BPMachine, stethoscope, thermometer, nurseEmma, Days.THURSDAY);
			doctorPaulService.diagnosePatient(patientJohn, WellnessSlip1);
			doctorPaulService.prescribeMedicine(patientJohn, WellnessSlip1);
		} catch (IOException | NoAppointmentException | UnequippedOrUncleanToolException | PatientNotFoundException e) {
			e.printStackTrace();
		}

		
		System.out.println("\n");
		
		
		RegularPatient patientJames = new RegularPatient("James", 11, Sickness.ISNOTSICK, "Check internals");
		patientJames.checkIn();
		patientJames.fillOutPatientForm("1 pm", Days.WEDNESDAY);
		System.out.println("\n");
		try {
			BPMachine.measureBP(patientJames, doctorPaul);
			stethoscope.listen(patientJames, doctorPaul);
			thermometer.measureTemp(patientJames, doctorPaul);
		} catch (UnequippedOrUncleanToolException e) {			
			e.printStackTrace();
		}

		
		System.out.println("\n");
		

		
		SurgeryPatient surgeryPatientElijiah = new SurgeryPatient("Elijiah", 25, "Appendectomy");
		surgeryPatientElijiah.fillOutPatientForm("5:00pm", Days.FRIDAY); 
		
		List<String> SurgeriesSaulCanPerform = new ArrayList<String>();
		SurgeriesSaulCanPerform.add("Appendectomy");
		SurgeriesSaulCanPerform.add("Colon Surgery");
		SurgeriesSaulCanPerform.add("Joint replacement");
		
		GeneralSurgeon surgeonSaul = new GeneralSurgeon("Saul", 45, BranchesOfHospital.URGENTCARE, SurgeriesSaulCanPerform);
		SurgeonServices surgeryServices = new SurgeonServices(surgeonSaul);
		
		SurgeryCard Surgerycard = appointmentServices.SurgeryAppointment(surgeonSaul, surgeryPatientElijiah, nurseEmma, Days.TUESDAY);
		sanitizorJacob.sterilizeSurguryRoom(surgeonSaul);
		try {
			surgeryServices.Surgery(surgeryPatientElijiah, Surgerycard);
		} catch (NoAppointmentException | PatientNotFoundException e) {
			e.printStackTrace();
		}
		

		System.out.println(doctorPaul);
		System.out.println(doctorPaul.hashCode());
		
		System.out.println(nurseEmma);
		System.out.println(nurseEmma.hashCode());
		System.out.println(nurseEmma.equals(nurseEric));
		System.out.println(nurseEmma.equals(nurseEmma));
		
		System.out.println(surgeonSaul);
		System.out.println(surgeonSaul.hashCode());
		
		System.out.println("\n");
		
		
		NurseServices.askQuestion("What is the name of this Hospital");
		NurseServices.askQuestion("What hours does this hospital operate?");
		NurseServices.askQuestion("What insurance do you guys take?");
		
		
		System.out.println("\n");
		
		
		MedicalEmployee.printAllEmployees();
		
		
		System.out.println("\n");
		
		
		MedicalForms.printAllFormsToday();
		
		
		System.out.println("\n");
		
		
		Intern internJane = new Intern("Jane", 24, BranchesOfHospital.PSYCHOLOGY);
		internJane.takeNotesInJournal("prologue : Hello World");
		internJane.takeNotesInJournal("Jan-1 : Mitochondria is the powerhouse of the cell");
		internJane.takeNotesInJournal("Jan-2 : Glycogen stores sugars in animals");
		internJane.takeNotesInJournal("Jan-3 : Cellulose stores sugars in plants");
		internJane.takeNotesInJournal("Jan-4 : Green are plant's least favorite color");
		internJane.openNotePad();
		
		System.out.println("\n");
		
		
		internJane.changeAllNoteValues((NoteToChange) -> {
			String changedNote = NoteToChange.toUpperCase();
			return changedNote;
		});
		internJane.openNotePad();
		internJane.changeAllNoteValues((NoteToChange) -> {
			String changedNote = NoteToChange.toLowerCase();
			return changedNote;
		});
		
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

package HospitalClassHierarchy;

import MedicalForms.AppointmentForm;
import MedicalForms.WellnessForm;
import Tools.Sphygmomanometer;
import Tools.Stethoscope;
import Tools.Thermometer;

public class InstantiateObjects {
	public static void main(String[] args) {	
		
		Employee janitorLiam = new Employee("Liam", "Urgent Care", "02x8594", "Janitor");
		
		Doctor doctorPaul = new Doctor("Urgent Care", "Paul", 10, false);
		int NurseID = 18394;
		Nurse nurseEmma = new Nurse("Urgent Care", "Emma", NurseID);
		
		GeneralPatient patientJohn = new GeneralPatient("John", 30, false, "Checkup With Doctor");
		AppointmentForm AppointmentSlip  = patientJohn.scheduleAppointmentWithNurse(nurseEmma, "11:am", "not sick");
		nurseEmma.comfirmAppointmentWithDoctor(patientJohn, doctorPaul, AppointmentSlip);
		
		Stethoscope stethoscope = new Stethoscope(true, 5);
		
		Sphygmomanometer BPMachine = new Sphygmomanometer("pocket-aneroid", 5);
		
		Thermometer thermometer = new Thermometer("forehead-scan", 5);
		
		GeneralPatient patientGreg = new GeneralPatient("Greg", 31, true, "checkup, diagnosis, and appointment");
		WellnessForm WellnessSlip = doctorPaul.patientCheckup(patientGreg, BPMachine, stethoscope, thermometer);
		doctorPaul.diagnosePatient(patientGreg, WellnessSlip);
		doctorPaul.prescribeMedicine(patientGreg, WellnessSlip);
		System.out.println("\n");
		WellnessForm WellnessSlip1 = doctorPaul.patientCheckup(patientJohn, BPMachine, stethoscope, thermometer);
		doctorPaul.diagnosePatient(patientJohn, WellnessSlip1);
		doctorPaul.prescribeMedicine(patientJohn, WellnessSlip1);
		
		
		GeneralPatient patientJames = new GeneralPatient("James", 11, false, "Check internals");
		System.out.println("\n");
		BPMachine.measureBP(patientJames, doctorPaul);
		stethoscope.listen(patientJames, doctorPaul);
		thermometer.measureTemp(patientJames, doctorPaul);
		
		SurgeryPatient surgeryPatientElijiah = new SurgeryPatient("Elijiah", 25, "Appendectomy");
		GeneralSurgeon surgeonSaul = new GeneralSurgeon("Saul", 15, "General Surgery");
		
		String[] Surgerycard = surgeryPatientElijiah.SurgeryCardFromNurse(nurseEmma);
		surgeonSaul.commonSurgery(surgeryPatientElijiah, Surgerycard);
		
		System.out.println(doctorPaul);
	}
}

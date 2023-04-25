package HospitalClassHierarchy;

public class InstantiateObjects {
	public static void main(String[] args) {	
		
		Janitor janitorLiam = new Janitor("Liam", "Urgent Care", "02x8594", "Janitor", "Bathroom");
		
		Doctor doctorPaul = new Doctor("Urgent Care", "Paul", 10, false);
		Nurse nurseEmma = new Nurse("Urgent Care", "Emma", "01x8394");
		
		Patient patientJohn = new Patient("John", 30, false, "Checkup With Doctor");
		String [] AppointmentSlip  = patientJohn.scheduleAppointmentWithNurse(nurseEmma, "11:am", "not sick");
		nurseEmma.comfirmAppointmentWithDoctor(patientJohn, doctorPaul, AppointmentSlip);
		
		Stethoscope stethoscope = new Stethoscope(true, 5);
		
		Sphygmomanometer BPMachine = new Sphygmomanometer("pocket-aneroid", 5);
		
		Thermometer thermometer = new Thermometer("forehead-scan", 5);
		
		Patient patientGreg = new Patient("Greg", 31, true, "checkup, diagnosis, and appointment");
		String [] WellnessSlip = doctorPaul.patientCheckup(patientGreg, BPMachine, stethoscope, thermometer);
		doctorPaul.diagnosePatient(patientGreg, WellnessSlip);
		doctorPaul.prescribeMedicine(patientGreg, WellnessSlip);
		
		String [] WellnessSlip1 = doctorPaul.patientCheckup(patientJohn, BPMachine, stethoscope, thermometer);
		doctorPaul.diagnosePatient(patientJohn, WellnessSlip);
		doctorPaul.prescribeMedicine(patientJohn, WellnessSlip);
		
		
		Patient patientJames = new Patient("James", 11, false, "Check internals");
		BPMachine.measureBP(patientJames, doctorPaul);
		stethoscope.listen(patientJames, doctorPaul);
		thermometer.measureTemp(patientJames, doctorPaul);
		
		SurgeryPatient surgeryPatientElijiah = new SurgeryPatient("Elijiah", 25, "Appendectomy");
		GeneralSurgeon surgeonSaul = new GeneralSurgeon("Saul", 15, "General Surgery");
		
		String[] Surgerycard = surgeryPatientElijiah.SurgeryCardFromNurse(nurseEmma);
		surgeonSaul.commonSurgery(surgeryPatientElijiah, Surgerycard);
		
	}
}

package Services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.solvd.laba.Utils.Days;
import com.solvd.laba.Utils.Sickness;
import com.solvd.laba.Utils.Utils;

import Entities.AppointmentForm;
import Entities.GeneralSurgeon;
import Entities.Nurse;
import Entities.RegularPatient;
import Entities.SurgeryCard;
import Entities.SurgeryPatient;

public class AppointmentService {
	
	private Days day; 
	private List<AppointmentForm> ServicerAppointmentList = new ArrayList<>();
	private List<SurgeryCard> ServicerSurgeryList = new ArrayList<>();
	
	public AppointmentService(Days day) {
		this.day = day;
	}
	
	public Days getDay() {
		return day;
	}

	public void setDay(Days day) {
		this.day = day;
	}
	
	public void printServiceAppointmentList() {
		this.ServicerAppointmentList.forEach(Appointment -> System.out.println(Appointment));
	}
	
	public void printSurgeryList() {
		this.ServicerAppointmentList.forEach(SurgeryCard -> SurgeryCard.printForm());
	}
	
	public AppointmentForm scheduleAppointmentWithNurse(RegularPatient patient, Nurse nurse, String time, Sickness sick, Days day) throws IOException {
		String age = Integer.toString(patient.getAge());
		AppointmentForm appointmentForm = new AppointmentForm(age, patient.getName(), time, sick, patient.getReasonForVisit(), day);
		this.ServicerAppointmentList.add(appointmentForm);
		BufferedWriter writer = new BufferedWriter(new FileWriter(Utils.appointmentList, true));
		try  {
			Utils.logger.info("Logging Name Patient to Appointment file: " + patient.getName());
			writer.write("\n" + appointmentForm.returnForm());
		} catch (IOException e) {
			e.printStackTrace();
		} finally { 
			writer.close();
		}
		return appointmentForm;
	}
	
	public SurgeryCard SurgeryAppointment(GeneralSurgeon surgeon, SurgeryPatient patient, Nurse nurse, Days day) { 
		SurgeryCard surgeryCard = new SurgeryCard(patient.getName(), ("" + patient.getAge()), day, patient.getSurgeryName());
		surgeon.getPatientList().add(patient);
		surgeon.getAppointmentList().add(surgeryCard);
		this.ServicerSurgeryList.add(surgeryCard);
		patient.setSurgeryCompletion(false);
		System.out.println("\nHello, " + patient.getName() + " your surgery is scheduled and your current surgery status for patient is incomplete\n");
		return surgeryCard;
	}
	
	public List<AppointmentForm> getAppointmentsForDay(Days day) {
		List<AppointmentForm> filteredForm = this.ServicerAppointmentList.stream()
				.filter((AppointmentForm form) -> (form.getDay() == day))
				.collect(Collectors.toList());	
		return filteredForm;
	}
	
	public List<SurgeryCard> getSurgeriesForDay(Days day) {
		List<SurgeryCard> filteredForm = this.ServicerSurgeryList.stream()
				.filter((SurgeryCard form) -> (form.getDay() == day))
				.collect(Collectors.toList());	
		return filteredForm;
	}
}

package Entities;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.solvd.laba.Exceptions.ToolPermissionDeniedException;
import com.solvd.laba.Tools.Sphygmomanometer;
import com.solvd.laba.Tools.Stethoscope;
import com.solvd.laba.Tools.Thermometer;
import com.solvd.laba.Utils.BranchesOfHospital;
import com.solvd.laba.Utils.Days;
import com.solvd.laba.Utils.Utils;

public class Doctor extends MedicalEmployee {

	private List<AppointmentForm> appointmentList = new ArrayList<>();
	private List<RegularPatient> patientList = new ArrayList<>();
	
	public Doctor(String name, int age, BranchesOfHospital branchOfHospital) {
		super(name, age, branchOfHospital);
	}
	
	public void addAppointment(AppointmentForm form) {
		this.appointmentList.add(form);
	}
	
	public void addPatient(RegularPatient patient) {
		this.patientList.add(patient);
	}
	
	public List<RegularPatient> getPatientList() {
		return this.patientList;
	}
	
	public List<AppointmentForm> getAppointmentList() {
		return this.appointmentList;
	}
	
	
	public void equipSphygmomanometer(Sphygmomanometer sphygmomanometer) throws ToolPermissionDeniedException, ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
		Class BP = Class.forName("com.solvd.laba.Tools.Sphygmomanometer");
		Method Owner = BP.getDeclaredMethod("getOwner");
		Owner.invoke(sphygmomanometer);
		
		if (this.equals(Owner.invoke(sphygmomanometer))) {
			Field equipped = BP.getDeclaredField("equipped");
			equipped.setAccessible(true);
			equipped.setBoolean(sphygmomanometer, true);
			Utils.logger.info("Sphygmomanometer Equipped");
		}
	} 

	public void equipStethoscope(Stethoscope Stethoscope) throws ToolPermissionDeniedException, ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
		Class BP = Class.forName("com.solvd.laba.Tools.Stethoscope");
		Method Owner = BP.getDeclaredMethod("getOwner");
		Owner.invoke(Stethoscope);

		
		if (this.equals(Owner.invoke(Stethoscope))) {
			Field equipped = BP.getDeclaredField("equipped");
			equipped.setAccessible(true);
			equipped.setBoolean(Stethoscope, true);
			Utils.logger.info("Stethoscope Equipped");
		}
	} 
	
	public void equipThermometer(Thermometer Thermometer) throws ToolPermissionDeniedException, ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
		Class BP = Class.forName("com.solvd.laba.Tools.Thermometer");
		Method Owner = BP.getDeclaredMethod("getOwner");
		Owner.invoke(Thermometer);

		if (this.equals(Owner.invoke(Thermometer))) {
			Field equipped = BP.getDeclaredField("equipped");
			equipped.setAccessible(true);
			equipped.setBoolean(Thermometer, true);
			Utils.logger.info("Thermometer Equipped");
		}
	} 
	
	public List<AppointmentForm> getAppointmentsForDay(Days day) {
		List<AppointmentForm> filteredForm = this.appointmentList.stream()
				.filter((AppointmentForm form) -> (form.getDay() == day))
				.collect(Collectors.toList());	
		return filteredForm;
	}
	
	public List<RegularPatient> getPatientBySickness(boolean isSick) {
		List<RegularPatient> filteredList = this.patientList.stream()
				.filter((RegularPatient patient) -> (patient.getSick().getOverallSickStatus() == isSick))
				.collect(Collectors.toList());	
		return filteredList;
	}
	
	public List<RegularPatient> getPatientsOlderThanAge(int age) {
		List<RegularPatient> filteredList = this.patientList.stream()
				.filter((RegularPatient patient) -> (patient.getAge() > age))
				.collect(Collectors.toList());	
		return filteredList;
	}
}

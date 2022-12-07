package clinicSys;

import java.util.ArrayList;

public class Record {
	private ArrayList<Appointment> appointments = new ArrayList<Appointment>();
	private ArrayList<Patient> patients = new ArrayList<Patient>();
	private ArrayList<Integer> type = new ArrayList<Integer>();

	public boolean addAppointment(Appointment appointment, Patient patient) {
		if (appointments.contains(appointment))
			return false;

		appointments.add(appointment);
		patients.add(patient);
		type.add(1);
		return true;

	}

	public boolean addVisit(Appointment appointment) {
		int index = appointments.indexOf(appointment);
		if (index >= 0) {
			type.set(index, 2);
			return true;
		}

		return false;

	}

	public boolean deleteAppointment(Appointment appointment) {
		int index = appointments.indexOf(appointment);
		if (index >= 0) {
			appointments.remove(index);
			patients.remove(index);
			type.remove(index);
			return true;
		}

		return false;

	}

	public boolean editAppointment(Appointment oldAppointment, Appointment newAppointment) {
		if (appointments.contains(newAppointment))
			return false;

		int index = appointments.indexOf(oldAppointment);
		if (index >= 0) {
			appointments.set(index, newAppointment);
			return true;
		}

		return false;

	}

	public ArrayList<Appointment> getAppointments() {
		return appointments;
	}

	public ArrayList<Patient> getPatients() {
		return patients;
	}

	public ArrayList<Integer> getType() {
		return type;
	}
	



}

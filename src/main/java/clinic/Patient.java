package clinic;

import java.util.ArrayList;
import java.util.List;

public class Patient extends Users {
	private List<Service> selectedServices = new ArrayList<>();
	private double doctorVisit;

	public Patient(String userName, String password, String role) {
		super(userName, password, role);
	}

	public List<Service> getSelectedServices() {
		return selectedServices;
	}

	public boolean setSelectedServices(List<Service> selectedServices) {
		if (selectedServices.isEmpty())
			return false;

		this.selectedServices = selectedServices;
		return true;
	}


	public double getDoctorVisit() {
		return doctorVisit;
	}

	public void setDoctorVisit(double doctorVisit) {
		this.doctorVisit = doctorVisit;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Patient)) {
			return false;
		} else {
			Patient other = (Patient) o;
			return (this == other);
		}
	}

	@Override
	public int hashCode() {
		return 0;
	}

}

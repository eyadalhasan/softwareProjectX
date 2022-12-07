package clinicsys;

import io.cucumber.java.en.*;
import static org.junit.Assert.assertEquals;

import clinicsys.Appointment;
import clinicsys.Doctor;
import clinicsys.Patient;
import clinicsys.Record;
import clinicsys.Secretary;

public class VisitSteps {
	
	Secretary secretary;
	Patient patient;
	Doctor doctor;
	Record record = new Record();
	int index;
	
	public VisitSteps() {
		doctor = new Doctor("Hamza", "hamza123", "Doctor");
		doctor.signIn("Hamza", "hamza123");
		patient = new Patient("Maen", "maen123", "Patient");
		secretary = new Secretary("MNS", "mns123", "Secretary");
		secretary.signIn("MNS", "mns123");	
		record.addAppointment(new Appointment("05", "01", "2022", "11"), patient);
	}
	
	@Given("the secretary is logged in")
	public void the_secretary_is_logged_in() {
	    assertEquals(secretary.isSignedIn(), true);
	}

	@When("a patient arrived to clinic on his appointment")
	public void a_patient_arrived_to_clinic_on_his_appointment() {
		index = record.getPatients().indexOf(patient);
	}

	@Then("a visit will be recorded")
	public void a_visit_will_be_recorded() {
	   assertEquals(record.addVisit(record.getAppointments().get(index)), true);
	}

	@When("a patient arrived to clinic without appointment")
	public void a_patient_arrived_to_clinic_without_appointment() {

	}

	@When("the doctor is available")
	public void the_doctor_is_available() {
		doctor.setAvailability(true);

	}

	@When("the doctor is not available")
	public void the_doctor_is_not_available() {
		doctor.setAvailability(false);

	}

	@Then("an appointment will be recorded")
	public void an_appointment_will_be_recorded() {
		if (doctor.isAvailable())
			record.addAppointment(new Appointment("14", "05", "2022", "3"), patient);
	}

}

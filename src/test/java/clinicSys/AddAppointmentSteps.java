package clinicSys;

import io.cucumber.java.en.*;
import static org.junit.Assert.assertEquals;

public class AddAppointmentSteps {
	
	String day, month, year, time;
	Patient patient;
	Record record = new Record();
	
	public AddAppointmentSteps() {
		patient = new Patient("Maen", "maen123", "Patient");
		patient.signIn("Maen", "maen123");
		record.addAppointment(new Appointment("05", "01", "2022", "11"), patient);
		record.addAppointment(new Appointment("14", "05", "2022", "3"), patient);
	}

	@Given("the patient is logged in")
	public void the_patient_is_logged_in() {
	   assertEquals(patient.isSignedIn(), true);
	}

	@Given("he\\/she choose day {string}")
	public void he_she_choose_day(String string) {
	    this.day = string;
	}

	@Given("he\\/she choose month {string}")
	public void he_she_choose_month(String string) {
		this.month = string;
	}

	@Given("he\\/she choose year {string}")
	public void he_she_choose_year(String string) {
		this.year = string;
	}

	@Given("he\\/she choose time {string}")
	public void he_she_choose_time(String string) {
		this.time = string;
	}

	@Then("this appointment will book for this patient")
	public void this_appointment_will_book_for_this_patient() {
	    assertEquals(record.addAppointment(new Appointment(day, month, year, time), patient), true);
	}

	@Then("the error message {string} will appear")
	public void the_error_message_will_appear(String string) {
		assertEquals(record.addAppointment(new Appointment(day, month, year, time), patient), false);

	}

}

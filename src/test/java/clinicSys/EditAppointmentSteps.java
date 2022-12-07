package clinicSys;

import io.cucumber.java.en.*;
import static org.junit.Assert.assertEquals;

import clinicSys.Appointment;
import clinicSys.Patient;
import clinicSys.Record;

public class EditAppointmentSteps {

	String day, month, year, time;
	Patient patient;
	Appointment oldAppointment = new Appointment("05", "01", "2022", "11");
	Appointment newdAppointment;
	Record record = new Record();
	
	public EditAppointmentSteps() {
		patient = new Patient("Maen", "maen123", "Patient");
		patient.signIn("Maen", "maen123");
		record.addAppointment(oldAppointment, patient);
		record.addAppointment(new Appointment("14", "05", "2022", "3"), patient);
	}
	
	@Given("he\\/she want to edit this appointment to another time")
	public void he_she_want_to_edit_this_appointment_to_another_time() {

	}

	@When("he\\/she click on {string} button Next to each appointment")
	public void he_she_click_on_button_next_to_each_appointment(String string) {

	}

	@When("he\\/she should  choose another avaliable appointment to book")
	public void he_she_should_choose_another_avaliable_appointment_to_book() {
		newdAppointment = new Appointment("20", "03", "2022", "1");

	}

	@Then("this appointment will be booked for this patient")
	public void this_appointment_will_be_booked_for_this_patient() {
	    assertEquals(record.editAppointment(oldAppointment, newdAppointment, patient), true);
	}

	@When("he\\/she  choose unavailable time")
	public void he_she_choose_unavailable_time() {
		newdAppointment = new Appointment("14", "05", "2022", "3");
		assertEquals(record.editAppointment(oldAppointment, newdAppointment, patient), false);
	}

	@Then("error message will appear {string}")
	public void error_message_will_appear(String string) {
	    System.out.println(string);
	}
}


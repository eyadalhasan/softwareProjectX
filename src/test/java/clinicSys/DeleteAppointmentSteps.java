package clinicSys;

import io.cucumber.java.en.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.logging.Level;
import java.util.logging.Logger;

import clinicSys.Appointment;
import clinicSys.Patient;
import clinicSys.Record;

public class DeleteAppointmentSteps {
	
	Patient patient;
	Record record = new Record();
	
	public DeleteAppointmentSteps() {
		patient = new Patient("Maen", "maen123", "Patient");
		patient.signIn("Maen", "maen123");
		record.addAppointment(new Appointment("05", "01", "2022", "11"), patient);
		record.addAppointment(new Appointment("14", "05", "2022", "3"), patient);
	}
	
	@Given("he\\/she is opening the appointment page")
	public void he_she_is_opening_the_appointment_page() {

	}

	@Given("he\\/she has at leaset one appointment")
	public void he_she_has_at_leaset_one_appointment() {
	    assertTrue(record.getPatients().contains(patient));
	}

	@Given("he\\/she want to delete this appointment")
	public void he_she_want_to_delete_this_appointment() {
	    
	}

	@When("he\\/she click on {string} button Next to edit button")
	public void he_she_click_on_button_next_to_edit_button(String string) {

	}

	@When("click on {string} from the confirmation message")
	public void click_on_from_the_confirmation_message(String string) {

	}

	@Then("this appointment will be deleted")
	public void this_appointment_will_be_deleted() {
		assertTrue(record.deleteAppointment(new Appointment("05", "01", "2022", "11")));
	}

	@Then("success message appear {string}")
	public void success_message_appear(String string) {
		Logger logger
    	=Logger.getLogger(
    	   Invoice.class.getName());
		
		   logger.log(Level.INFO,string);
	}

	@Then("this appointment will not be deleted")
	public void this_appointment_will_not_be_deleted() {
		assertTrue(record.getAppointments().contains(new Appointment("05", "01", "2022", "11")));
	}

}

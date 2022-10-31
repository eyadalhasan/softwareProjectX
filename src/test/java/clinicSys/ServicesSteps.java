package clinicSys;

import io.cucumber.java.en.*;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class ServicesSteps {

	Patient patient;
	int index;
	boolean available;
	ArrayList<Service> servicesList = new ArrayList<Service>();
	ArrayList<Service> selectedServices = new ArrayList<Service>();

	public ServicesSteps() {
		servicesList.add(new Service("Toothbrush", 50, 5.00));
		servicesList.add(new Service("Toothpaste", 0, 10.00));
		servicesList.add(new Service("Painkiller", 50, 15.00));
		patient = new Patient("Maen", "maen123", "Patient");
		patient.signIn("Maen", "maen123");
	}

	@Given("the patinet is logged in")
	public void the_patinet_is_logged_in() {
		assertEquals(patient.isSignedIn(), true);
	}

	@Given("the patinet want to select a service")
	public void the_patinet_want_to_select_a_service() {
		int i = 1;
		for (Service service : servicesList) {
			System.out.println(i++ + ". " + service);
		}
	}

	@When("the patient select a service {string}")
	public void the_patient_select_a_service(String string) {
		index = Integer.parseInt(string);
		System.out.println(index);
	}

	@When("the service is available")
	public void the_service_is_available() {
		available = servicesList.get(index).getQuantity() != 0;
		assertEquals(available, true);
	}

	@Then("the service price will be added to the invoice")
	public void the_service_price_will_be_added_to_the_invoice() {
		if (available) {
			selectedServices.add(servicesList.get(index));
			assertEquals(patient.setSelectedServices(selectedServices), true);
		}
	}

	@Then("message displayed {string}")
	public void message_displayed(String string) {
		System.out.println(string);
	}

	@When("the service is not available")
	public void the_service_is_not_available() {
		available = servicesList.get(index).getQuantity() != 0;
		assertEquals(available, false);
	}

}

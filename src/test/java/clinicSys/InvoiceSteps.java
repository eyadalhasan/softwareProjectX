package clinicSys;

import io.cucumber.java.en.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import clinicSys.Invoice;
import clinicSys.Patient;
import clinicSys.Secretary;
import clinicSys.Service;

public class InvoiceSteps {
	
	Patient patient;
	Secretary secretary;
	int index;
	boolean available;
	ArrayList<Service> selectedServices = new ArrayList<Service>();
	Invoice invoice;
	Double doctorVisit;

	public InvoiceSteps() {
		selectedServices.add(new Service("Painkiller", 50, 15.00));
		patient = new Patient("Maen", "maen123", "Patient");
		patient.signIn("Maen", "maen123");
		secretary = new Secretary("MNS", "mns123", "Secretary");
		secretary.signIn("MNS", "mns123");
	}
	
	@When("the patinet finished his visit")
	public void the_patinet_finished_his_visit() {
		doctorVisit = 200.00;
	    invoice = new Invoice(selectedServices, doctorVisit);
	}

	@Then("the secretary will issue the invoice")
	public void the_secretary_will_issue_the_invoice() {
	    assertTrue(invoice.printInvoice());
	}

}

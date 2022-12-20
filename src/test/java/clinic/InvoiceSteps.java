package clinic;

import io.cucumber.java.en.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import clinic.Invoice;
import clinic.Patient;
import clinic.Secretary;
import clinic.Service;

public class InvoiceSteps {
	
	Patient patient;
	Secretary secretary;
	int index;
	boolean available;
	Invoice invoice;

	public InvoiceSteps() {
		patient = new Patient("Maen", "maen123", "Patient");
		patient.signIn("Maen", "maen123");
		secretary = new Secretary("MNS", "mns123", "Secretary");
		secretary.signIn("MNS", "mns123");
		patient.getSelectedServices().add(new Service("Painkiller", 50, 15.00));
	}
	
	@When("the patinet finished his visit")
	public void the_patinet_finished_his_visit() {
		patient.setDoctorVisit(200.00);
	    invoice = new Invoice(patient.getSelectedServices(), patient.getDoctorVisit());
	}

	@Then("the secretary will issue the invoice")
	public void the_secretary_will_issue_the_invoice() {
	    assertTrue(invoice.printInvoice());
	    invoice.total = 0.0;
	    assertEquals(false, invoice.printInvoice());
	}

}

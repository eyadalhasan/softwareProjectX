package clinic;

import io.cucumber.java.en.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import clinic.Appointment;
import clinic.Patient;
import clinic.Record;
import clinic.Report;
import clinic.Secretary;
import clinic.Service;


public class ReportSteps {
	
	String day, month, year, time;
	Patient patient;
	Secretary secretary;
	Record record = new Record();
	int numOfVisits = 0;
	Report report = new Report();
	String date;
	
	ArrayList<Service> servicesList = new ArrayList<Service>();
	
	public ReportSteps() {
		patient = new Patient("Maen", "maen123", "Patient");
		patient.signIn("Maen", "maen123");
		secretary = new Secretary("MNS", "mns123", "Secretary");
		secretary.signIn("MNS", "mns123");
		record.addAppointment(new Appointment("05", "01", "2022", "11"), patient);
		record.addAppointment(new Appointment("02", "05", "2022", "9"), patient);
		record.addAppointment(new Appointment("14", "05", "2022", "3"), patient);
		
		record.addVisit(new Appointment("05", "01", "2022", "11"));
		record.addVisit(new Appointment("02", "05", "2022", "9"));
		record.addVisit(new Appointment("14", "05", "2022", "3"));
		
		servicesList.add(new Service("Toothbrush", 50, 5.00));
		servicesList.add(new Service("Toothpaste", 0, 10.00));
		servicesList.add(new Service("Painkiller", 50, 15.00));
	}

	@When("and he\\/she want to check the number of visitors in a certain month {string}")
	public void and_he_she_want_to_check_the_number_of_visitors_in_a_certain_month(String string) {
	    this.month = string;
	}

	@When("he choose visitors list for a certain month")
	public void he_choose_visitors_list_for_a_certain_month() {
		for (int i = 0; i < record.getAppointments().size(); i++) {
			if (record.getType().get(i) == 2 && record.getAppointments().get(i).getMonth().equals(month)) {
				date = record.getAppointments().get(i).getDay() + "/" + record.getAppointments().get(i).getMonth() + "/" + record.getAppointments().get(i).getYear();	
				time = record.getAppointments().get(i).getTime();
				numOfVisits++;
			}
		}
	}

	@When("click on button {string}")
	public void click_on_button(String string) {
		
	}
	
	@Then("a report of number of visitors will be generated")
	public void a_report_of_number_of_visitors_will_be_generated() {
		assertTrue(report.numOfVisitsReport(numOfVisits, month));
	}


	@When("and he\\/she want to check the number of available services")
	public void and_he_she_want_to_check_the_number_of_available_services() {

	}

	@When("he\\/she choose services list")
	public void he_she_choose_services_list() {

	}
	
	@Then("a report of available services will be generated")
	public void a_report_of_available_services_will_be_generated() {
	    assertTrue(report.availableServicesReport(servicesList));
	}

}

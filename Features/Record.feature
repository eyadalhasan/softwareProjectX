Feature: Add Appointment to a Clinic appointment system
	Description:add an appointment to the clinic appointment system
	Actors: Patient

Scenario: Add an appointment successfully
 	Given that the patient is logged in
 	And there is an appointment is not reserved
 	When the appointment is booked
 	Then the appointment will be exist at the clinic appointment system
 	
Scenario: Add an appointment unsuccessfully
 	Given that the patient is logged in
 	And the appointment was reserved
 	When the patient try to reserve this appointment
 	Then the error message "This appointment was reserved by another patient" will appear
 	
Scenario: Add an appointment unsuccessfully
 	Given that the patient is logged in
 	And all appointments for this week was reserved
 	When the patient try to reserve this appointment
 	Then the error message "All appointments for this week were booked" will appear
 	
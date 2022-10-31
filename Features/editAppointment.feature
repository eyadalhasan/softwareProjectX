Feature: Edit Appointment in Clinic 
	Description: Edit an appointment in the clinic appointment system
	Actors: Patient
	
Scenario: the patient edit his appointment successfully 
	Given the patient is logged in 
	And he/she is opening the appointment page 
	And  he/she has at leaset one appointment 
	And he/she want to edit this appointment to another time 
	When he/she click on "edit" button Next to each appointment 
	And he/she should  choose another avaliable appointment to book 
	Then this appointment will be booked for this patient 
	And success message appear "Done" 
	
	
Scenario: the patient edit his appointment unsuccessfully 
	Given the patient is logged in 
	And he/she is opening the appointment page 
	And  he/she has at leaset one appointment 
	And he/she want to edit this appointment to another time 
	When he/she click on "edit" button Next to each appointment 
	And he/she  choose unavailable time 
	Then error message will appear "choose another time to book"
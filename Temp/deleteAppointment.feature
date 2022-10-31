Feature: Delete Appointment in Clinic 
	Description: Delete an appointment in the clinic appointment system
	Actors: Patient
	
Scenario: the patient delete his appointment 
	Given the patient is logged in 
	And he/she is opening the appointment page 
	And  he/she has at leaset one appointment 
	And he/she want to delete this appointment 
	When he/she click on "delete" button Next to edit button 
	And click on "Yes" from the confirmation message 
	Then this appointment will be deleted 
	And success message appear "Done" 
	
Scenario: the patient try to delete his appointment 
	Given the patient is logged in 
	And he/she is opening the appointment page 
	And  he/she has at leaset one appointment 
	And he/she want to delete this appointment 
	When he/she click on "delete" button Next to edit button 
	And click on "No" from the confirmation message 
	Then this appointment will not be deleted
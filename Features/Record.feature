Feature: Add record for Patients 
	Description: Add a record to the clinic appointment system
	Actors: Secretary 
	
Scenario: Recording an appointment or a visit made by a patient 
	When secretary is logged in 
	And a patient made an appointment or visit 
	Then the secretary will record the appointment or the visit 
	
Feature: add record for Patients
	Description: add a record to the clinic appointment system
	Actors: Secretary 
	

Scenario: recording an appointment or a visit made by a patient
	When secretary is logged in
	And a patient made an appointment or visit
	Then The Secretary will record the appointment or the visit
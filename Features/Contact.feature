Feature: Contact with patients
	Description: Each doctor will contact with patients in some circumstance
	Actors: Doctor
	
Scenario: The doctor will postpone appointment
	Given that the doctor is logged in 
	And the doctor clicked on the patient list
	And he/she get the patient phone number
	Then the doctor will contact with the patient to postpone appointment

Scenario: The doctor will early appointment
	Given that the doctor is logged in 
	And the doctor clicked on the patient list
	And he/she get the patient phone number
	Then the doctor will contact with the patient to early appointment

Feature: Show Visit for Patients
	Description: show a visit to the clinic appointment system
	Actors: Secretary 
	
	
Scenario: the patinet visit the clinic on his appointment
Given The secretary is logged in
When a patient arrived to clinc on his appointment
Then a visit will be recorded

Scenario: the patinet visit the clinic without appointment
Given The secretary is logged in
When a patient arrived to clinic without appointment
And the doctor is available
Then a visit will be recorded

Scenario: the patinet visit the clinic without appointment
Given The secretary is logged in
When a patient arrived to clinic without appointment
And the doctor is not available
Then an appointment will be recorded

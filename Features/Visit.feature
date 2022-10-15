Feature: Show Visit for Patients
	Description: add a visit to the clinic appointment system
	Actors: Patient and Secretary and Doctor and Admin

Scenario: The user is secretary and he/she is logged in
	When secretary check a visit list
	Then the patients visit list and their appointments will be appear
	
Scenario: The user is doctor and he/she is logged in
	When doctor check a visit list
	Then the patients visit list who reserved for this doctor and their appointments will be appear
	
Scenario: The user is admin and he/she is logged in
	When admin check a visit list
	Then the patients visit list and their appointments will be appear
	
Scenario: The user is patient and he/she is logged in
	When patient check his visit list
	Then this patient visit list and his/her appointments will be appear
	
	
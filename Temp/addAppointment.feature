Feature: Add Appointment to a Clinic appointment system 
	Description: Add an appointment to the clinic appointment system
	Actors: Patient
	
Scenario Outline: Add an appointment successfully 
	Given the patient is logged in 
	Given he/she choose day <Day> 
	And he/she choose month <Month>
	Given he/she choose year <Year>
	And he/she choose time <Time> 
	Then this appointment will book for this patient 
	Examples: 
		|Day|Month|Year|Time|
		|"05"|"07"|"2022"|"2"|
		|"12"|"10"|"2022"|"9"|
		
		
Scenario Outline: Add an appointment unsuccessfully 
	Given the patient is logged in 
	Given he/she choose day <Day> 
	And he/she choose month <Month>
	Given he/she choose year <Year>
	And he/she choose time <Time>
	Then the error message "This appointment was reserved by another patient" will appear 
	Examples: 
		|Day|Month|Year|Time|
		|"05"|"01"|"2022"|"11"|
		|"14"|"05"|"2022"|"3"|
		
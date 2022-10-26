Feature: Add Appointment to a Clinic appointment system 
	Description: Add an appointment to the clinic appointment system
	Actors: Patient
	
Background: 
	Given the patient is logged in 
	And he/she open the appointment table 
	When the patient choose one of the following appointments from the table 
		|1|10-11| Yes|
		|1|11-12|No|
		|1|12-1|No|
		|1|2-3|Yes|
		|1|3-4|No|
		|1|4-5|Yes|
		
		|2|10-11| Yes|
		|2|11-12|No|
		|2|12-1|No|
		|2|2-3|Yes|
		|2|3-4|No|
		|2|4-5|Yes|
		
		|3|10-11| Yes|
		|3|11-12|No|
		|3|12-1|No|
		|3|2-3|Yes|
		|3|3-4|Yes|
		|3|4-5|Yes|
		
		|4|10-11|Yes|
		|4|11-12|No|
		|4|12-1|No|
		|4|2-3|Yes|
		|4|3-4|Yes|
		|4|4-5|Yes|
		
		|5|10-11|Yes|
		|5|11-12|No|
		|5|12-1|No|
		|5|2-3|Yes|
		|5|3-4|Yes|
		|5|4-5|Yes|
		
Scenario Outline: Add an appointment successfully 
	Given he/she choose day <Month> 
	And he/she choose day <Day> 
	And he/she choose time <Time> 
	Then this appointment will book for this patient 
	Examples: 
		|Month|Day|Time|Availability|
		|1 |1|"2-3"|"Yes"|
		|1 |1|"4-5"|"Yes"|
		
		
Scenario Outline: Add an appointment unsuccessfully 
	Given he/she choose day <Day> 
	And he/she choose time <Time> 
	Then the error message "This appointment was reserved by another patient" will appear 
	Examples: 
		|Month|Day|Time|Availability|
		|1 |1|"11-12"|"No"|
		|1 |1|"12-1"|"No"|
		
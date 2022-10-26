Feature: Generating a report 
	Description: Generating a report
	Actors: Doctor, Secretary 
	
Scenario: The patinet finished his visit 
	When the patinet finished his visit 
	Then the doctor will generate a report 
	
Scenario: 
	The secretary need to generate a report for the number of visitors in a certain month 
	When the secretary is logged in 
	And and he/she want to check the number of visitors in a certain month 
	And he choose visitors list for a certain month 
	And click on button "Generate report" 
	Then a report will be printed on paper 
	
Scenario: 
	The secretary need to generate a report for the available services 
	When the secretary is logged in 
	And and he/she want to check the number of available services 
	And he/she choose services list 
	And click on button "Generate report" 
	Then a report will be printed on paper 
 
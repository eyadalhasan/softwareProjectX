Feature: Generating a report 
	Description:generating a report
	Actors: Doctor,Secretary 
	
Scenario: The patinet finished his visit 
	When the patinet finished his visit 
	Then the Doctor will generate a report
	
	
Scenario: The Secretary need to genterate a report for the number of visitors in a certain month
When the Secretary is logged in 
And and he/she want to check the  number of visitors in a certain month
And he choose visitors list for a certain month
And click on button "Generate report"  
Then A report will be printed on paper





 
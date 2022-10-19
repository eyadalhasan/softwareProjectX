Feature: Generating a report 
	Description:generating a report
	Actors: Doctor
	
Scenario: The patinet finished his visit 
	When the patinet finished his visit 
	Then the Doctor will generate a report 

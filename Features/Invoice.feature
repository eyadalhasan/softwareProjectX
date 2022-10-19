Feature: Issuing an invoice 
	Description:issuing an invoice
	Actors: Secretary
	
Scenario: The patinet finished his visit 
	When the patinet finished his visit 
	Then the Secretary will issue the invoice

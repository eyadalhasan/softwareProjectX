Feature: Issuing an invoice 
	Description: Issuing an invoice
	Actors: Secretary
	
Scenario: The patinet finished his visit 
	When the patinet finished his visit 
	Then the secretary will issue the invoice 

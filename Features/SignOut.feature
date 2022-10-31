Feature: Users Sign Out 
	Description: The Users signed out of the Clinic Management System
	Actor: All Users

Background: 
	Given the users credentials 
		|Eyad     |eyad123   |Admin |
		|Hamza    |hamza123  |Doctor|
		|Maen     |maen123   |Patient|
		|MNS      |mns123  |Secretary|
		
Scenario Outline: the <role> signed out 
	Given that the <role> is signed in 
	When the <role> signs out 
	Then the <role> is not signed in 
	Examples: 
		|username |password  |role|
		|"Eyad"     |"eyad123"   |"Admin" |
		|"Hamza"    |"hamza123"  |"Doctor"|
		|"Maen"     |"maen123"   |"Patient"|
		|"MNS"      |"mns123"    |"Secretary"|
		
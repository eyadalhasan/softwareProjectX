Feature: Users Sign in 
	Description: The Admin signs into Clinic Management System
	Actor: Admin
Background: 

	Given the user on the login page 
	When the user enter one of the following user name and password regardless his role
		|user name |password  |role |
		|eyad      |eyad123   |admin |
		|hamza     |hamza123  |doctor|
		|maen      |maen123   |patient|
		|ahmad     |ahmad123   |secretary|
		
Scenario Outline: the <role> the right credentials 
	Given That the <role> is not signed in 
	And the <role> username is <username> 
	And the <role> password is <password> 
	Then the <role> sign in succeeds 
	And the <role> is signed in 
	Examples: 
		|username |password  |role|
		|"Eyad"     |"eyad123"   |"Admin" |
		|"Hamza"    |"hamza123"  |"Doctor"|
		|"Maen"     |"maen123"   |"Patient"|
		|"MNS"      |"mns123"    |"Secretary"|
	
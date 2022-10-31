Feature: Users Sign in 
	Description: The Admin signs into Clinic Management System
	Actor: Admin
	
Background: 
	Given the user on the login page 
	When the user enter one of the following user name and password regardless his role 
		|Eyad     |eyad123   |Admin |
		|Hamza    |hamza123  |Doctor|
		|Maen     |maen123   |Patient|
		|MNS      |mns123  |Secretary|
		
Scenario Outline: the <role> enter valid credentials 
	Given That the <role> is not signed in 
	And the <role> username is <username> 
	And the <role> password is <password> 
	Then the <role> sign in succeeds 
	And the <role> is signed in 
	Then go to <role> page 
	Examples: 
		|username |password  |role|
		|"Eyad"     |"eyad123"   |"Admin" |
		|"Hamza"    |"hamza123"  |"Doctor"|
		|"Maen"     |"maen123"   |"Patient"|
		|"MNS"      |"mns123"    |"Secretary"|
		
		
Scenario Outline: the <role> enter invalid credentials 
	Given That the <role> is not signed in 
	And the <role> username is <username> 
	And the <role> password is <password> 
	Then the <role> sign in not succeeds 
	And the <role> is not signed in 
	
	Examples: 
		|username   |password      |role|
		|"Eyad"     |"eyad1231"   |"Admin" |
		|"Hamza"    |"hamza1231"  |"Doctor"|
		|"Maen"     |"maen1231"   |"Patient"|
		|"MNS"      |"mns1231"    |"Secretary"|

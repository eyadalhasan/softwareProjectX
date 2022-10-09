Feature: Users Sign in 
	Description: The Admin signs into Clinic Management System
	Actor: Admin
	
Background: 
	Given the user on the login page 
	When the user enter one of the following user name and password regardless his role 
		|Eyad      |eyad123   |Admin |
		|Hamza     |hamza123  |Doctor|
		|Maen      |maen123   |Patient|
		|MNS       |mns123    |Secretary|
		
		
Scenario: Admin has the right credentials 
	Given That the Admin is not signed in 
	And the Admin username is "Eyad" 
	And the Admin password is "eyad123" 
	Then the Admin sign in succeeds 
	And the Admin is signed in 
	
Scenario: Doctor has the right credentials 
	Given That the Doctor is not signed in 
	And the Doctor username is "Hamza" 
	And the Doctor password is "hamza123" 
	Then the Doctor sign in succeeds 
	And the Doctor is signed in 
	
Scenario: Patient has the right credentials 
	Given That the Patient is not signed in 
	And the Patient username is "Maen" 
	And the Patient password is "maen123" 
	Then the Patient sign in succeeds 
	And the Patient is signed in 
	
Scenario: Secretary has the right credentials 
	Given That the Secretary is not signed in 
	And the Secretary username is "MNS" 
	And the Secretary password is "mns123" 
	Then the Secretary sign in succeeds 
	And the Secretary is signed in 
	
Scenario: Admin has a wrong password 
	Given That the Admin is not signed in 
	And the Admin username is "Eyad" 
	And the Admin password is not "eyad123" 
	Then the Admin sign in fails 
	And the Admin is not signed in 
	
	
Scenario: Admin has a wrong username 
	Given That the Admin is not signed in 
	And the Admin username is not "Eyad" 
	Then the Admin sign in fails 
	And the Admin is not signed in 
	
Scenario: Doctor has a wrong password 
	Given That the Doctor is not signed in 
	And the Doctor username is "Hamza" 
	And the Doctor password is not "hamza123" 
	Then the Doctor sign in fails 
	And the Doctor is not signed in 
	
	
Scenario: Doctor has a wrong username 
	Given That the Doctor is not signed in 
	And the Doctor username is not "Hamza" 
	Then the Doctor sign in fails 
	And the Doctor is not signed in 
	
Scenario: Patient has a wrong password 
	Given That the Patient is not signed in 
	And the Patient username is "Maen" 
	And the Patient password is not "maen123" 
	Then the Patient sign in fails 
	And the Patient is not signed in 
	
	
Scenario: Patient has a wrong username 
	Given That the Patient is not signed in 
	And the Patient username is not "Maen" 
	Then the Patient sign in fails 
	And the Patient is not signed in 
	
Scenario: Secretary has a wrong password 
	Given That the Secretary is not signed in 
	And the Secretary username is "MNS" 
	And the Secretary password is not "mns123" 
	Then the Secretary sign in fails 
	And the Secretary is not signed in 
	
	
Scenario: Secretary has a wrong username 
	Given That the Secretary is not signed in 
	And the Secretary username is not "MNS" 
	Then the Secretary sign in fails 
	And the Secretary is not signed in 
	
	
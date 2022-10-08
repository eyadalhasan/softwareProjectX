Feature: Admin Login
	Description: The Admin signs into Clinic Management System
	Actor: Admin


Scenario: Admin has the right credentials
	Given That the Admin is not signed in
	And the Username is "adminMNS"
	And the password is "adminclinicMNS"
	Then the Admin sign in succeeds
	And the Admin is signed in
	
	
Scenario: Admin has a wrong password
	Given That the Admin is not signed in
	And the Username is "adminMNS"
	And the password is not "adminclinicMNS"
	Then the Admin sign in fails
	And the Admin is not signed in
	
	
Scenario: Admin has a wrong username
	Given That the Admin is not signed in
	And the Username is not "adminMNS"
	Then the Admin sign in fails
	And the Admin is not signed in
	
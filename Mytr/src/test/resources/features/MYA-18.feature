Feature: MYA-18
	Feature Outline: Ability to receive a message prompt for login error

Background:
	Given I am in Pearl AAA login page 


@Smoke 
Scenario: Invalid Username 
	
	When I submit "Invalid_Username" and "Valid_Password" 
	Then I should see error message highlighting Unsuccessful login attempt 
	
@Smoke 
Scenario: Improper Domain 
	
	When I submit "Username_With_Improperdomain" and "Valid_Password" 
	Then I should see error message highlighting Unsuccessful login attempt 
	
@Smoke
Scenario: Invalid Password 
	 
	When I submit "Valid_Username" and "Invalid_Password" 
	Then I should see error message highlighting Unsuccessful login attempt 
	
@Smoke
Scenario: Password with improper format 
	 
	When I submit "Valid_Username"  and "Password with improper format" 
	Then I should see error message highlighting Unsuccessful login attempt 
	
	
@Smoke 
Scenario: InvalidUsername and Invalid Password 
	
	When I submit "Invalid_Username" and "Invalid_Password" 
	Then I should see error message highlighting Unsuccessful login attempt 
	
@Smoke
Scenario: Improper Username and Improper Password 
	 
	When I submit "Username_With_Improperdomain" and "Password with improper format" 
	Then I should see error message highlighting Unsuccessful login attempt
		

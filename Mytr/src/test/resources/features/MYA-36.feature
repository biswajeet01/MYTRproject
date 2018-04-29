Feature: MYA-36
	Feature Outline: Verify that the registered user logs into MyTR Application 



Background:
	Given I am in MyTR Login Page
	
		
 	 Valid Login with remember me
	
	When I entered "validUsername" and "ValidPassword"
	And clicked on remember me checkbox
	When I clicked on Signin button
	Then I should be redirected to MyTR HomePage 
	When I clicked on logout it should display logged out Page
	Given I am relaunching the url
	Then I should see username and password should be prepopulated.
	
	
@Smoke 
Scenario: Verify that Unauth/Auth MyTR user is able to view the Content on the MyTR Header login page
	
	When I click on Discover Thomson Reuters dropdown
	Then I should see the content of Discover Thomson Reuters	
	
@Smoke 
Scenario: Verify that Unauth/Auth MyTR user is able to view the Content on the MyTR Footer login page
	
	When I click on Support and Training
	Then I should be redirected to Support and Training page
	When I click on Contact us
	Then I should be redirected to Contact us page
	
@Smoke 
Scenario: Verify that Unauth/Auth MyTR user is able to view the Content on the MyTR Body login page

	Then I should see the Body Content like username ,password, forgotten password and remember me
	When I click on remember me check box 
	Then I should be able to uncheck the checkbox
	When I click on forgotten password link 
	Then I should be redirected to forgotten password page
	

	
	
	
	
	
	
	
	
	
	
	
		
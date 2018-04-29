Feature: MYA-26
	Feature Outline: Ability to Contact Us (without login) if username is forgotten


Background:
	Given I am in MyTR Page
	When I click on Contact Us button 
	Then I should be navigated to Contact Us page
	When I click on Website Support it should display Website Support Page
	Then I should see the link for I am unable to log into My Account
	When I click on the link
	Then I should be redirected to I am unable to log into My Account Page
		
@Smoke 
Scenario: Raise_case_unauth_forgot_username
	
	When I entered all the mandatory fields
	And  clicked on Submit 
	Then system should display case id
	
@Smoke 
Scenario: Raise_case_unauth_forgot_username_fields_wrong
	
	When I entered invalid country and wrong mail format
	And  clicked on Submit 
	Then system should display error message for wrongly entered details
	

	
@Smoke 
Scenario: Raise_case_unauth_forgot_username_fields_blank
	
	
	When I click on submit button without filling any fields 
	Then system should display error message
	
@Smoke 
Scenario: Email_notification_username
	
	When I entered all the mandatory fields
	And  clicked on Submit 
	Then system should display case id 
	Given I am logged into Mail Inbox
 	Then verify the notification mail for username details
	
	
	
	
	
		
	
	
	
	
	
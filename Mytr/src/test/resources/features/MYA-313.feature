Feature: MYA-313
	Feature Outline: Ability to log out of MyTR 



Background:
	Given I am a logged in to MyTR
	Then Click on logout button
	
Scenario: MyTR_Logout_Options_OK

	Then verify the logout functionality by clicking ok button from logout popup
	Then it Should be redirected to logout Page
	
Scenario: MyTR_Logout_Options_Cancel
	
	Then Verify the logout functionality by clicking Cancel button from logout popup
	Then it should stay in MyTR Homepage
	

Feature: MYA-23-38-104
	Feature Outline: Ability to request a password reset 



Background:
	Given I am in MyTR Login Page
	When I clicked on forgotten your password link
	Then I should be redirected to password assistance page
	Then verify the contents of password assistance page
	
@Smoke 
Scenario Outline: ForgotPassword_EmailSent
	
	When I entered "<emailid>" and clicked on ok
	Then Verify content of password assistance page after mail sent
	
	Examples:
	|emailid|
	|jana.narmy@mailinator|
	|jana.narayanmailinator.com|
	|jana.narayan@mailnor.com|
	|jan.naraymailinator.com|
	|jana.narayan@mailinator.com|
	
@Smoke
Scenario: ForgotPassword_EmailSent_Logs in MyTR

 	Given I am logged into Mail Inbox
 	Then verify the notification mail for password reset
 	And verify the Email template contents of password reset mail before clicking the password reset link
 	Then reset the password
 	Then verify signin functionality.
 	
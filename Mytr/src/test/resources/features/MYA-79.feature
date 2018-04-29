Feature: Access MYTR from static Url
 Feature Outline: Ability to access MYTR from Static Url
 @Smoke
 Scenario: Accessing static Url
 When I enter the MYTR static url in the browser
 Then I should be directed to MYTR Login Page
 And  I should see Pearl AAA Login box
 
  
 
package mytr.cucmber.ex.stepdefinition;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mytr.cucumber.ex.pages.BasePage;
import mytr.cucumber.ex.pages.ContactUsPage;
import mytr.cucumber.ex.pages.LoginPage;
import mytr.cucumber.ex.pages.MailPage;
import mytr.cucumber.ex.pages.PasswordAssistancePage;

public class MYA23StepDefinition {


	WebDriver driver;
	ContactUsPage contactuspage;
	MailPage mailpage;
	BasePage basepage;
	PasswordAssistancePage pwdassitpage;
	LoginPage loginpage;

	public  MYA23StepDefinition() 
	{ 

	driver = CucumberSetup.getDriver();
	contactuspage = new ContactUsPage(driver);
	
	
	}
	
	@When("^I clicked on forgotten your password link$")
	public void clickForgottenpwdlink()
	{
		loginpage.clickForgottenPassword();
	}

	@Then("^I should be redirected to password assistance page$")
	public void navigatetoPwdAssitPage()
	{
	loginpage.navigatedtoForgottenPasswordPage();	
	}

	@Then("^verify the contents of password assistance page$")
	public void verifyContents()
	{
		pwdassitpage.verifyPasswordAssistancePageContent();
	}
	
	@When("^I entered \"([^\"]*)\" and clicked on ok$")
	public void verifymailid(String mailid,String errormsgmail ) {
		pwdassitpage.verifyMail(mailid, errormsgmail);
	}

	

	@Then("^Verify content of password assistance page after mail sent$")
	public void verifyContentofPwdassitPage()
	{
		pwdassitpage.verifyEmailSentPageContent();
	}

	
	@Then("^verify the notification mail for password reset$")
	public void notificationMailPwdReset()
	{
		mailpage.mailNotificationVerification();
	}

	@Then("^verify the Email template contents of password reset mail before clicking the password reset link$")
	public void verifyTemplate()
	{
		mailpage.verifyEmailTemplate();
	}

	@Then("^reset the password$")
	public void verifyResetPwd(String ChangeNewPassword,String ConfirmPwd)
	{
		pwdassitpage.resetPassword(ChangeNewPassword, ConfirmPwd);
	}
	@Then("^verify signin functionality\\.$")
public void verifySignin(String username , String ChangeNewPassword)
{
		pwdassitpage.verifySigninAfterResetPassword(username, ChangeNewPassword);
}
}
package mytr.cucmber.ex.stepdefinition;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mytr.cucumber.ex.pages.BasePage;
import mytr.cucumber.ex.pages.ContactUsPage;
import mytr.cucumber.ex.pages.LoginPage;
import mytr.cucumber.ex.pages.MailPage;

public class MYA36StepDefinition {

	WebDriver driver;
	ContactUsPage contactuspage;
	MailPage mailpage;
	BasePage basepage;
	LoginPage loginpage;
	
	public  MYA36StepDefinition() 
	{ 

	driver = CucumberSetup.getDriver();
	contactuspage = new ContactUsPage(driver);
	
	
	}
	
	@Given("^I am in MyTR Login Page$")
	public void launchUrl()
	{
		basepage.launchPearlAAAURL();
	}

	@When("^I entered \"([^\"]*)\" and \"([^\"]*)\"$" )
	public void submit_Username_Password(String username, String password) {
		loginpage.loginToApplication(username, password);
	}

	@When("^clicked on remember me checkbox$")

	public void clickRememberme()
	{
	loginpage.verifyRemembermeCheck();
	}
	
	@When("^I clicked on Signin button$")
	public void verifyLoginFunction()
	{
		loginpage.verifyLogin();
	}
	
	@Then("^I should be redirected to MyTR HomePage$")
	
	public void navigatetoHomePage()
	{
		loginpage.navigatetoHomePage();
	}

	@When("^I clicked on logout it should display logged out Page$")
	public void verifylogout()
	{
		loginpage.verifylogout();
	}


	@Given("^I am relaunching the url$")
	
	public void relaunchUrl()
	{
		basepage.launchPearlAAAURL();
	}
	@Then("^I should see username and password should be prepopulated\\.$")
	
	public void verifyPrepopulated_username_password()
	{
		loginpage.verifyPrePopulated();
	}
	


	
	@When("^I click on Discover Thomson Reuters dropdown$")
	public void clickOnDiscoverTR()
	{
		loginpage.clickonDiscoverTR();
	}

	@Then("^I should see the content of Discover Thomson Reuters$")
	public void verifyDiscoverTR()
	{
		loginpage.verifyContentofDiscoverTR();
	}

	@When("^I click on Support and Training$")
	public void clickSupportandTraining()
	{
		loginpage.clickSupportandTraining();
	}

	@Then("^I should be redirected to Support and Training page$")
	public void navigatetoSupportandTrainingPage()
	{
	loginpage.navigatetoSupportandTraining();
	}

	@When("^I click on Contact us$")
	
	public void clickContactus()
	{
		contactuspage.contactUSPage();
	}

	@Then("^I should be redirected to Contact us page$")
	public void navigatetoContactUsPage()
	{
	contactuspage.navigatetocontactUSPage();
	}

	@Then("^I should see the Body Content like username ,password, forgotten password and remember me$")
	public void verifyContent()
	{
		loginpage.verifyBodyContent();
	}


	@When("I click on remember me check box")
	public void clickCheckbox()
	{
		loginpage.verifyRemembermeCheck();;
	}

	@Then("I should be able to uncheck the checkbox")
	public void uncheckCheckBox()
	{
		loginpage.verifyRemembermeUnCheck();
	}
	
	@When("^I click on forgotten password link$")
	public void clickForgottenpasswordlink()
	{
		loginpage.clickForgottenPassword();
	}
	@Then("^I should be redirected to forgotten password page$")
	public void navigatetoForgottenPasswordPage()
	{		loginpage.navigatedtoForgottenPasswordPage();
	}

	
	@When("^I entered validusername and validpassword$")
	public void submit_validUsername_validPassword(String username, String password)
	{
		loginpage.loginToApplication(username, password);
	}
}
	
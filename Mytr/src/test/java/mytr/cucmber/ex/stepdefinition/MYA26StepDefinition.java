package mytr.cucmber.ex.stepdefinition;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mytr.cucumber.ex.pages.BasePage;
import mytr.cucumber.ex.pages.ContactUsPage;
import mytr.cucumber.ex.pages.MailPage;
public class MYA26StepDefinition 
{
	
		WebDriver driver;
		ContactUsPage contactuspage;
		MailPage mailpage;
		BasePage basepage;
		
		public  MYA26StepDefinition() 
		{ 
	
		driver = CucumberSetup.getDriver();
		contactuspage = new ContactUsPage(driver);
		
		
		}
	
	@Given("^I am in MyTR Page$")
	public void launch_MyTr_Url()
	{
		basepage.launchPearlAAAURL();
	}

	@When("^I click on Contact Us button$")
	public void Click_contactus()
	{
	 contactuspage.contactUSPage();
	}

	@Then("^I should be navigated to Contact Us page$")
	public void navigate_contactus()
	{
		contactuspage.navigatetocontactUSPage();
	}

	@When("^I click on Website Support it should display Website Support Page$")
	public void navigate_WebSiteSupportpage()
	{
		contactuspage.navigatetoWebsiteSupportPage();
	}

	@Then("^I should see the link for I am unable to log into My Account$")
	public void verifyUnabletologinLink()
	{
		contactuspage.verifyUnabletologinLink();
	}

	@When("^I click on the link$")
	public void clickUnabletologinLink()
	{
		contactuspage.clickUnabletoLoginLink();
	}

	@Then("^I should be redirected to I am unable to log into My Account Page$")
	public void navigateUnabletologinLink()
	{
		contactuspage.navigatetounabletologinPage();
	}
	
	/***
	 * Creating Case with Valid Details 
	 * @param name 
	 * @param email
	 * @param country
	 * @param help
	 * @param affect
	 */
	
	@When("^I entered all the mandatory fields$")
	public void submitValidDetails(String name,String email,String country,String help,String affect)
	{
		contactuspage.validDetailsSubmission(name, email, country, help, affect);
	}

	@When("^clicked on Submit$")
	public void clickedSubmit()
	{
		contactuspage.clickSubmit();
	}

	
	@Then("^system should display case id$")
	public void verifyCaseid()
	{
		contactuspage.verifyCaseId();
	}
	
	/***
	 * Verifying case with Invalid Details
	 */
	@When("^I entered invalid country and wrong mail format$")
	public void submitInvalidDetails()
	{
		//need to provide invalid country and mail
	}

	@Then("^system should display error message for wrongly entered details$")
	
	
		public void clickedSubmitwithInvalidDetails()
		{
		
	}
	
	/***
	 * Clicking on submit without entering any mandatory fields
	 */
	@When("^I click on submit button without filling any fields$")
	
	public void leavingAllFieldsBlank()
	{
	contactuspage.invalidCaseSubmission();	
	}
	

	@Then("^system should display error message$")
	public void verifyerrormsg()
	{
	contactuspage.verifyerrormsg();	
	}

	
	/***
	 * Email_notification_username
	 */
	@Given("^I am logged into Mail Inbox$")
	
	public void VerifyLogin(String mailid)
	{
		mailpage.mailLogin(mailid);
	}
	

	@Then("^verify the notification mail for username details$")


	public void verifyUserDetails()
	{
		mailpage.mailNotificationVerification();
	}

}








	
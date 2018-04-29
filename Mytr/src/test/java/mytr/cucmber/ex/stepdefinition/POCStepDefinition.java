package mytr.cucmber.ex.stepdefinition;

import org.openqa.selenium.WebDriver;

import com.framework.config.PropertiesRepository;
import com.framework.handlers.WindowHandler;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import mytr.cucumber.ex.pages.BasePage;
import mytr.cucumber.ex.pages.LoginPage;
import mytr.cucumber.ex.pages.POCLoginPage;;

public class POCStepDefinition {

	WebDriver driver;
	LoginPage loginpage;
	BasePage homePage;
	POCLoginPage POCLoginPage;

	public POCStepDefinition() {
		driver = CucumberSetup.getDriver();
		POCLoginPage = new POCLoginPage(driver);
	}

	@Given("^I am in crdxe lite login page$")
	public void user_in_Loginpage() {
		POCLoginPage.login();
	}

	@When("^I logged in to crdxe lite navigate to TRRedesign$")
	public void navigate_TRRedesign() {
		POCLoginPage.navigate();
	}

	@Then("^I should see case has been submitted successfully after filling the mandatory details$")
	public void Redesign() 
	
	{
		
		POCLoginPage.casesubmission();
	}
}

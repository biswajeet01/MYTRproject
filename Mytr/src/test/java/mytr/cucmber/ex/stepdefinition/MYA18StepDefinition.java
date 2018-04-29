package mytr.cucmber.ex.stepdefinition;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;
import mytr.cucumber.ex.pages.LoginPage;


public class MYA18StepDefinition {
	WebDriver driver;
	LoginPage loginpage;

	public MYA18StepDefinition() {
		driver = CucumberSetup.getDriver();
		loginpage = new LoginPage(driver);
	}

	

	@Then("^I should see error message highlighting Unsuccessful login attempt$")
	public void error_Message_Verification() {
		loginpage.verifyLogin();
	}
}

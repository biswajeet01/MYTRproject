package mytr.cucmber.ex.stepdefinition;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import mytr.cucumber.ex.pages.LoginPage;



public class BaseStepDefinition {
	WebDriver driver;
	LoginPage loginpage;

	public BaseStepDefinition() {
		driver = CucumberSetup.getDriver();
		loginpage = new LoginPage(driver);
	}

	@Given("^I am in Pearl AAA login page$")
	public void launch_Pearl_AAA_LoginPage() {
		loginpage.launchPearlAAAURL();
	}

	@When("^I submit \"([^\"]*)\" and \"([^\"]*)\"$")
	public void submit_Username_Password(String username, String password) {
		loginpage.loginToApplication(username, password);
	}
	
	
}

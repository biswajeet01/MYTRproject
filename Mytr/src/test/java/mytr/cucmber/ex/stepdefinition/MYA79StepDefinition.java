package mytr.cucmber.ex.stepdefinition;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mytr.cucumber.ex.pages.BasePage;
import mytr.cucumber.ex.pages.LoginPage;
import mytr.cucumber.ex.pages.POCLoginPage;

public class MYA79StepDefinition {
	WebDriver driver;
	LoginPage loginpage;
	BasePage homePage;
	POCLoginPage POCLoginPage;

	public MYA79StepDefinition() {
		driver = CucumberSetup.getDriver();
		loginpage = new LoginPage(driver);
	}

	@When("^I enter the MYTR static url in the browser$")
	public void launch_Static_URL() {
		loginpage.launchStaticURL();
	}

	@Then("^I should be directed to MYTR Login Page$")
	public void verify_Page_Title() {
		loginpage.verifyMYTRTitlePage();
	}

	@Then("^I should see Pearl AAA Login box$")
	public void verify_Pearl_AAA_Loginbox() {
		loginpage.verifyPearlAAALoginBox();
	}
}

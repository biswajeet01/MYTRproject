package mytr.cucumber.ex.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.framework.asserts.AssertionHandler;
import com.framework.config.PropertiesRepository;
import com.framework.handlers.WindowHandler;
import com.framework.reports.TestNGCustomReporter;
import com.framework.utils.ExcelUtils;

import mytr.cucumber.ex.obj.repository.LoginPageLocators;
import mytr.cucumber.ex.obj.repository.MailPageLocators;
import mytr.cucumber.ex.obj.repository.PasswordAssistancePageLocators;

public class LoginPage extends BasePage {

	private static Logger logger = LogManager.getLogger(LoginPage.class);

	public LoginPage(WebDriver webDriver) {
		super(webDriver);

	}

	/***
	 * Method is used to verify Body Content in Login Page
	 */

	public void verifyBodyContent() {

		AssertionHandler.verifyTrue(elementHandler.isElementDisplayed(LoginPageLocators.usernameContent),
				"Username content is not displayed");
		TestNGCustomReporter.log(logger, "Username content is displayed");
		AssertionHandler.verifyTrue(elementHandler.isElementDisplayed(LoginPageLocators.passwordContent),
				"Password content is not displayed");
		TestNGCustomReporter.log(logger, "Username content is displayed");
		AssertionHandler.verifyTrue(elementHandler.isElementDisplayed(LoginPageLocators.forgottenyourpasswordlink),
				"Forgotten your password link is not displayed");
		TestNGCustomReporter.log(logger, "Forgotten Your Password link is displayed");
		AssertionHandler.verifyTrue(elementHandler.isElementDisplayed(LoginPageLocators.rememberme),
				"Remember me option is not displayed");
		TestNGCustomReporter.log(logger, "Remember me option is displayed");

	}

	public void verifyRemembermeCheck() {
		elementHandler.clickElement(LoginPageLocators.rememberme, LoginPageLocators.signinButton);
		boolean isChecked = LoginPageLocators.rememberme.isSelected();
		AssertionHandler.verifyTrue(isChecked, "Remember Me check box is not checked");
		TestNGCustomReporter.log(logger, "Remember Me check box is checked");
	}

	public void verifyRemembermeUnCheck() {
		elementHandler.clickElement(LoginPageLocators.rememberme, LoginPageLocators.signinButton);
		boolean isChecked = LoginPageLocators.rememberme.isSelected();
		AssertionHandler.verifyFalse(isChecked, "Remember Me check box is checked");
		TestNGCustomReporter.log(logger, "Remember Me check box is unchecked");
	}

	public void clickForgottenPassword() {
		elementHandler.clickElement(LoginPageLocators.forgottenyourpasswordlink);
		TestNGCustomReporter.log(logger, "Clicked on Forgotten Password Link");
	}

	public void navigatedtoForgottenPasswordPage() {
		// String parentWindow = windowHandler.getParentWindow();
		windowHandler.switchToLatestWindow(PasswordAssistancePageLocators.navigatedtoPasswordAssistancepage);
		// driver.switchTo().window("windowName");
		AssertionHandler.verifyTrue(
				elementHandler.isElementDisplayed(PasswordAssistancePageLocators.navigatedtoPasswordAssistancepage),
				"Not Navigated to Forgotten Password Page");
		TestNGCustomReporter.log(logger, "Navigated to Forgotten Password Page");
		//windowHandler.switchToParentWindow(parentWindow, waitForElement);
	}

	/***
	 * Methods id used to login to application
	 * 
	 * @param username
	 *            Username of the application
	 * @param password
	 *            Password of the application
	 */
	public void loginToApplication(String username, String password) {
		String un = ExcelUtils.getDataByColumnName("MYTRLogin", username);
		String pwd = ExcelUtils.getDataByColumnName("MYTRLogin", password);

		// elementHandler.clickElement(LoginPageLocators.loginButton,
		// LoginPageLocators.signinButton);
		elementHandler.writeText(LoginPageLocators.usernameTxtbox, un);
		elementHandler.writeText(LoginPageLocators.passwordTxtBox, pwd);

	}

	/***
	 * Method is used to verify the Login functionality
	 */
	public void verifyLogin() {
		String expectedErrTxt = ExcelUtils.getDataByColumnName("MYTRLogin", "Error_Message");
		elementHandler.clickElement(LoginPageLocators.signinButton);

		if (LoginPageLocators.errormsg.size() > 0) {
			String errTxt = elementHandler.getText(LoginPageLocators.errormsg.get(0));
			AssertionHandler.verifyEquals(errTxt, expectedErrTxt, "Error message is not matching");
			TestNGCustomReporter.log(logger, "Error message is  displayed");
		} else if (LoginPageLocators.logout.size() > 0) {
			AssertionHandler.verifyTrue(elementHandler.isElementDisplayed(LoginPageLocators.logout.get(0)),
					"User not logged in");
			TestNGCustomReporter.log(logger, "User Logged in Successfully");
		}
	}

	public void navigatetoHomePage() {
		AssertionHandler.verifyTrue(elementHandler.isElementDisplayed(LoginPageLocators.logout.get(0)),
				"User not navigated to Homepage");
		TestNGCustomReporter.log(logger, "User Navigated to Homepage");

	}

	public void verifylogout() {
		elementHandler.clickElement(LoginPageLocators.logout.get(0), LoginPageLocators.loggedoutmsg);
		AssertionHandler.verifyTrue(elementHandler.isElementDisplayed(LoginPageLocators.loggedoutmsg),
				"User not loggedout");
		TestNGCustomReporter.log(logger, "User logged out successfully");
	}

	public void clickonDiscoverTR() {
		elementHandler.clickElement(LoginPageLocators.discoverTR, LoginPageLocators.discoverTRmsgContent);
		TestNGCustomReporter.log(logger, "Clicked on Discover Thomson Reuters");
	}

	public void verifyContentofDiscoverTR() 
	{
		String actualTRContent = elementHandler.getText(LoginPageLocators.discoverTRmsgContent);
		String expectedTRContent = ExcelUtils.getDataByColumnName("MYTRLogin", "TrContent");
		AssertionHandler.verifyEquals(actualTRContent, expectedTRContent, "Discover TR Content is not matching");
		TestNGCustomReporter.log(logger, "DisCover TR Content is displayed  and matched");
		/*
		AssertionHandler.verifyTrue(elementHandler.isElementDisplayed(LoginPageLocators.discoverTRmsgContent),
				"Message is not displayed about TR ");
		TestNGCustomReporter.log(logger, "Message displayed  about TR successfully");*/

	}

	public void verifyPrePopulated() {
		AssertionHandler.verifyTrue(elementHandler.isElementDisplayed(LoginPageLocators.usernamePrepopulated),
				"Username is  not prepoulated");
		TestNGCustomReporter.log(logger, "Username is prepopulated");
		AssertionHandler.verifyTrue(elementHandler.isElementDisplayed(LoginPageLocators.usernamePrepopulated),
				"Password is not prepoulated");
		TestNGCustomReporter.log(logger, "Password is prepopulated");
	}

	public void clickSupportandTraining() {
		elementHandler.clickElement(LoginPageLocators.supportandtrainingbutton);
		TestNGCustomReporter.log(logger, "clicked on support and training button");
	}

	public void navigatetoSupportandTraining() {

		AssertionHandler.verifyTrue(
				elementHandler.isElementDisplayed(LoginPageLocators.navigatetoSupportandTrainingPage),
				"Not navigated to support and training page ");
		TestNGCustomReporter.log(logger, "navigated to support and training page");

	}

	public void verifyMYTRTitlePage() {
		String actualtitle = elementHandler.getText(LoginPageLocators.myTRTitlePage);
		String expectedtitle = ExcelUtils.getDataByColumnName("MYTRLogin", "Title");
		AssertionHandler.verifyEquals(actualtitle, expectedtitle, "Title is not matching");
		TestNGCustomReporter.log(logger, "Title is  displayed and matched");
	}

	public void verifyPearlAAALoginBox() {
		AssertionHandler.verifyTrue(elementHandler.isElementDisplayed(LoginPageLocators.pearlAAALoginbox),
				"Pearl AAA login box is not available");
		TestNGCustomReporter.log(logger, "Pearl AAA Login box is displayed");

	}

}

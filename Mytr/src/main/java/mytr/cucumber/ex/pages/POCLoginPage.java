package mytr.cucumber.ex.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.framework.asserts.AssertionHandler;
import com.framework.config.PropertiesRepository;
import com.framework.reports.TestNGCustomReporter;
import com.framework.utils.ExcelUtils;

import mytr.cucumber.ex.obj.repository.POCLoginPageLocators;

public class POCLoginPage extends BasePage {

	private static Logger logger = LogManager.getLogger(POCLoginPage.class);

	public POCLoginPage(WebDriver webDriver) {
		super(webDriver);
	}

	public void login() {

	//	String username = ExcelUtils.getDataByColumnName("Login", "QAUserName");
		//String password = ExcelUtils.getDataByColumnName("Login", "QAPassword");
		driver.get(PropertiesRepository.getString("test.crxdelite.url"));
		elementHandler.clickElement(POCLoginPageLocators.anonymousButton);
		TestNGCustomReporter.log(logger, "Clicked on Anonymous Button");
		elementHandler.setWebDriverWait(POCLoginPageLocators.usernameTxtbox);
		handleAlert();
		
	}

	public void handleAlert() {
		String username = ExcelUtils.getDataByColumnName("Login", "QAUserName");
		String password = ExcelUtils.getDataByColumnName("Login", "QAPassword");
		
		elementHandler.writeText(POCLoginPageLocators.usernameTxtbox, username);
		TestNGCustomReporter.log(logger, "Entered Username in the username field ");

		elementHandler.writeText(POCLoginPageLocators.passwordTxtBox, password);
		TestNGCustomReporter.log(logger, "Entered Password in the Password field");

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", POCLoginPageLocators.okButton.get(1));
		TestNGCustomReporter.log(logger, "Clicked On Ok Button");
		elementHandler.setWebDriverWait(POCLoginPageLocators.propertyButton);

	}

	public void navigate() {
		driver.get(PropertiesRepository.getString("test.trredesign.base.url"));
		TestNGCustomReporter.log(logger, "Navigated to Redesign BasePage");
	}

	public void casesubmission() {
		elementHandler.selectByValue(POCLoginPageLocators.productDropdown, "13D SP OwnerShip Feed",
				POCLoginPageLocators.helpTxtbox);
		TestNGCustomReporter.log(logger, "Selected Product Dropdown");
		elementHandler.writeText(POCLoginPageLocators.helpTxtbox, "help", POCLoginPageLocators.affectDropdown);
		TestNGCustomReporter.log(logger, "Entered Text in help text box");
		elementHandler.selectByValue(POCLoginPageLocators.affectDropdown, "singleUser");
		TestNGCustomReporter.log(logger, "Selected value from affect dropdown");
		elementHandler.clickElement(POCLoginPageLocators.submitbutton);
		TestNGCustomReporter.log(logger, "Clicked on email");
		elementHandler.clickElement(POCLoginPageLocators.submitbutton, POCLoginPageLocators.casestatus);
		TestNGCustomReporter.log(logger, "Clicked on Submit button");

		AssertionHandler.verifyTrue(elementHandler.isElementDisplayed(POCLoginPageLocators.casestatus),
				"Case has  not been successfully Submitted");
		TestNGCustomReporter.log(logger, "Case has been Submitted successfully");

	}

}

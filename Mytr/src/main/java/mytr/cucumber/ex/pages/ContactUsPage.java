package mytr.cucumber.ex.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.framework.asserts.AssertionHandler;
import com.framework.config.PropertiesRepository;
import com.framework.reports.TestNGCustomReporter;
import com.framework.utils.ExcelUtils;

import mytr.cucumber.ex.obj.repository.ContactUsPageLocators;
import mytr.cucumber.ex.obj.repository.LoginPageLocators;
import mytr.cucumber.ex.obj.repository.MailPageLocators;
import mytr.cucumber.ex.obj.repository.POCLoginPageLocators;

public class ContactUsPage extends BasePage {
	private static Logger logger = LogManager.getLogger(ContactUsPage.class);


	
	
	
	public ContactUsPage(WebDriver webDriver) {
		super(webDriver);
	}

	/***
	 * 
	 * Contact Us
	 *
	 */
	
	public void contactUSPage()
	
	{
		elementHandler.clickElement(LoginPageLocators.contactusbutton, ContactUsPageLocators.websitesupport);
		TestNGCustomReporter.log(logger, "clicked on contact us button");
		
		
	}
	public void navigatetocontactUSPage()
	{
		AssertionHandler.verifyTrue(elementHandler.isElementDisplayed(ContactUsPageLocators.websitesupport),
				"Navigation to Contact Us Page failed");
		TestNGCustomReporter.log(logger, "Navigation to Contact Us Page is Successfull");

	}
	
	public void navigatetoWebsiteSupportPage ()
	{
		elementHandler.clickElement(ContactUsPageLocators.websitesupport, ContactUsPageLocators.notworkingasexpected);
		AssertionHandler.verifyTrue(elementHandler.isElementDisplayed(ContactUsPageLocators.notworkingasexpected),
				"Navigation to Website Support  Page is failed");
		TestNGCustomReporter.log(logger, "Navigation to Website Support  Page is Successfull");
		
	}
	public void verifyUnabletologinLink()
	{
		AssertionHandler.verifyTrue(elementHandler.isElementDisplayed(ContactUsPageLocators.unabletologin),
				"Link is not available");
		TestNGCustomReporter.log(logger, "Link is available");
	}
	
	public void clickUnabletoLoginLink()
	{
		elementHandler.clickElement(ContactUsPageLocators.unabletologin, ContactUsPageLocators.submitbutton);
		
		TestNGCustomReporter.log(logger, "clicked on unable to login link");
	}
	
	
	
	public void navigatetounabletologinPage()
	{
		AssertionHandler.verifyTrue(elementHandler.isElementDisplayed(ContactUsPageLocators.submitbutton),
				"Navigation to unable to loginPage is failed");
		TestNGCustomReporter.log(logger, "Navigation to unable to login Page is Successfull");
	}
	
	
	
	public void validDetailsSubmission(String name,String email,String country,String help,String affect)
	{
		String un1 = ExcelUtils.getDataByColumnName("Contact US", name);
		String mail = ExcelUtils.getDataByColumnName("Contact US", email);
		String con = ExcelUtils.getDataByColumnName("Contact US", country);
		String hlp = ExcelUtils.getDataByColumnName("Contact US", help);
		String aff = ExcelUtils.getDataByColumnName("Contact US", affect);
		
		elementHandler.writeText(ContactUsPageLocators.nametxtbox, un1);
		TestNGCustomReporter.log(logger, "Name entered successfully");
		elementHandler.writeText(ContactUsPageLocators.email, mail);
		TestNGCustomReporter.log(logger, "email entered successfully");
		elementHandler.writeText(ContactUsPageLocators.country, con);
		TestNGCustomReporter.log(logger, "country entered successfully");
		elementHandler.writeText(ContactUsPageLocators.helpyou, hlp);
		TestNGCustomReporter.log(logger, "Description entered successfully");
		
		elementHandler.selectByVisibleText(ContactUsPageLocators.affectdrpdown, aff);
		TestNGCustomReporter.log(logger, "Dropdown selected successfully");
		
		elementHandler.clickElement(ContactUsPageLocators.trackcasesradiobutton, ContactUsPageLocators.submitbutton );
		
	}
		/*if(ContactUsPageLocators.trackcasesradiobutton.get(0).getText().equalsIgnoreCase("Email")) {
			elementHandler.clickElement(ContactUsPageLocators.trackcasesradiobutton.get(0));
		}*/
		
	public void clickSubmit()
	{
		elementHandler.clickElement(ContactUsPageLocators.submitbutton,ContactUsPageLocators.caseid);
		TestNGCustomReporter.log(logger, "clicked on submit Button");
		

	}
	
	public void verifyCaseId()
	{
		AssertionHandler.verifyTrue(elementHandler.isElementDisplayed(ContactUsPageLocators.caseid),
				"Case id is not generated.");
		TestNGCustomReporter.log(logger, "Case id generated  Successfully");
	}
	
	
	public void invalidCaseSubmission()
	{
		elementHandler.clickElement(ContactUsPageLocators.submitbutton,ContactUsPageLocators.caseid);
		TestNGCustomReporter.log(logger, "clicked on submit Button");
	}
	public void verifyerrormsg()
	{
		AssertionHandler.verifyTrue(elementHandler.isElementDisplayed(ContactUsPageLocators.errormsg1),
				"Error message is not displayed");
		TestNGCustomReporter.log(logger, "Error message is displayed to enter the mandatory fields");
	}
	
	/*public void verifywithInvalidMailandCountry(String Invalidmail ,String InvalidCountry )
	{
		String invalidmail = ExcelUtils.getDataByColumnName("Contact US",Invalidmail);
		String invalidcon = ExcelUtils.getDataByColumnName("Contact US", InvalidCountry);
		
		
	}*/
	}
	

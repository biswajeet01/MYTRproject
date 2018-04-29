package mytr.cucumber.ex.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.framework.asserts.AssertionHandler;
import com.framework.config.PropertiesRepository;
import com.framework.reports.TestNGCustomReporter;
import com.framework.utils.ExcelUtils;

import mytr.cucumber.ex.obj.repository.ContactUsPageLocators;
import mytr.cucumber.ex.obj.repository.MailPageLocators;

public class MailPage extends BasePage {
	private static Logger logger = LogManager.getLogger(ContactUsPage.class);

	public MailPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	
	//need to verify both valid and invalid mail id
	public void mailLogin(String mailid)
	{
		String mid = ExcelUtils.getDataByColumnName("Contact US", mailid);
		driver.get(PropertiesRepository.getString("test.mail.url"));
		AssertionHandler.verifyTrue(elementHandler.isElementDisplayed(MailPageLocators.gobutton),
				"Failed Launching MailPage");
		TestNGCustomReporter.log(logger, "Launched MailPage Successfully");
		
		
		elementHandler.writeText(ContactUsPageLocators.nametxtbox,mid );
		TestNGCustomReporter.log(logger, "Mail Id entered successfully");
	    elementHandler.clickElement(MailPageLocators.gobutton);
		TestNGCustomReporter.log(logger, "Clicked on go button");
		AssertionHandler.verifyTrue(elementHandler.isElementDisplayed(MailPageLocators.inbox),
				"Inbox is not displayed");
		
	}
	
	public void mailNotificationVerification()
	{
		elementHandler.clickElement(MailPageLocators.notificationMailforUsername,MailPageLocators.mailcontent);
		AssertionHandler.verifyTrue(elementHandler.isElementDisplayed(MailPageLocators.mailcontent),
				"Userdetails not displayed");
		TestNGCustomReporter.log(logger, "UserDetails displayed successfully");
	}
	
	public void verifyNotificationMailForPwdReset()
	
	{
		String actualdomain = elementHandler.getText(MailPageLocators.mailFromTrDomain);
		String expecteddomain = ExcelUtils.getDataByColumnName("MailPageContent", "domain");
		AssertionHandler.verifyEquals(actualdomain, expecteddomain, "Domain name is not matching");
		TestNGCustomReporter.log(logger, "Domain name is displayed  and matched");
		
		/*AssertionHandler.verifyTrue(elementHandler.isElementDisplayed(MailPageLocators.mailFromTrDomain),"Not received mail from TR Domain");
		TestNGCustomReporter.log(logger, "Received mail from TR Domain");*/
		
		elementHandler.clickElement(MailPageLocators.notificationMailforpasswordreset,MailPageLocators.mailHeader);
		TestNGCustomReporter.log(logger, "Clicked on Password Reset notification mail  ");
	}
	public void verifyEmailTemplate()
	{
		
		String actualHeader = elementHandler.getText(MailPageLocators.mailHeader);
		String expectedHeader = ExcelUtils.getDataByColumnName("MailPageContent", "mailheader");
		AssertionHandler.verifyEquals(actualHeader, expectedHeader, "Header TR Password Assistance is not matching");
		TestNGCustomReporter.log(logger, "Header TR Password Assistance is displayed  and matched");
		
		String actualHeaderFinance = elementHandler.getText(MailPageLocators.mailHeader);
		String expectedHeaderFinance = ExcelUtils.getDataByColumnName("MailPageContent", "finance");
		AssertionHandler.verifyEquals(actualHeaderFinance, expectedHeaderFinance, "Header Finance is not matching");
		TestNGCustomReporter.log(logger, "Header  Finance is displayed  and matched");
		
		
		
		AssertionHandler.verifyTrue(elementHandler.isElementDisplayed(MailPageLocators.dateOfReceipt),
				"Date of Receipt is not displayed");
		TestNGCustomReporter.log(logger, "Date of Receipt is  displayed successfully");
		
		System.out.println(MailPageLocators.dateOfReceipt.getText());
		
		String actualFooter = elementHandler.getText(MailPageLocators.mailFooter);
		String expectedfooter = ExcelUtils.getDataByColumnName("MailPageContent", "footer");
		AssertionHandler.verifyEquals(actualFooter ,expectedfooter, "Footer is not   matching");
		TestNGCustomReporter.log(logger, "Footer is displayed  and matched");
		
		
		
		
		
		
	}
	
	public void switchtoPasswordAssistanceFrame()
	{
		windowHandler.switchToFrame(MailPageLocators.passwordAssistanceFrame);
		TestNGCustomReporter.log(logger, "Switched to iframe Successfully");
		
		String actualToaddress = elementHandler.getText(MailPageLocators.toAddress);
		String expectedToaddress = ExcelUtils.getDataByColumnName("MailPageContent", "address");
		AssertionHandler.verifyEquals(actualToaddress ,expectedToaddress, "To Address is  not   matching");
		TestNGCustomReporter.log(logger, "To Address is displayed  and matched");
		
		AssertionHandler.verifyTrue(elementHandler.isElementDisplayed(MailPageLocators.actandDeactTime),
				"Activation and Deactivation Time is not displayed");
		TestNGCustomReporter.log(logger, "Activation and Deactivation Time is displayed successfully");
		
		String actualContactUs = elementHandler.getText(MailPageLocators.iframeContactus);
		String expectedContactUs = ExcelUtils.getDataByColumnName("MailPageContent", "contactus");
		AssertionHandler.verifyEquals(actualContactUs ,expectedContactUs, "contact us is  not   matching");
		TestNGCustomReporter.log(logger, "Contact Us is displayed  and matched");		

		
		AssertionHandler.verifyTrue(elementHandler.isElementDisplayed(MailPageLocators.resetPasswordLink),
				"Reset password link is not displayed");
		TestNGCustomReporter.log(logger, "Reset password link is displayed successfully");
		
		elementHandler.clickElement(MailPageLocators.resetPasswordLink);
			TestNGCustomReporter.log(logger, "Clicked on Reset password link.");
		
		
}
	
	
	
}

package mytr.cucumber.ex.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.framework.asserts.AssertionHandler;
import com.framework.config.PropertiesRepository;
import com.framework.reports.TestNGCustomReporter;
import com.framework.utils.ExcelUtils;

import mytr.cucumber.ex.obj.repository.LoginPageLocators;
import mytr.cucumber.ex.obj.repository.PasswordAssistancePageLocators;

public class PasswordAssistancePage extends BasePage {

	private static Logger logger = LogManager.getLogger(PasswordAssistancePage.class);
	public PasswordAssistancePage(WebDriver webDriver) {
		super(webDriver);
		}

	public void verifyPasswordAssistancePageContent()
	{
		String actuallogo = elementHandler.getText(PasswordAssistancePageLocators.wordwithMyTRLogo);
		String expectedlogo = ExcelUtils.getDataByColumnName("PasswordAssistance", "logo");
		AssertionHandler.verifyEquals(actuallogo, expectedlogo, " Logo with wording is not matching");
		TestNGCustomReporter.log(logger, "Logo with wording is displayed and matched");
		
		String actualpwdcontent = elementHandler.getText(PasswordAssistancePageLocators.passwordAssistanceContent);
		String expectedpwdcontent = ExcelUtils.getDataByColumnName("PasswordAssistance", "pwdassitcontent");
		AssertionHandler.verifyEquals(actualpwdcontent, expectedpwdcontent, "Password Assistance Content is not matching");
		TestNGCustomReporter.log(logger, "Password Assistance Content is displayed and matched");

		String actualforgpwdcontent = elementHandler.getText(PasswordAssistancePageLocators.forgottenPasswordContent);
		String expectedforgpwdcontent = ExcelUtils.getDataByColumnName("PasswordAssistance", "expectedforgpwdcontent");
		AssertionHandler.verifyEquals(actualforgpwdcontent, expectedforgpwdcontent, "Forgot Password Content is not matching");
		TestNGCustomReporter.log(logger, "Forgot Password Content is displayed and matched");

		String actualuser = elementHandler.getText(PasswordAssistancePageLocators.userid);
		String expecteduser = ExcelUtils.getDataByColumnName("PasswordAssistance", "user");	
		AssertionHandler.verifyEquals(actualuser, expecteduser, "user is not matching");
		TestNGCustomReporter.log(logger, "User is  displayed and matched");
		
		AssertionHandler.verifyTrue(elementHandler.isElementDisplayed(PasswordAssistancePageLocators.okButton), "Ok Button is not displayed");
		TestNGCustomReporter.log(logger, "MyTR word with logo is displayed");
		AssertionHandler.verifyTrue(elementHandler.isElementDisplayed(PasswordAssistancePageLocators.cancelButton), "Cancel Button  is not displayed");
		TestNGCustomReporter.log(logger, "Cancel Button is displayed");

		
	}

	public void verifyMail(String mailid,String errormsgmail )
	{	
		elementHandler.writeText(PasswordAssistancePageLocators.useridtextbox,mailid );
		TestNGCustomReporter.log(logger,"User id entered.");
		elementHandler.clickElement(PasswordAssistancePageLocators.okButton);
		TestNGCustomReporter.log(logger, "Clicked on OK Button.");
		
		if (PasswordAssistancePageLocators.errorMsgInvalidMail.size() > 0)
		{
			String expectederror=ExcelUtils.getDataByColumnName("MYTRLogin", errormsgmail);
			String actualerror = elementHandler.getText(PasswordAssistancePageLocators.errorMsgInvalidMail.get(0));
			AssertionHandler.verifyEquals(actualerror, expectederror, "Error message is not matching");
			TestNGCustomReporter.log(logger, "Error message is  displayed");
			
		} else if (PasswordAssistancePageLocators.errorMsgInvalidMail.size() > 0) {
			AssertionHandler.verifyTrue(elementHandler.isElementDisplayed(PasswordAssistancePageLocators.passwordAssistanceHeader), "Not Navigated to password assistance page.");
			TestNGCustomReporter.log(logger, "Navigated to Password Assistance Page");
		}
		

	}
	public  void verifyEmailSentPageContent()
	{
		String actualforgpwdcontent = elementHandler.getText(PasswordAssistancePageLocators.passwordAssistanceHeader);
		String expectedforgpwdcontent = ExcelUtils.getDataByColumnName("PasswordAssistance", "header");
		AssertionHandler.verifyEquals(actualforgpwdcontent, expectedforgpwdcontent, "Forgot Password Content is not matching");
		TestNGCustomReporter.log(logger, "Password Assistance Header is displayed  and matched");
		
		String actualemailcontent = elementHandler.getText(PasswordAssistancePageLocators.emailsentContent);
		String expectedemailcontent = ExcelUtils.getDataByColumnName("PasswordAssistance", "emailsent");
		AssertionHandler.verifyEquals(actualemailcontent, expectedemailcontent, "Forgot Password Content is not matching");
		TestNGCustomReporter.log(logger, "Password Assistance Header is displayed  and matched");
		
		AssertionHandler.verifyTrue(elementHandler.isElementDisplayed(PasswordAssistancePageLocators.contactusContentinsidebody), "Contact Us link is displayed inside email body content");
		TestNGCustomReporter.log(logger, "Contact Us link is displayed inside email body content");	
		
	}
	
	public void resetPassword(String ChangeNewPassword , String ConfirmPwd)
	
	{
		String ChangeNewPwd = ExcelUtils.getDataByColumnName("MYTRLogin", ChangeNewPassword);
		String ConfirmPassword = ExcelUtils.getDataByColumnName("MYTRLogin", ConfirmPwd);
		windowHandler.switchToLatestWindow(PasswordAssistancePageLocators.changeNewPwd);
		AssertionHandler.verifyTrue(elementHandler.isElementDisplayed(PasswordAssistancePageLocators.changePwdPageOkButton),"Not Navigated to change password page.");
		TestNGCustomReporter.log(logger, "Change password page displayed successfully.");
		
		elementHandler.writeText(PasswordAssistancePageLocators.changeNewPwd, ChangeNewPwd);
		TestNGCustomReporter.log(logger,"Entered New Password");
		elementHandler.writeText(PasswordAssistancePageLocators.changeNewPwd, ConfirmPassword);
		TestNGCustomReporter.log(logger,"Entered confirm Password");
		
		elementHandler.clickElement(PasswordAssistancePageLocators.changePwdPageOkButton,PasswordAssistancePageLocators.passwordCreated);
		TestNGCustomReporter.log(logger,"Clicked on Ok Button");
		
		AssertionHandler.verifyTrue(elementHandler.isElementDisplayed(PasswordAssistancePageLocators.passwordCreated), "Password not reseted correctly.");
		TestNGCustomReporter.log(logger,"Password Reset is successfully completed.");

	}
	public void verifySigninAfterResetPassword(String username, String ChangeNewPassword)
	{
		String un = ExcelUtils.getDataByColumnName("MYTRLogin", username);
		String NewPwd = ExcelUtils.getDataByColumnName("MYTRLogin", ChangeNewPassword);
		driver.get(PropertiesRepository.getString("test.application.url"));

		
		elementHandler.writeText(LoginPageLocators.usernameTxtbox, un);
		elementHandler.writeText(LoginPageLocators.passwordTxtBox, NewPwd);
				elementHandler.clickElement(LoginPageLocators.signinButton);

			AssertionHandler.verifyTrue(elementHandler.isElementDisplayed(LoginPageLocators.logout.get(0)),
					"User not logged in");
			TestNGCustomReporter.log(logger, "User Logged in Successfully");
		}
		
	}
	
		
	


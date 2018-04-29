package mytr.cucumber.ex.obj.repository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PasswordAssistancePageLocators
{
	@FindBy(xpath = "")
	public static WebElement navigatedtoPasswordAssistancepage;
	
	@FindBy(xpath = "")
	public static WebElement wordwithMyTRLogo;
	
	@FindBy(xpath = "")
	public static WebElement passwordAssistanceContent;
	
	@FindBy(xpath = "")
	public static WebElement forgottenPasswordContent ;
	
	@FindBy(xpath = "")
	public static WebElement userid;

	
	@FindBy(xpath = "")
	public static WebElement useridtextbox;

	@FindBy(xpath = "")
	public static WebElement okButton;
	
	@FindBy(xpath = "")
	public static WebElement cancelButton;
	
	@FindBy(xpath = "")
	public static List<WebElement> errorMsgInvalidMail;
	
	
	
	/***
	 * Password Assistance Page after Email Sent
	 */

	@FindBy(xpath = "")
	public static WebElement passwordAssistanceHeader;
	
	@FindBy(xpath = "")
	public static WebElement emailsentContent;
	
	@FindBy(xpath = "")
	public static WebElement contactusContentinsidebody;
	
	/***
	 * Password Reset page 
	 */
	
@FindBy(xpath="")
public static WebElement changeNewPwd;

@FindBy(xpath="")
public static WebElement resetPwd;

@FindBy(xpath="")
public static WebElement confirmResetPwd;

@FindBy(xpath="")
public static WebElement changePwdPageOkButton;

@FindBy(xpath="")
public static WebElement passwordCreated;






	
	

}

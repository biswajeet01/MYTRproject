package mytr.cucumber.ex.obj.repository;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class POCLoginPageLocators {

	/***
	 * Login page objects
	 *
	 */  //   //button[@id='ext-gen194']
	@FindBy(xpath ="//table[@id='loginbutton']/tbody/tr[2]/td[2]/em/button")
	public static WebElement anonymousButton;
	
	@FindBy(xpath = "//label[text()='Name:']/..//input")
	public static WebElement usernameTxtbox;
	
	@FindBy(xpath = "//label[text()='Password:']/..//input")
	public static WebElement passwordTxtBox;

	@FindBy(xpath = "//button[text()='OK']")
	public static List<WebElement> okButton;
	
	
	@FindBy(xpath = "//*[@id='tools__properties']/a[2]/em/span/span")
	public static WebElement propertyButton;
	/***
	 * Redesign Page objects
	 */
	@FindBy(id ="field-business-type")
	public static WebElement productDropdown;
	
	@FindBy(id = "field-first-name-field")
	public static WebElement helpTxtbox;
	
	@FindBy(id = "field-role")
	public static WebElement affectDropdown;

	@FindBy(id = "field-shipping-method-ground")
	public static WebElement myaccountradioButton;
	
	@FindBy(id="case-submit")
    public static WebElement submitbutton;
	
	@FindBy(id="case_status")
    public static WebElement casestatus;
	

}

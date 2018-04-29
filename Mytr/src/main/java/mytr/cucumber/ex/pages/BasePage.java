package mytr.cucumber.ex.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.framework.config.PropertiesRepository;
import com.framework.handlers.ActionHandler;
import com.framework.handlers.ElementHandler;
import com.framework.handlers.PopUpHandler;
import com.framework.handlers.WindowHandler;
import com.framework.utils.ExcelUtils;

import mytr.cucumber.ex.obj.repository.BasePageLocators;
import mytr.cucumber.ex.obj.repository.LoginPageLocators;
import mytr.cucumber.ex.obj.repository.POCLoginPageLocators;

public class BasePage {

	protected ElementHandler elementHandler;
	protected ActionHandler actionHandler;
	protected WindowHandler windowHandler;
	protected PopUpHandler popUpHandler;
	WebDriver driver = null;

	public BasePage(WebDriver webDriver) {
		PageFactory.initElements(webDriver, BasePageLocators.class);
		PageFactory.initElements(webDriver, LoginPageLocators.class);
		PageFactory.initElements(webDriver, POCLoginPageLocators.class);
		this.driver = webDriver;
		elementHandler = new ElementHandler(driver);
		actionHandler = new ActionHandler(driver);
		windowHandler = new WindowHandler(driver);
		popUpHandler = new PopUpHandler(driver);
		ExcelUtils.setExcel(System.getProperty("user.dir") + PropertiesRepository.getString("testdata.excel.file"));
	}

	/***
	 * Login
	 */

	public void launchPearlAAAURL() {
		driver.get(PropertiesRepository.getString("test.application.url"));
	}

	/***
	 * Method is used to launch Static Url
	 */
	public void launchStaticURL() {
		driver.get(PropertiesRepository.getString("test.static.url"));
	}

	/***
	 * Method is used to launch Mail Url
	 */

	public void launchMailUrl() {
		driver.get(PropertiesRepository.getString("test.mail.url"));
	}
}

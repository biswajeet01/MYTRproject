package mytr.cucmber.ex.stepdefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.framework.config.GlobalProperties;
import com.framework.config.PropertiesRepository;
import com.framework.driverfactory.DriverFactory;
import com.framework.reports.CucumberReports;
import com.framework.utils.ExcelUtils;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import jdk.nashorn.internal.runtime.GlobalConstants;
import mytr.cucumber.ex.constants.MYTRConstants;

public class CucumberSetup {
	protected static WebDriver driver = null;
	private static Logger logger = LogManager.getLogger(CucumberSetup.class);
	public List<String> CucumberOpts = new ArrayList<String>();

	/*static {
		try {
			ExcelUtils.setExcel(System.getProperty("user.dir") + PropertiesRepository.getString("testdata.excel.file"));

		} catch (Exception e) {
			logger.error("Unable to load properties files", e);
		}
	}*/

	public static String browserType;

	@Before
	public void setUp() {
		browserType = GlobalProperties.BrowserType;
		driver = DriverFactory.getInstance(browserType).getDriver();
		manageDriver(driver);
		CucumberReports.setDriver(driver);
	}

	@After
	public void tearDown(Scenario scenario) throws IOException {
		// if (scenario.isFailed()) {
		File screenshot = takeScreenShots("screenshot");
		InputStream screenshotStream = new FileInputStream(screenshot);
		scenario.embed(IOUtils.toByteArray(screenshotStream), "image/jpeg");
		// }
		if (driver != null) {
			DriverFactory.getInstance(browserType).removeDriver();
		}
	}

	private File takeScreenShots(String picture) throws IOException {
		File temp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(temp, new File(MYTRConstants.ScreenShotPath + File.separator + picture));
		return temp;
	}

	public static WebDriver getDriver() {
		return driver;
	}

	private void manageDriver(WebDriver webDriver) {
		webDriver.manage().window().maximize();
		webDriver.manage().deleteAllCookies();
		webDriver.manage().timeouts().implicitlyWait(PropertiesRepository.getInt("global.implicit.wait"),
				TimeUnit.SECONDS);
	}

}

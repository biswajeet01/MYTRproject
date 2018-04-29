package mytr.cucumber.ex.testrunner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.framework.config.GlobalProperties;
import com.framework.config.PropertiesRepository;
import com.framework.cucumber.helper.TestNGRunnerHelper;
import com.framework.reports.CucumberReports;

import mytr.cucmber.ex.stepdefinition.CucumberSetup;
import mytr.cucumber.ex.constants.MYTRConstants;
import mytr.cucumber.ex.helper.Data;

public class TestNGTestRunner {
	private static Logger logger = LogManager.getLogger(CucumberSetup.class);
	static {
		try {
			PropertiesRepository.loadAllProperties();
		} catch (Exception e) {
			logger.error("Unable to load properties files", e);
		}
	}

	@Parameters({"browser", "suitename"})
	@BeforeSuite
	public void setUp(String browserType, String suiteName) {
		GlobalProperties.BrowserType = browserType;
		GlobalProperties.SuiteName = suiteName;
	}

	@Test(dataProvider = MYTRConstants.dataProviderMethod, dataProviderClass = Data.class)
	public void runFeatures(String feature, String tag, String status) {
		if (feature != null && MYTRConstants.executionStatus.equalsIgnoreCase(status)) {
			TestNGRunnerHelper.runTestNG(feature, tag);
		}
	}

	@AfterSuite
	public void generateReport() {
		CucumberReports.generateCucumberReport(GlobalProperties.SuiteName);
	}


}

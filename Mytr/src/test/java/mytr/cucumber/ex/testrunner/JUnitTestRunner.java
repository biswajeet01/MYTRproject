package mytr.cucumber.ex.testrunner;

import java.io.File;

import org.junit.AfterClass;

import com.cucumber.listener.Reporter;

/*@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/features" }, glue = { "com.framework.cucumber.setup",
		"cucumber.example.stepdefinitions" }, plugin = {
				"com.cucumber.listener.ExtentCucumberFormatter:output/report.html" })*/

public class JUnitTestRunner {
	@AfterClass
	public static void setup() {
		Reporter.loadXMLConfig(new File("src/main/resources/ExtentReportConfig.xml"));
		Reporter.setSystemInfo("user", System.getProperty("user.name"));
		Reporter.setSystemInfo("os", "Mac OSX");
		Reporter.setTestRunnerOutput("Sample test runner output message");
	}
}

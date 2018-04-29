package mytr.cucumber.ex.testrunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(strict = false, features = { "src/test/resources/features" }, glue = {
		"cucumber.example.stepdefinitions" }, plugin = { "pretty", "json:target/cucumber.json" })
public class TestNGRunner extends AbstractTestNGCucumberTests {

}

package mytr.cucumber.ex.testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(strict = false, features = { "src/test/resources/features" }, glue = {
		"cucumber.example.stepdefinitions" }, plugin = { "pretty", "json:target/cucumber.json" })
public class SmokeBDDTest {

}

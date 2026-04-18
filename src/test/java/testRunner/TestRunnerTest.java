package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={"classpath:features"},
		glue={"stepDefinitions"},
		plugin= {"pretty","html:reports/myReport.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		tags="@MyFirstTag",
		dryRun=false,
		monochrome=true,
		publish = true
		)
public class TestRunnerTest {

}

//features={".//features/LoginTest.feature"},
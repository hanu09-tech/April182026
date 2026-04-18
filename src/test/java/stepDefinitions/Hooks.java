package stepDefinitions;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.AfterStep;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	WebDriver driver;
	Properties p;
	@Before
	public void setup() throws IOException {
		driver=BaseClass.initializeBrowser();
		p=BaseClass.getProperties();
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
	}
	@After
	public void tearDown(Scenario scenario) {
		driver.quit();
	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario) {
		if(scenario.isFailed()) {
			TakesScreenshot screenshot=(TakesScreenshot)driver;
			byte[] scr=screenshot.getScreenshotAs(OutputType.BYTES);
			scenario.attach(scr, "image/png", scenario.getName());
		}
		
	}

}

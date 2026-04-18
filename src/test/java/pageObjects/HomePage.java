package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends BasePage{
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="(//a[contains(.,'Practice')])[1]")
	WebElement link_practice_xpath;
	
	@FindBy(xpath="//a[contains(@href,\"practice-test-login\")]")
	WebElement link_testLogin;
	
	public void clickOnPracticeLink() {
		
		link_practice_xpath.click();
	}
	public void clickOnTestLoginLink() {
		link_testLogin.click();
	}
	

}

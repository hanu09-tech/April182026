package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(id="username")
	WebElement userName_txtbox;
	
	@FindBy(id="password")
	WebElement password_txtbox;
	
	@FindBy(id="submit")
	WebElement submit_btn;
	
	
public void enterUserName(String userName) {
	userName_txtbox.sendKeys(userName);
}
	
public void enterPassword(String password) {
	password_txtbox.sendKeys(password);
}
 public void submit() {
	 submit_btn.click();
 }
public String getTitle() {
	
	return driver.getTitle();
	
}
}

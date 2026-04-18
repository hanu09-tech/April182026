package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.cdimascio.dotenv.Dotenv;
import junit.framework.Assert;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class LoginSteps {
	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	
	@Given("user launches application")
	public void user_launches_application(){
	    // Write code here that turns the phrase above into concrete actions
	    BaseClass.getLogger().info("click on practice link in homepage");
	    hp=new HomePage(BaseClass.getDriver());
	    hp.clickOnPracticeLink();
	    hp.clickOnTestLoginLink();
	    
	}
	@When("user enters username as {string} and password as {string}")
	public void user_enters_username_as_and_password_as(String username, String password) throws InterruptedException{
	    // Write code here that turns the phrase above into concrete actions
	    lp=new LoginPage(BaseClass.getDriver());
	    String strUname = System.getenv(username);
	    if (strUname==null) {
			Dotenv dotenv = Dotenv.load();
			strUname  = dotenv.get(username);
		}
	    String strPwd = System.getenv(password);
	    System.out.println(strUname + " " + strPwd);
	    if (strPwd==null) {
			Dotenv dotenv = Dotenv.load();
			strPwd  = dotenv.get(password);
		}
	    System.out.println(strUname + " " + strPwd);
	    lp.enterUserName(strUname);
	    lp.enterPassword(strPwd);
	    Thread.sleep(10000);
	}

	@And("user clicks on submit button")
	public void user_clicks_on_submit_button() {
	    // Write code here that turns the phrase above into concrete actions
	    lp.submit();
	}

	@SuppressWarnings("deprecation")
	@Then("user logged in successfully and the title of the current page should be {string}")
	public void user_logged_in_successfully_and_the_title_of_the_current_page_should_be(String expectedTitle) {
	    // Write code here that turns the phrase above into concrete actions
	    String actualTitle=lp.getTitle();
	    Assert.assertEquals(expectedTitle, actualTitle);
	    
	}

}

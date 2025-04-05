package stepdefinitions;

import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.MyFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;


public class Login {
	
	//These hooks are run before each and every step in the scenario:
	/*
	@BeforeStep("@register")
	public void beforeEveryStep()
	{
		System.out.println("++ Before every step hook");
	}
	
	//These hooks are run after each and every step in the scenario:
	
	@AfterStep("@register")
	public void afterEveryStep()
	{
		System.out.println("-- After every step hook");
	}
	*/
	
	//Now the below methods are implemented  using Regular expressions:
	
	WebDriver driver;
	LoginPage loginPage;
	
	@Given("^User navigates to Login page$")
	public void User_navigates_to_Login_page()
	{
		driver = MyFactory.getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		
		homePage.clickOnLoginOption();
		
		
	}
	
	@When("^User enters valid email address (.+)$")
	public void User_enters_valid_email_address(String validEmail)
	{
		loginPage = new LoginPage(driver);
		loginPage.enterValidEmailAdress(validEmail);
				
		
		
	}
	@And("^enters valid password (.+)$")
	public void enters_valid_password(String validPassword)
	{
		loginPage.enterValidPassword(validPassword);
		
		
	}
	
	@And("^Clicks on Login button$")
	public void Clicks_on_Login_button() throws InterruptedException
	{
		
		loginPage.clickOnLoginButton();
		Thread.sleep(5000);
	}
	
	@Then("^User should login successfully$")
	public void User_should_login_successfully()
	{
		
		AccountPage accountPage = new AccountPage(driver);
		Assert.assertTrue(accountPage.displayStatusLogout());
		
		
		
	}
	
	@When("^User enters invalid email address")
	public void User_enters_invalid_email_address()
	{
		loginPage = new LoginPage(driver);
		loginPage.enterInvalidEmailAdress();
		
	}
	
	@And("^enters invalid password (.+)")
	public void enters_invalid_password(String invalidPassword)
	{
	
		loginPage.enterInvalidPassword(invalidPassword);
	}
	
	@Then("^User should get a proper warning message$")
	public void User_should_get_a_proper_warning_message()
	{
		
		Assert.assertTrue(loginPage.warningMessage().contains("Warning: No match for E-Mail Address and/or Password."));
	 
		
	}
	
	
	@When("^User dont enter any credentials$")
	public void User_dont_enter_any_credentials()
	{
		loginPage = new LoginPage(driver);
		loginPage.dontProvideEmailAdress();
		loginPage.dontProvidePassword();
	
	}
	
	public String getEmailTimeStamp()
	{
		Date date = new Date();
		
	   String dateString = date.toString();
	   String replaceAllSpaces = dateString.replaceAll(" ","");
	   String removeColumns = replaceAllSpaces.replaceAll(":","");
	   String finalMail = "ramu"+ removeColumns+"@gmail.com";
	   
	   return finalMail;
	  
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

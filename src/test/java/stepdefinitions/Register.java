package stepdefinitions;

import java.util.Date;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.MyFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;

public class Register {
	
	//implement hooks
	//Thse hooks written in one stepdefintions and it is applicable for all.
	//These hooks will run before each and every scenario;
	//now we implement taged hooks
	
	/*@Before("@smoke")
	public void setup()
	{
		System.out.println("++ browser got opened");
		
	}
	
	//Thsese hooks will run after each and every scenario;
	@After("@smoke")
	public void tearDown()
	{
		System.out.println("-- browser got closed");
	}
	*/

	//Now we implements the below methods using cucumber expressions
	
	WebDriver driver;
	RegisterPage registerPage;
	
	
	@Given("^User navigates to Register Account page$")
	public void User_navigates_to_Register_Account_page()
	{
		driver = MyFactory.getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		
		homePage.clickOnRegisterOption();

		
		
	}
	
	
	//here we use cucumber expression;
	//here we can use data tables;
	
	@When("User enters below details into the fields")
	public void User_enters_below_details_into_the_fields(DataTable dataTable) throws InterruptedException
	{
		Map<String, String> map = dataTable.asMap(String.class,String.class);
		
		registerPage = new RegisterPage(driver);
		
		registerPage.firstNameField(map.get("firstname"));
		Thread.sleep(1000);
		
		registerPage.lastNameField(map.get("lastname"));
		Thread.sleep(1000);
		
		registerPage.emailField(generateRandomEmail());
		Thread.sleep(1000);
		
		registerPage.telephoneField(map.get("telephone"));
		Thread.sleep(1000);
		
		registerPage.passwordField(map.get("password"));
		Thread.sleep(1000);
		
		registerPage.confirmPasswordField(map.get("confirmPassword"));
		Thread.sleep(1000);
		
		
	}
	@When("User enters below details into the fields with duplicate email")
	public void User_enters_below_details_into_the_fields_with_duplicate_email(DataTable dataTable)
	{
		
		Map<String, String> map = dataTable.asMap(String.class,String.class);
	
		registerPage = new RegisterPage(driver);
		
		registerPage.firstNameField(map.get("firstname"));
		
		registerPage.lastNameField(map.get("lastname"));
		
		registerPage.emailField(map.get("email"));
		
		registerPage.telephoneField(map.get("telephone"));
		
		registerPage.passwordField(map.get("password"));
		
		registerPage.confirmPasswordField(map.get("confirmPassword"));
		
	}
	
	@And("^Selects Privacy policy field$")
	public void Selects_Privacy_policy_field()
	{
		registerPage.privacyPolicyField();
		
	}
	
	@And("^Clicks on continue button$")
	public void Clicks_on_continue_button() throws InterruptedException
	{
		registerPage.clicksOnContinueButton();
		Thread.sleep(5000);
		

	}
	
	@Then("Account should get successfully created")
	public void Account_should_get_successfully_created()
	{
		AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
		Assert.assertEquals("Your Account Has Been Created!", accountSuccessPage.registerSuccessMessage());
		
	}
	
	@And("^Selects Yes for newsletter$")
	public void Selects_Yes_for_newsletter()
	{
		registerPage.clicksOnNewsletterYes();
	}
	
	@When("^User dont enter details into any fields$")
	public void User_dont_enter_details_into_any_fields()
	{
		registerPage = new RegisterPage(driver);
	}
	
	@Then("^Warning messages should be displayed for all mandatory fields$")
	public void Warning_messages_should_be_displayed_for_all_mandatory_fields()
	{
		Assert.assertTrue(registerPage.warningMessageForPrivacyPloicy().contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertTrue(registerPage.warningMessageFirstName().contains("First Name must be between 1 and 32 characters!"));
		Assert.assertTrue(registerPage.warningMessageLastName().contains("Last Name must be between 1 and 32 characters!"));
		Assert.assertTrue(registerPage.warningMessageEmail().contains("E-Mail Address does not appear to be valid!"));
		Assert.assertTrue(registerPage.warningMessageTelephone().contains("Telephone must be between 3 and 32 characters!"));
		Assert.assertTrue(registerPage.warningMessagePassword().contains("Password must be between 4 and 20 characters!"));
		
	}
	
	@Then("warning message informating the user about duplicate email should be displayed")
	public void warning_message_informating_the_user_about_duplicate_email_should_be_displayed()
	{
		
		Assert.assertTrue(registerPage.warningMessageForDuplicateEmail().contains("E-Mail Address is already registered!"));
		
		
	}
	
	public static String generateRandomEmail() {
		
		Date date = new Date();
		String dateString = date.toString();
		String removeAllspaces = dateString.replaceAll(" ", "");
		String removeAllColumns = removeAllspaces.replaceAll(":", "");
		String completEmail = removeAllColumns+"@gmail.com";
		return completEmail;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	    
}

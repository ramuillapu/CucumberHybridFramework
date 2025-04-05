package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class RegisterPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	//constructor
	public RegisterPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
		elementUtils = new ElementUtils(driver);
	}
	
	//create a webelements;
	
	@FindBy(id = "input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id = "input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id = "input-email")
	private WebElement emailField;
	
	@FindBy(id = "input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id = "input-password")
	private WebElement passwordField;
	
	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordField;
	
	@FindBy(xpath = "//input[@name='agree']")
	private WebElement privacyPolicyField;
	
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath = "(//input[@name='newsletter'])[1]")
	private WebElement clickOnNewsletter;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessageForDuplicateEmail;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessageforPrivacyPolicy;
	
	@FindBy(xpath = "//div[contains(text(),'First Name must be between 1 and 32 characters!')]")
	private WebElement warningMessageFirstName;
	
	@FindBy(xpath = "//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")
	private WebElement warningMessageLastName;
	
	@FindBy(xpath = "//div[contains(text(),'E-Mail Address does not appear to be valid!')]")
	private WebElement warningMessageEmail;
	
	@FindBy(xpath = "//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")
	private WebElement warningMessageTelephone;
	
	@FindBy(xpath = "//div[contains(text(),'Password must be between 4 and 20 characters!')]")
	private WebElement warningMessagePassword;

	
	
	public void firstNameField(String firstNameText) 
	{
		
		//firstNameField.sendKeys(firstNameText);
		elementUtils.typeTextIntoElement(firstNameField, elementUtils.Explict_Wait_Time, firstNameText);
	}
	
	public void lastNameField(String lastNameText)
	{
		//lastNameField.sendKeys(lastNameText);
		elementUtils.typeTextIntoElement(lastNameField, elementUtils.Explict_Wait_Time, lastNameText);
	}
	
	public void emailField(String email)
	{
		//emailField.sendKeys(email);
		elementUtils.typeTextIntoElement(emailField, elementUtils.Explict_Wait_Time, email);
	}
	
	public void telephoneField(String telephone)
	{
		//telephoneField.sendKeys(telephone);
		elementUtils.typeTextIntoElement(telephoneField, elementUtils.Explict_Wait_Time, telephone);
	}
	
	public void passwordField(String password)
	{
		//passwordField.sendKeys(password);
		elementUtils.typeTextIntoElement(passwordField, elementUtils.Explict_Wait_Time, password);
	}
	
	public void confirmPasswordField(String confirmPassword) 
	{
		//confirmPasswordField.sendKeys(confirmPassword);
		elementUtils.typeTextIntoElement(confirmPasswordField, elementUtils.Explict_Wait_Time, confirmPassword);
	}
	
	public void privacyPolicyField()
	{
		//privacyPolicyField.click();
		elementUtils.clickOnElement(privacyPolicyField, elementUtils.Explict_Wait_Time);
	}
	
	public void clicksOnContinueButton() 
	{
		//continueButton.click();
		elementUtils.clickOnElement(continueButton, elementUtils.Explict_Wait_Time);
	}
	
	public void clicksOnNewsletterYes() {
		
		//clickOnNewsletter.click();
		elementUtils.clickOnElement(clickOnNewsletter, elementUtils.Explict_Wait_Time);
	}
	
	public String warningMessageForDuplicateEmail() {
		
		//return warningMessageForDuplicateEmail.getText();
		return  elementUtils.getTextForElement(warningMessageForDuplicateEmail, elementUtils.Explict_Wait_Time);
		
	}
	
	public String warningMessageForPrivacyPloicy()
	{
		//return warningMessageforPrivacyPolicy.getText();
		return elementUtils.getTextForElement(warningMessageforPrivacyPolicy, elementUtils.Explict_Wait_Time);
	}
	
	public String warningMessageFirstName() {
		
		//return warningMessageFirstName.getText();
		return elementUtils.getTextForElement(warningMessageFirstName, elementUtils.Explict_Wait_Time);
	}
	
	public String warningMessageLastName()
	{
		//return warningMessageLastName.getText();
		return elementUtils.getTextForElement(warningMessageLastName, elementUtils.Explict_Wait_Time);
	}
	
	public String warningMessageEmail()
	{
		//return warningMessageEmail.getText();
		return elementUtils.getTextForElement(warningMessageEmail, elementUtils.Explict_Wait_Time);
	}
	
	public String warningMessageTelephone()
	{
		//return  warningMessageTelephone.getText();
		return elementUtils.getTextForElement(warningMessageTelephone, elementUtils.Explict_Wait_Time);
	}
	
	public String warningMessagePassword()
	{
		//return warningMessagePassword.getText();
		return elementUtils.getTextForElement(warningMessagePassword, elementUtils.Explict_Wait_Time);
	}
	
	
	
	
	
	

}

package pages;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class LoginPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		//it is used to create web elements with in class
		PageFactory.initElements(driver,this);
		elementUtils = new ElementUtils(driver);
		
	}
	
	//create a webelements;
	@FindBy(id = "input-email")
	private WebElement emailAdressField;
	
	@FindBy(id = "input-password")
	private WebElement passwordField;
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessage;
	
	//create a method for element;
	public void enterValidEmailAdress(String validEmail)
	{
		elementUtils.typeTextIntoElement(emailAdressField, elementUtils.Explict_Wait_Time, validEmail);
		
	}
	
	public void enterValidPassword(String validPassword)
	{
		//passwordField.sendKeys(validPassword);
		elementUtils.typeTextIntoElement(passwordField, elementUtils.Explict_Wait_Time, validPassword);
		
	}
	
	public void clickOnLoginButton()
	{
		//loginButton.click();
		elementUtils.clickOnElement(loginButton, elementUtils.Explict_Wait_Time);
		
	}
	
	public void enterInvalidEmailAdress()
	{
		
		//emailAdressField.sendKeys(getEmailTimeStamp());
		elementUtils.typeTextIntoElement(emailAdressField, elementUtils.Explict_Wait_Time, getEmailTimeStamp());
	}
	
	public void enterInvalidPassword(String invalidPassword)
	{
		//passwordField.sendKeys(invalidPassword);
		elementUtils.typeTextIntoElement(passwordField, elementUtils.Explict_Wait_Time, invalidPassword);
	}
	
	
	public void dontProvideEmailAdress()
	{
		//emailAdressField.sendKeys("");
		elementUtils.typeTextIntoElement(emailAdressField, elementUtils.Explict_Wait_Time, "");
	}
	
	public void dontProvidePassword()
	{
		//passwordField.sendKeys("");
		elementUtils.typeTextIntoElement(passwordField, elementUtils.Explict_Wait_Time, "");
	}
	
	public String warningMessage() 
	{	
		
		//return warningMessage.getText();
		 return elementUtils.getTextForElement(warningMessage, elementUtils.Explict_Wait_Time);
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

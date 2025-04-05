package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class HomePage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	//constructor
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		//used for create webelements in this class;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
		
	}
	
	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccount;
	
	@FindBy(linkText = "Login")
	private WebElement loginOption;
	
	@FindBy(linkText = "Register")
	private WebElement registerOption;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchBoxField;
	
	@FindBy(xpath = "//button[contains(@class,'btn-default')]")
	private WebElement searchButton;
	
	
	public void clickOnMyAccount()
	{	
		//insted of normal we use 
		//myAccount.click();
		elementUtils = new ElementUtils(driver);
		elementUtils.clickOnElement(myAccount, elementUtils.Explict_Wait_Time);
	}
	
	public void clickOnLoginOption()
	{
		//loginOption.click();
		elementUtils.clickOnElement(loginOption, elementUtils.Explict_Wait_Time);
	}
	
	public void clickOnRegisterOption()
	{	
		elementUtils.clickOnElement(registerOption, elementUtils.Explict_Wait_Time);
		//registerOption.click();
		
	}
	
	public void searchBoxField(String validText)
	{	
		elementUtils.typeTextIntoElement(searchBoxField, elementUtils.Explict_Wait_Time, validText);
		//searchBoxField.sendKeys("Hp");
	}
	
	public void clickOnSearchButton()
	{	
		elementUtils.clickOnElement(searchButton, elementUtils.Explict_Wait_Time);
		//searchButton.click();
	}
	
	public void searchOnNonExistingProduct(String invalidText)
	{
		elementUtils.typeTextIntoElement(searchBoxField, elementUtils.Explict_Wait_Time, invalidText);
		//searchBoxField.sendKeys("Honda");
	}

}

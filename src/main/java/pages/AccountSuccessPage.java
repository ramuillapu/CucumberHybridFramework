package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class AccountSuccessPage {

	WebDriver driver;
	private ElementUtils elementUtils;
	
	public AccountSuccessPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
		elementUtils = new ElementUtils(driver);
	}
	
	//create webelements
	
	@FindBy(xpath = "//div[@id='content']/h1")
	private WebElement registerSuccessMessage;
	
	public String registerSuccessMessage() {
		
		//return  registerSuccessMessage.getText();
		return  elementUtils.getTextForElement(registerSuccessMessage, elementUtils.Explict_Wait_Time);
	}
	
}

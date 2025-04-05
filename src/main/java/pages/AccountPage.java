package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class AccountPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public AccountPage(WebDriver driver)
	{
		this.driver = driver;
		//It is used to create webelements with in the class;
		PageFactory.initElements(driver,this);
		elementUtils = new ElementUtils(driver);
		
	}
	
	//create a webelements;
	@FindBy(linkText = "Logout")
	private WebElement displaystatusLogout;
	
	
	public boolean displayStatusLogout() 
	{
		// return displaystatusLogout.isDisplayed();
		return elementUtils.displayStatusLogout(displaystatusLogout, elementUtils.Explict_Wait_Time);
	}

}

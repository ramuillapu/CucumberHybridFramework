package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class SearchPage {

	WebDriver driver;
	private ElementUtils elementUtils;
	public SearchPage(WebDriver driver)
	{
		this.driver = driver;
		
		//This is used for creating webelements with in class;
		PageFactory.initElements(driver,this);
		elementUtils = new ElementUtils(driver);
	}
	
	//create webelements;
	
	@FindBy(linkText = "HP LP3065")
	private WebElement validProductGetDisplay;
	
	@FindBy(xpath = "//input[@id='button-search']/following-sibling::p")
	private WebElement noProductMatchingGetDisplay;
	
	
	public String validProductGetDisplay()
	{
		//return validProductGetDisplay.getText();
		return elementUtils.getTextForElement(validProductGetDisplay, elementUtils.Explict_Wait_Time);
	}
	
	public String noProductMatchingGetDisplay()
	{
		//return noProductMatchingGetDisplay.getText();
		return elementUtils.getTextForElement(noProductMatchingGetDisplay, elementUtils.Explict_Wait_Time);

	}
}

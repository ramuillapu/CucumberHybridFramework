package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	WebDriver driver;
	
	//create hardcode data for implict and explict wait and pageload;
	
	public static final int Implict_Wait_Time = 10;
	public final int Explict_Wait_Time = 30;
	
	
	
	//create a constructor
	public ElementUtils(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//create a method for clickonelement;
	
	public void clickOnElement(WebElement element,long durationInSeconds)
	{	
		
		WebElement webElement = waitForElement(element, durationInSeconds);
		webElement.click();
		
		
		
	}
	
	//create method for typetextintoelement;
	
	public void typeTextIntoElement(WebElement element,long durationInSeconds,String textToBeTyped)
	{
		WebElement webElement = waitForElement(element, durationInSeconds);
		
		webElement.click();
		webElement.clear();
		webElement.sendKeys(textToBeTyped);
		
	}
	
	//create method for wait for element;
	
	public WebElement waitForElement(WebElement element,long durationInSeconds)
	{	
		WebElement webElement = null;
		
		try
		{	
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		return webElement;
	}
	
	//select option in dropdown method;
	
	public void selectOptionInDropdown(WebElement element,long durationInSeconds,String dropDown)
	{
		WebElement webElement = waitForElement(element, durationInSeconds);
		Select select = new Select(webElement);
		select.selectByVisibleText(dropDown);
		

	}
	
	//accept alert method implementation;
	
	public void acceptAlert(long durationsInSeconds)
	{
		Alert alert = waitForAlert(durationsInSeconds);
		alert.accept();
	}
	
	//dismiss the alert;
	public void dismissAlert(long durationInSeconds)
	{
		Alert alert = waitForAlert(durationInSeconds);
		alert.dismiss();
	}
	
	//wait for alert method;
	
	public Alert waitForAlert(long durationInSeconds)
	{
		Alert alert = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			alert = wait.until(ExpectedConditions.alertIsPresent());
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		return alert;
	}
	
	//MouseHover and click element;
	
	public void mouseHoverAndClickElement(WebElement element,long durationInSeconds)
	{
		
		WebElement webElement = waitForvisibilityOfElement(element, durationInSeconds);
		Actions actions = new Actions(driver);
		actions.moveToElement(webElement).click().build().perform();
	}
	
	public WebElement waitForvisibilityOfElement(WebElement element,long durationInSeconds)
	{
		WebElement webElement = null;
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.visibilityOf(element));
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		return webElement;
	}
	
	//javascript click method;
	
	public void javaScriptClick(WebElement element,long durationInSeconds)
	{
		WebElement webElement = waitForvisibilityOfElement(element, durationInSeconds);
		
		//typecast of driver;
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].click()", webElement);
		
		
	}
	
	public void javaScriptType(WebElement element,long durationInSeconds,String testToBeType)
	{
		WebElement webElement = waitForvisibilityOfElement(element, durationInSeconds);
		
		//typecast of driver;
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].value = '"+testToBeType+"'",webElement);
	}
	
	public String getTextForElement(WebElement element,long durationInSeconds)
	{
		WebElement webElement = waitForvisibilityOfElement(element, durationInSeconds);
		return webElement.getText();
		
		
		
	}
	
	public boolean displayStatusLogout(WebElement element,long durationInSeconds)
		{
		
		try
		{
			WebElement webElement = waitForvisibilityOfElement(element,durationInSeconds);
			
			return webElement.isDisplayed();
			
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
			
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyFactory {
	
	 static WebDriver driver;

	public static void initlizeBrowser(String BrowserName)
	{
		
		if(BrowserName.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BrowserName.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		else if(BrowserName.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	

}

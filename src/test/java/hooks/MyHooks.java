package hooks;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.MyFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;
import utils.ElementUtils;

public class MyHooks {
	
	//These method will run before each and every secenario;
	WebDriver driver;
	
	@Before
	public void setup() 
	{
		Properties prop = ConfigReader.initlizeProperties();
		MyFactory.initlizeBrowser(prop.getProperty("browser"));
		driver = MyFactory.getDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		
		//hardcode of durationofseconds;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ElementUtils.Implict_Wait_Time));
	}
	
	@After
	public void tearDown(Scenario scenario)
	{	
		String scenarioName = scenario.getName().replaceAll(" ", "_");
		
		// with driver;
		if(scenario.isFailed())
		{
			byte[] SourceScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		
			scenario.attach(SourceScreenshot, "image/png", scenarioName);
		}
		
			
		driver.quit();
	}
}

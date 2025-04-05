package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//dry run is used to its showing an error without implement every setp in scenario;


@CucumberOptions( features ="src/test/resource/features/Search.feature",
				  glue = {"stepdefinitions","hooks"},
				  plugin = {"pretty",
						  "html:target/CucumberReports/CucumberReport.html",
						  "json:target/CucumberReports/CucumberReport.json",
						  "junit:target/CucumberReports/CucumberReport.xml"}
                 )
public class TestRunner extends AbstractTestNGCucumberTests {

	
	
}

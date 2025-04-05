package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.MyFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchPage;

public class Search {
	
	//multiple hooks and their order;
	//Before each every scenario;
	
	/*
	@Before(order = 0,value = "@search")
	public void setupOne()
	{
		System.out.println("++ setupone hook got executed");
	}
	@Before(order = 1,value = "@search")
	public void setupTwo()
	{
		System.out.println("++ setupTwo hook got executed");
	}
	@Before(order = 2,value = "@search")
	public void setupThree()
	{
		System.out.println("++ setupThree hook got executed");
	}
	
	//after each every hook;
	
	@After(order = 2,value = "@search")
	public void tearDownOne()
	{
		System.out.println("-- tearDownOne hook got executed");
	}
	
	@After(order = 1,value = "@search")
	public void tearDownTwo()
	{
		System.out.println("-- tearDownTwo hook got executed");
	}
	
	@After(order = 0,value = "@search")
	public void tearDownThree()
	{
		System.out.println("-- tearDownThree hook got executed");
	}
	
	*/
	
	WebDriver driver;
	HomePage homePage;
	
	@Given("User open the application")
	public void user_open_the_application() {
		
		driver = MyFactory.getDriver();
	   
		
	}

	@When("User enters valid product {string} into the search field")
	public void user_enters_valid_product_into_the_search_field(String validText) {
		
		homePage = new HomePage(driver);
		homePage.searchBoxField(validText);
		
	 }

	@When("Clicks the search button")
	public void clicks_the_search_button() throws InterruptedException {
		
		homePage = new HomePage(driver);
		homePage.clickOnSearchButton();
		Thread.sleep(3000);
		
	 }

	@Then("valid product should get displayed in search results")
	public void valid_product_should_get_displayed_in_search_results() {
	    
		SearchPage searchPage = new SearchPage(driver);
		
		Assert.assertTrue(searchPage.validProductGetDisplay().contains("HP LP3065"));
		
	}

	@When("User enters non-existing product {string} into the search field")
	public void user_enters_non_existing_product_into_the_search_field(String invalidText) {
	    
		homePage = new HomePage(driver);
		homePage.searchOnNonExistingProduct(invalidText);
		
		
	}

	@Then("proper text informing the user about no product matching should be displayed")
	public void proper_text_informing_the_user_about_no_product_matching_should_be_displayed() {
	   
		
		SearchPage searchPage = new SearchPage(driver);
		
		Assert.assertTrue(searchPage.noProductMatchingGetDisplay().contains("There is no product that matches the search criteria."));
		
	}

	@When("User dont enter any product into the search field")
	public void user_dont_enter_any_product_into_the_search_field() {
	    
		//Intentionally kept blank;
		HomePage homepage = new HomePage(driver);
		
		
		
	}

}

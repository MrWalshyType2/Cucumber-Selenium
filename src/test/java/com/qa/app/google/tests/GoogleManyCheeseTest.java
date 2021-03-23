package com.qa.app.google.tests;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.app.ChromeHooks;
import com.qa.app.google.page.GooglePOM;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleManyCheeseTest {
	
	private final String URL = "https://google.com";
	private final GooglePOM POM;
	
	public GoogleManyCheeseTest(ChromeHooks hooks) {
		this.POM = PageFactory.initElements(hooks.driver, GooglePOM.class);
	}
	
	@Given("I am on the google search page")
	public void iAmOnTheGoogleSearchPage() {
	    POM.getDriver().get(URL);
	}

	@Given("the search term is {string}")
	public void theSearchTermIs(String string) {
		System.out.format("Thread ID - %2d - %s from finding_many_cheese feature file.\n",
		        Thread.currentThread().getId(), string);
		
	    POM.googleLandingPage.search(string);
	}
	
	@When("I ask if {string} has been searched for")
	public void iAskIfHasBeenSearchedFor(String string) throws Exception {
		WebElement e = POM.googleLandingPage.searchBar;

		assertEquals(e.getAttribute("value"), string);
	}

	@Then("I should get a search title starting with {string}")
	public void iShouldGetAStatusOf(String string) {
		new WebDriverWait(POM.getDriver(), 10L).until(new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver input) {
				return input.getTitle()
							.toLowerCase()
							.startsWith(string);
			}
			
		});
	}
	
}

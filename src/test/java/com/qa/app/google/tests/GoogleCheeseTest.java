package com.qa.app.google.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.app.Hooks;
import com.qa.app.google.page.GooglePOM;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleCheeseTest {
	
	private final GooglePOM POM;

	public GoogleCheeseTest(Hooks hooks) {
		this.POM = PageFactory.initElements(hooks.getDriver(), GooglePOM.class);
	}

	@Given("I am on the Google search page")
	public void iAmOnTheGoogleSearchPage() {
		POM.navigateToLandingPage();
	}

	@When("I search for {string}")
	public void iSearchFor(String string) throws InterruptedException {
		System.out.format("Thread ID - %2d - %s from finding_cheese feature file.\n",
		        Thread.currentThread().getId(), string);
		
	    POM.googleLandingPage.search(string);
	}

	@Then("the page title should start with {string}")
	public void thePageTitleShouldStartWith(String string) {
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

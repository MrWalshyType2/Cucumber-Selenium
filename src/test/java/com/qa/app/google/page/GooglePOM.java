package com.qa.app.google.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GooglePOM {
	
	private WebDriver driver;

	public GoogleLandingPage googleLandingPage;

	public GooglePOM(WebDriver driver) {
		super();
		this.googleLandingPage = PageFactory.initElements(driver, GoogleLandingPage.class);
		this.driver = driver;
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(1500, TimeUnit.MILLISECONDS);
	}
	
	public void navigateToLandingPage() {
		driver.get(googleLandingPage.URL);
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}
}

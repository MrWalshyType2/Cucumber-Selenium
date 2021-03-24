package com.qa.app.amazon.page;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AmazonPOM {

	private static final String URL = "https://www.amazon.co.uk/";

	private WebDriver driver;
	
	private AmazonLandingPage amazonLandingPage;
	private AmazonSearchResultPage amazonSearchResultPage;
		
	public AmazonPOM(WebDriver driver) {
		this.driver = driver;
		this.amazonLandingPage = PageFactory.initElements(driver, AmazonLandingPage.class);
		this.amazonSearchResultPage = PageFactory.initElements(driver, AmazonSearchResultPage.class);
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void navigateToAmazonLandingPage() {
		driver.get(URL);
	}
	
	public void navigateToAmazonLandingPage(String s) {
		driver.get(s);
	}

	public AmazonLandingPage getAmazonLandingPage() {
		return amazonLandingPage;
	}

	public AmazonSearchResultPage getAmazonSearchResultPage() {
		return amazonSearchResultPage;
	}

}

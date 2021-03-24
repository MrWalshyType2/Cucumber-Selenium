package com.qa.app.amazon;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonLandingPage {
	
	@FindBy(xpath = "//input[contains(@aria-label, 'search') or contains(@aria-label, 'Search')]")
	private WebElement searchInputElement;
	
	public void searchFor(String item) throws InterruptedException {
		searchInputElement.clear();
		searchInputElement.sendKeys(item);
		searchInputElement.submit();
//		searchInputElement.click();
	}
	
}

package com.qa.app.google.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleLandingPage {

	public final String URL = "https://www.google.com";
	
	@FindBy(name = "q")
	public WebElement searchBar;
	
	@FindBy(name = "btnK")
	public WebElement googleSearchBtn;
	
	@FindBy(name = "btnI")
	public WebElement imFeelingLuckyBtn;
	
	public void search(String searchTerm) {
		searchBar.sendKeys(searchTerm);
		googleSearchBtn.submit();
	}
	
	public void feelingLuckySearch(String searchTerm) {
		searchBar.sendKeys(searchTerm);
		imFeelingLuckyBtn.submit();
	}
}

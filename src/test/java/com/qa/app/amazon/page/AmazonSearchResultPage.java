package com.qa.app.amazon.page;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.qa.app.Book;

public class AmazonSearchResultPage {

	@FindBy(xpath = "//*[@data-component-type='s-search-result']/div[1]/span[1]/div[1]/div[1]/div[2]/h2/a/span")
	//@FindAll(value = {@FindBy(xpath = "//*[@id=\"search\"]/div[1]/div/div[1]/div/span[3]/div[2]/div[5]/div/span/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a/span")})
	private List<WebElement> titleSpanElements;
	
	@FindBy(xpath = "//*[@data-component-type='s-search-result']/div[1]/span[1]/div[1]/div[1]/div[2]/h2/a")
//	@FindBy(xpath = "//")
	private List<WebElement> titleLinkAnchorElements;
	
//	@FindBy(xpath = "//*[@id=\"search\"]/div[1]/div/div[1]/div/span[3]/div[2]/div[5]/div/span/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/div/a")
//	private List<WebElement> authorAnchorElements;
	
	public List<Book> getBooks() throws Exception {
		// || testSize != authorAnchorElements.size()
		int testSize = titleSpanElements.size();
		if (testSize != titleLinkAnchorElements.size()) {
			throw new Exception("Retrieved book fields are unequal in size, cannot build data output");
		}

		List<Book> books = new ArrayList<Book>();
		
		for (int i = 0; i < testSize; i++) {
			String title = titleSpanElements.get(i).getText();
			String titleLink = titleLinkAnchorElements.get(i).getAttribute("href");
//			String author = authorAnchorElements.get(i).getText();
			books.add(new Book(title, titleLink, ""));
		}
		return books;
	}

	public List<WebElement> getTitleSpanElements() {
		return titleSpanElements;
	}

	public List<WebElement> getTitleLinkAnchorElements() {
		return titleLinkAnchorElements;
	}

//	public List<WebElement> getAuthorAnchorElements() {
//		return authorAnchorElements;
//	}
}

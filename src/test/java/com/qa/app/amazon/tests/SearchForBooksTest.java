package com.qa.app.amazon.tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.app.Book;
import com.qa.app.Hooks;
import com.qa.app.amazon.page.AmazonPOM;
import com.qa.app.amazon.page.AmazonSearchResultPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchForBooksTest {
	
	private AmazonPOM POM;
	private WebDriver webDriver;
	private AmazonSearchResultPage searchResultPage;
	
	private List<List<Book>> books;
	private List<List<Book>> testableBooks;
	private List<String> expectedTitles;
	
	public SearchForBooksTest(Hooks hooks) {
		super();
		this.webDriver = hooks.getDriver();
		this.POM = PageFactory.initElements(webDriver, AmazonPOM.class);
		this.searchResultPage = POM.getAmazonSearchResultPage();
		this.books = new ArrayList<List<Book>>();
	}
	
	@Given("I have navigated to a website")
	public void iHaveNavigatedToAWebsite() {
	    POM.navigateToAmazonLandingPage();
	}

	@When("I search for the book title")
	public void iSearchForTheBookTitle(DataTable dataTable) throws Exception {	    
	    Map<String, String> data = dataTable.asMap(String.class, String.class);
	    expectedTitles = new ArrayList<String>();
	    
	    for (String title : data.keySet()) {
	    	POM.navigateToAmazonLandingPage();
			POM.getAmazonLandingPage().searchFor(title);
//			Thread.sleep(5000); // TODO: add explicit wait
			
			List<Book> booksOnPage = searchResultPage.getBooks();
	    	books.add(booksOnPage);
	    	expectedTitles.add(title);
	    }
	}
	
	@Then("one of the first three books will contain the desired title")
	public void oneOfTheFirstThreeBooksWillContainTheDesiredTitle() throws Exception {
	    testableBooks = new ArrayList<List<Book>>();
		
		// list of list of books
	    for (int i = 0; i < books.size(); i++) {
	    	// list of books
	    	List<Book> tmp = new ArrayList<Book>();
	    	
	    	for (int j = 0; j < books.get(i).size(); j++) {
	    		if (j >= 3) break;
	    		Book cb = books.get(i).get(j);
	    		System.out.println(cb);
	    		
	    		tmp.add(cb);
	    	}
	    	testableBooks.add(tmp);
	    }
	    
	    for (int i = 0; i < testableBooks.size(); i++) {
	    	for (int j = 0; j < testableBooks.get(i).size(); j++) {
		    	System.out.println(testableBooks.get(i).get(j));
		    	System.out.println(expectedTitles.get(i));
	    	}
	    }
	}
	
	@Then("the results for the book should be saved")
	public void theResultsForTheBookShouldBeSaved() throws IOException {
	    Path storageDir = Path.of("target/bookstore");
	    Path storagePath = Path.of("target/bookstore/books.csv");
	    
	    if (!Files.exists(storageDir)) {
		    Files.createDirectory(storageDir);
	    }
	    
	    try (var writer = Files.newBufferedWriter(storagePath)) {
	    	writer.write("author,title,link");
	    	writer.newLine();
	    	for (var bookList : testableBooks) {
	    		for (var book : bookList) {
	    			writer.write(book.toCSV());
	    			writer.newLine();
	    		}
	    	}
	    }
	}
	
	@Then("the saved book results should be verified")
	public void theSavedBookResultsShouldBeVerified() throws IOException {
		Path storagePath = Path.of("target/bookstore/books.csv");
		
		try (var reader = Files.newBufferedReader(storagePath)) {
			String line = reader.readLine();
			
			assertEquals("author,title,link", line);
			
			for (var bookList : testableBooks) {
	    		for (var book : bookList) {
	    			assertEquals(book.toCSV(), line = reader.readLine());
	    		}
	    	}
		}
	}
}

@Search_For_Books
Feature: Search for specified books

  Scenario Outline: Searching for books
    Given I have navigated to a website
    When I search for the book title
			| OCP Oracle Certified Professional Java SE 11 Developer Complete Study Guide		| https://www.amazon.com |
			| The Linux Command Line, 2nd Edition																						| https://www.amazon.com |
    Then one of the first three books will contain the desired title
    Then the results for the book should be saved
    Then the saved book results should be verified
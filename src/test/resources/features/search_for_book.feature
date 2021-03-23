Feature: Search for specified books

  Scenario Outline: Searching for "<title>"
    Given I have navigated to "<url>"
    When I search for "<title>"
    Then one of the first 3 books will contain the desired title: "<title>"
    Then the results for the "<title>" book should be saved
    Then the saved "<title>" book results should be verified
    
    Examples:
      | title                                                                         | url                    |
			| OCP Oracle Certified Professional Java SE 11 Developer Complete Study Guide		| https://www.amazon.com |
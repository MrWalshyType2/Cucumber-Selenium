#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
#@blueCheeseSearch
Feature: Has blue cheese been searched for?
  I want to know if blue cheese has been searched

#  @blueCheeseScenarioOutline
  Scenario Outline: Blue cheese has or has not been searched
    Given I am on the google search page
    Given the search term is "<search>"
    When I ask if "<search>" has been searched for
    Then I should get a search title starting with "<search>"

    Examples: 
      | search   				|
      | cheese   				|
      | blue cheese    	|

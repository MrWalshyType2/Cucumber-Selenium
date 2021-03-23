package com.qa.app;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {
				"pretty",
				"html:target/cucumber-google-report.html",
				"json:target/cucumber-google-report.json", "summary"
		},
		tags = "@findingCheese or @blueCheeseSearch",
		snippets = SnippetType.CAMELCASE,
		features = "classpath:features"
)
public class GoogleTestRunner {

}

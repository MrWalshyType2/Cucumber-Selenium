package com.qa.app;

import org.junit.runner.RunWith;
//import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
//import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
//@Cucumber
// 'pretty' and 'html' and formatter plugins
// 'summary' plugin prints code snippets
// 'CAMELCASE' changes default gen code snippets from UNDERSCORE (default)
// - 'dryRun=true' will verify that all feature file steps have step definitions
// - 'monochrome=true' will output to the console in a readable format
// - 'strict=false' will skip undefined steps from execution
//
// specify tags to tell cucumber to only run scenarios with specific tags specified
// - `tags={"@foo", "not @bar"}
@CucumberOptions(
		plugin = {"pretty", "html:target/cucumber-report.html", "json:target/cucumber.json", "summary"},
		snippets = SnippetType.CAMELCASE,
		features = "classpath:features",
		monochrome = true
) // Use to provide additional configs to the runner
public class RunCucumberTests  {
	
}

package com.qa.app;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ChromeHooks {

	public WebDriver driver;
		
	public ChromeHooks() {

	}

    @Before
    public void setup() {
        System.out.println("In setup method...");
        
        if (driver == null) {
            driver = BrowserConfig.getChromeDriver();
        }
    }

    @After
    public void cleanUp(Scenario scenario) {	
        System.out.println("In the cleanUp method...");
        if (null != driver) {
        	if (scenario.isFailed()) {
    		    byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    		    scenario.attach(screenshot, "image/png", "name");
    		}
        	
            driver.quit();
        }
    }
}

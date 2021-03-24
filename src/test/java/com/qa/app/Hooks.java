package com.qa.app;

import org.openqa.selenium.WebDriver;

import com.qa.app.configuration.BrowserConfig;
import com.qa.app.utils.ConfigurationProperties;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	private WebDriver driver;
	
	public Hooks() {

	}

    @Before
    public void setup() {
        System.out.println("In setup method...");
        
        if (driver == null) {
        	ConfigurationProperties props = new ConfigurationProperties();
        	try {
				props.loadProperties();
				
				String driverProp = props.getPropertyValue("driver");
	        	
	        	switch (driverProp) {
	        	case "chrome":
	        		driver = BrowserConfig.getChromeDriver();
	        		break;
	        	case "firefox":
	        		driver = BrowserConfig.firefox();
	        		break;
	        	case "edge":
	        		driver = BrowserConfig.edge();
	        		break;
        		default:
        			throw new Exception("NO DRIVERS FOUND");
	        	}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("COULD NOT LOAD PROPERTIES FILE");
				System.out.println("ATTEMPTING LOAD WITH DEFAULT CHROME DRIVER");
				
				driver = BrowserConfig.getChromeDriver();
			}
        }
    }

    @After
    public void cleanUp(Scenario scenario) {	
        System.out.println("In the cleanUp method...");
        if (driver != null) {
//        	if (scenario.isFailed()) {
//    		    byte[] screenshot = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.BYTES);
//    		    scenario.attach(screenshot, "image/png", "name");
//    		}
        	BrowserConfig.releaseResources(driver);
        }
    }

	public WebDriver getDriver() {
		return driver;
	}
}

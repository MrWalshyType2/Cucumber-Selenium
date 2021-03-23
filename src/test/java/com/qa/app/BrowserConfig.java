package com.qa.app;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserConfig {

	public static WebDriver getChromeDriver() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        
        Map<String, Object> prefs = new HashMap<String, Object>();
		ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("headless");

		// Settings
		prefs.put("profile.default_content_setting_values.cookies", 2);
		prefs.put("network.cookie.cookieBehavior", 2);
		prefs.put("profile.block_third_party_cookies", true);

		// Create ChromeOptions to disable Cookies pop-up
		chromeOptions.setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver(chromeOptions);
//        driver.manage().window().setSize(new Dimension(1366, 768));
        
        return driver;
	}
	
	public static FirefoxDriver firefox() {
		FirefoxOptions fOptions = new FirefoxOptions();
		fOptions.addPreference("profile.default_content_setting_values.cookies", 2);
		fOptions.addPreference("network.cookie.cookieBehavior", 2);
		fOptions.addPreference("profile.block_third_party_cookies", true);

		return new FirefoxDriver(fOptions);
	}
	
	public static EdgeDriver edge(String strategy) {
		EdgeOptions eOptions = new EdgeOptions();
		eOptions.merge(DesiredCapabilities.edge());
		
		eOptions.setCapability(CapabilityType.BROWSER_VERSION, "89.0.774.50");
		eOptions.setPageLoadStrategy(strategy); // normal, eager, none
		eOptions.setCapability("InPrivate", true); // clean session, clean cookies
		
		return new EdgeDriver(eOptions);
	}
	
	public static EdgeDriver edge() {
		EdgeOptions eOptions = new EdgeOptions();
		eOptions.merge(DesiredCapabilities.edge());
		
		eOptions.setCapability(CapabilityType.BROWSER_VERSION, "89.0.774.50");
		eOptions.setPageLoadStrategy("normal"); // normal, eager, none
		eOptions.setCapability("InPrivate", true); // clean session, clean cookies
		
		return new EdgeDriver(eOptions);
	}
	
	public static void releaseResources(WebDriver driver) {
        if (null != driver) {
            driver.close();
            driver.quit();
        }
    }
}

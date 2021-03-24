package com.qa.app.configuration;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserConfig {

	public static ChromeDriver getChromeDriver() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        
        Map<String, Object> prefs = new HashMap<String, Object>();
		ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("headless");

		// Settings
		prefs.put("profile.default_content_setting_values.cookies", 2);
		prefs.put("network.cookie.cookieBehavior", 2);
		prefs.put("profile.block_third_party_cookies", true);

		// Create ChromeOptions to disable Cookies pop-up
		chromeOptions.setExperimentalOption("prefs", prefs);

        ChromeDriver driver = new ChromeDriver(chromeOptions);
//        driver.manage().window().setSize(new Dimension(1366, 768));
        
        return driver;
	}
	
	public static FirefoxDriver firefox() {
		System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
		
		FirefoxOptions fOptions = new FirefoxOptions();
		fOptions.setAcceptInsecureCerts(true);
		fOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		fOptions.setHeadless(true);
		fOptions.setProfile(new FirefoxProfile());
		fOptions.addPreference("profile.default_content_setting_values.cookies", 2);
		fOptions.addPreference("network.cookie.cookieBehavior", 2);
		fOptions.addPreference("profile.block_third_party_cookies", true);

		return new FirefoxDriver(fOptions);
	}
	
	public static EdgeDriver edge(String strategy) {
		System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");

		EdgeOptions eOptions = new EdgeOptions();
		eOptions.merge(DesiredCapabilities.edge());
		
		eOptions.setCapability(CapabilityType.BROWSER_VERSION, "89.0.774.50");
		eOptions.setPageLoadStrategy(strategy); // normal, eager, none
		eOptions.setCapability("InPrivate", true); // clean session, clean cookies
		
		return new EdgeDriver(eOptions);
	}
	
	public static EdgeDriver edge() {
		System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");

		EdgeOptions eOptions = new EdgeOptions();
		eOptions.merge(DesiredCapabilities.edge());
		
		eOptions.setCapability(CapabilityType.BROWSER_VERSION, "89.0.774.50");
		eOptions.setPageLoadStrategy("normal"); // normal, eager, none
		eOptions.setCapability("InPrivate", true); // clean session, clean cookies
		
		return new EdgeDriver(eOptions);
	}
	
	public static void releaseResources(WebDriver driver) {
        if (null != driver) {
//            driver.close();
            driver.quit();
        }
    }
}

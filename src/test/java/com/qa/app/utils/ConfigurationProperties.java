package com.qa.app.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationProperties {

	private Properties properties;
	
	public ConfigurationProperties() {
		this.properties = new Properties();
	}
	
	public void loadProperties() throws FileNotFoundException, IOException {
		try (var in = new FileInputStream("src/test/resources/test.properties")) {
			properties.load(in);
		}
	}
	
	public void loadProperties(String uri) throws FileNotFoundException, IOException {
		try (var in = new FileInputStream(uri)) {
			properties.load(in);
		}
	}
	
	public String getPropertyValue(String key) {
		return properties.getProperty(key);
	}

	public void setPropertyValue(String key, String value) {
		properties.setProperty(key, value);
	}
}

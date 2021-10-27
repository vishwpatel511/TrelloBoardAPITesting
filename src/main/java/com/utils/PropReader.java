package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropReader {
	private Properties prop;

	/*
	 * implementing the encapsulation concept to prevent the unauthorized sources to contamine the prop.
	 */
	public String getString(String key) throws Exception {
		
		prop = new Properties();
		FileInputStream ip = new FileInputStream("src/main/java/com/env_vars/config.properties");
		prop.load(ip);
		return prop.getProperty(key);
	}
	
}

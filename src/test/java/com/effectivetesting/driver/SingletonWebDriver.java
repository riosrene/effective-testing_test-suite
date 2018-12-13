package com.effectivetesting.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingletonWebDriver {
	private static WebDriver driver;
	
	private SingletonWebDriver() {}
	
	public static WebDriver getInstance() {
        if (driver == null) {
        	//System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        	System.setProperty("webdriver.chrome.driver", "/opt/chromedriver/chromedriver");
        	driver = new ChromeDriver();
        	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        	
        	return driver;
        }
        return driver;
	}
}

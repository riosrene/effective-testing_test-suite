package com.effectivetesting.pageobject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageObject {
	private WebDriver driver;
	final static Logger logger = Logger.getLogger(HomePageObject.class);
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public EntryPageObject goToCreateEntry() {
		try {
			logger.debug("Going to Create Entry section.");
			
			driver.findElement(By.id("create_post")).click();			
		} catch (Exception e) {
			logger.error(e);
		}
		
		return new EntryPageObject(driver);
	}
}

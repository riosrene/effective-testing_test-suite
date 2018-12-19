package com.effectivetesting.pageobject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EntryPageObject {
	private WebDriver driver;
	final static Logger logger = Logger.getLogger(EntryPageObject.class);
	
	public EntryPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public EntryPageObject createEntry(String title, String text) {
		try {
			logger.debug("Creating entry.");

			logger.debug("Entering Entry data.");
			driver.findElement(By.id("title")).sendKeys(title);
			driver.findElement(By.id("body")).sendKeys(text);
			driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/form/div[5]/div/button")).click();	
		} catch (Exception e) {
			logger.error(e);
		}
		
		return this;
	}
	
	public String getResultMessage() {
		String result = "not defined.";
		try {
			logger.debug("Getting operation result.");
			result = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div/span")).getText();
		} catch (Exception e) {
			logger.error(e);
		}
		return result;
	}
}

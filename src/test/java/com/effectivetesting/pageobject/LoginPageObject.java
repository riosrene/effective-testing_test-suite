package com.effectivetesting.pageobject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageObject {
	private WebDriver driver;
	final static Logger logger = Logger.getLogger(LoginPageObject.class);
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public HomePageObject login(String email, String pass) {
		try {
			logger.debug("Logging into the app.");
			
			driver.findElement(By.id("login")).click();
			driver.findElement(By.id("email")).sendKeys(email);
			driver.findElement(By.id("password")).sendKeys(pass);
			driver.findElement(By.id("btn-submit")).click();
		
		} catch (Exception e) {
			logger.error(e);
		}
		
		return new HomePageObject(driver);
	}
}

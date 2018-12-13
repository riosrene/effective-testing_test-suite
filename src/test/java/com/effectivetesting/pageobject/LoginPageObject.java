package com.effectivetesting.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.effectivetesting.driver.SingletonWebDriver;

public class LoginPageObject {
	private WebDriver driver;
	
	public LoginPageObject() {
		this.driver = SingletonWebDriver.getInstance();
	}
	
	public HomePageObject login(String email, String pass) {
		driver.findElement(By.id("login")).click();
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.id("btn-submit")).click();
		
		return new HomePageObject();
	}
}

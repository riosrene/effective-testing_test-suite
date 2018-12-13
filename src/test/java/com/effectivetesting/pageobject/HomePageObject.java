package com.effectivetesting.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.effectivetesting.driver.SingletonWebDriver;

public class HomePageObject {
	private WebDriver driver;
	
	public HomePageObject() {
		this.driver = SingletonWebDriver.getInstance();
	}

	public EntryPageObject goToCreateEntry() {
		driver.findElement(By.id("create_post")).click();
		
		return new EntryPageObject();
	}
}

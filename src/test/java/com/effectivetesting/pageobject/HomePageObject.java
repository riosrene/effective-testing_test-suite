package com.effectivetesting.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageObject {
	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public EntryPageObject goToCreateEntry() {
		driver.findElement(By.id("create_post")).click();
		
		return new EntryPageObject(driver);
	}

	public EntryListPageObject gotoAvailableEntries() {
		driver.findElement(By.id("blog")).click();
		return new EntryListPageObject(driver);
	}
}

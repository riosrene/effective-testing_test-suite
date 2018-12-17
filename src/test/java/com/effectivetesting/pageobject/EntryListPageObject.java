package com.effectivetesting.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EntryListPageObject {
	private WebDriver driver;
	
	public EntryListPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public EntryDetailsPageObject openEntry(String name) {
		driver.findElement(By.linkText(name)).click();
		return new EntryDetailsPageObject(driver);
	}
}

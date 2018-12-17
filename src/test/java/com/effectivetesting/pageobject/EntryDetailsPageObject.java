package com.effectivetesting.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EntryDetailsPageObject {
	private WebDriver driver;
	
	public EntryDetailsPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public EntryDetailsPageObject comment(String name, String email, String message) {
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("body")).sendKeys(message);
		driver.findElement(By.xpath("//*[@id=\"comment-form\"]/div[5]/div/button")).click();
		return this;
	}
	
	public String getResultMessage() {
		return driver.findElement(By.xpath("//*[@id=\"content_title\"]/div")).getText();
	}
}

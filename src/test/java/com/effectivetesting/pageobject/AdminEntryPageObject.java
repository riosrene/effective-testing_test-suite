package com.effectivetesting.pageobject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminEntryPageObject {
	private WebDriver driver;
	
	public AdminEntryPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public AdminEntryPageObject deleteFirstEntry() {
	    WebDriverWait waitForArray = new WebDriverWait(driver, 10);
	    waitForArray.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/table/tbody/tr")));
		
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/form")).click();
	
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		   
	    alert.accept();
	    
	    WebDriverWait waitForMessage = new WebDriverWait(driver, 10);
	    waitForMessage.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[2]")));
		
		return this;
	}
	
	public boolean registryExists() {
		int elementPresent = driver.findElements(By.xpath("/html/body/div/table/tbody/tr/td[2]/form")).size();
		return (elementPresent > 0) ? true : false;
	}
	
}

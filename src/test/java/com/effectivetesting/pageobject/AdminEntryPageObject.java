package com.effectivetesting.pageobject;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminEntryPageObject {
	private WebDriver driver;
	
	public AdminEntryPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public AdminEntryPageObject deleteLatestEntry() {
		driver.findElement(By.xpath("/html/body/div/table/thead/tr/th[8]/a")).click();
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr[1]/td[2]/form/button/i")).click();
		
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		   
	    alert.accept();
	    
	    WebDriverWait waitForMessage = new WebDriverWait(driver, 10);
	    waitForMessage.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[2]")));
		
		return this;
	}
	
	public AdminEntryPageObject deleteEntry(String entryTitle) {
		
		String index = driver.findElement(By.xpath("/html/body/div/ul/li[1]/a")).getText().replaceAll("[^0-9]", "");
		
		for(int i = 1; i <= Integer.parseInt(index) ;i++) {
			if (driver.findElement(By.xpath("/html/body/div/table/tbody/tr[" + i + "]/td[3]")).getText().equals(entryTitle)) {
				driver.findElement(By.xpath("/html/body/div/table/tbody/tr[" + i + "]/td[2]/form/button")).click();
				break;
			}
			
		}
		
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		   
	    alert.accept();
	    
	    WebDriverWait waitForMessage = new WebDriverWait(driver, 10);
	    waitForMessage.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[2]")));
		
		return this;
	}
}

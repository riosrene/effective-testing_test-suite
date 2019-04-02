package com.effectivetesting.entry;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.effectivetesting.helper.ScreenshotTaker;

public class TestCreateEntry {
	private WebDriver driver;
	private ScreenshotTaker screenshot;

	@Test
	public void postIsSuccessfull() {
		driver.findElement(By.id("login")).click();
		driver.findElement(By.id("email")).sendKeys("admin1@gmail.com");
		driver.findElement(By.id("password")).sendKeys("admin1");
		screenshot.takeScreenshot(driver, "login");
		
		driver.findElement(By.id("btn-submit")).click();
		
		driver.findElement(By.id("create_post")).click();
		driver.findElement(By.id("title")).sendKeys("My newest post");
		driver.findElement(By.id("body")).sendKeys("This is a post.");
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/form/div[5]/div/button")).click();
		
		String currentMessage = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div/span")).getText();
		screenshot.takeScreenshot(driver, "get-result");
		
		assertTrue(currentMessage.contains("Entry 'My newest post' created successfully."));
	}
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("localhost:5000");
		
		screenshot = new ScreenshotTaker(); 
	}

	@After
	public void tearDown() {
  		driver.get("http://localhost:5000/admin/entry/");
  		driver.findElement(By.xpath("/html/body/div/table/thead/tr/th[8]/a")).click();
  		screenshot.takeScreenshot(driver, "get-admin-entry");
 		driver.findElement(By.xpath("/html/body/div/table/tbody/tr[1]/td[2]/form/button/i")).click();
  		
  		WebDriverWait wait = new WebDriverWait(driver, 10);
 		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
 		alert.accept();
 		
 		WebDriverWait waitForMessage = new WebDriverWait(driver, 10);
		waitForMessage.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[2]")));
		screenshot.takeScreenshot(driver, "deleted-admin-entry");
		
		driver.quit();
	}
}

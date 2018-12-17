package com.effectivetesting.entry;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

import com.effectivetesting.loader.PropertyFileLoader;
import com.effectivetesting.pageobject.LoginPageObject;

public class TestComment {
	private PropertyFileLoader dataLoader;
	private Map<String, String> testEntry;
	private Map<String, String> testCredentials;
	private Map<String, String> testComment;
	private WebDriver driver;
	private LoginPageObject loginPage;
	
	@Test
	public void commentSuccessfully() {
		loginPage = new LoginPageObject(driver);
		String currentMessage = loginPage
				.login(testCredentials.get("email"), testCredentials.get("pass"))
				.gotoAvailableEntries()
				.openEntry(testEntry.get("name"))
				.comment(testComment.get("name"), testComment.get("email"), testComment.get("message"))
				.getResultMessage();
		
		assertTrue(currentMessage.contains("Success your comment was posted."));
	}
	
	@Before
	public void setUp() {
		dataLoader = new PropertyFileLoader();
		
		List<String> credentialParams = new ArrayList<String>();
		credentialParams.add("admin_credentials.properties");
		credentialParams.add("email");
		credentialParams.add("pass");
		
		List<String> entryParams = new ArrayList<String>();
		entryParams.add("create_entry.properties");
		entryParams.add("name");
		entryParams.add("body");

		List<String> commentParams = new ArrayList<String>();
		commentParams.add("comment.properties");
		commentParams.add("name");
		commentParams.add("email");
		commentParams.add("message");
		
		testCredentials = dataLoader.getTestData(credentialParams);
		testEntry = dataLoader.getTestData(entryParams);
		testComment = dataLoader.getTestData(commentParams);
		
//		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "/opt/chromedriver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("localhost:5000");
		
		loginPage = new LoginPageObject(driver);
		loginPage
			.login(testCredentials.get("email"), testCredentials.get("pass"))
			.goToCreateEntry()
			.createEntry(testEntry.get("name"),testEntry.get("body"));
		
		driver.get("localhost:5000/logout");
	}
	
	@After
	public void teardDown() {
		driver.get("http://localhost:5000/admin/entry/");
		driver.findElement(By.xpath("/html/body/div/table/thead/tr/th[8]/a")).click();
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr[1]/td[2]/form/button")).click();
		
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		   
	    alert.accept();
	    
	    WebDriverWait waitForMessage = new WebDriverWait(driver, 10);
	    waitForMessage.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[2]")));
	    
	    driver.quit();
	}
}

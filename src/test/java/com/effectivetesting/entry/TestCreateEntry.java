package com.effectivetesting.entry;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.effectivetesting.pageobject.AdminEntryPageObject;
import com.effectivetesting.pageobject.AdminHomePage;
import com.effectivetesting.pageobject.LoginPageObject;

public class TestCreateEntry {
	private WebDriver driver;
	private LoginPageObject loginPage;
	
	@Test
	public void postIsSuccessfull() {
		loginPage = new LoginPageObject(driver);
		
		String currentMessage = loginPage
									.login("admin1@gmail.com", "admin1")
									.goToCreateEntry()
									.createEntry("My newest post", "This is a post.")
									.getResultMessage();
		
		assertTrue(currentMessage.contains("Entry 'My newest post' created successfully."));
	}
	
	@Test
	public void textRequired() {
		loginPage = new LoginPageObject(driver);
	
		String currentMessage = loginPage
									.login("admin1@gmail.com", "admin1")
									.goToCreateEntry()
									.createEntry("", "This is a post.")
									.getErrorMessage();
		
		assertTrue(currentMessage.contains("This field is required."));
	}
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("localhost:5000");
	}

	@After
	public void teardDown() {
		driver.get("http://localhost:5000/admin/entry/");
		
		AdminHomePage adminHomePage = new AdminHomePage(driver);
		AdminEntryPageObject adminEntryPage = adminHomePage.goToEntrySection();
		
		if(adminEntryPage.registryExists()) {
			adminEntryPage.deleteFirstEntry();
		}
		
	    driver.quit();
	}
}

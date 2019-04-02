package com.effectivetesting.entry;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.effectivetesting.pageobject.AdminHomePageObject;
import com.effectivetesting.pageobject.LoginPageObject;

public class TestCreateEntry {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private AdminHomePageObject adminHomePage;
	
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
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("localhost:5000");
	}

	@After
	public void teardDown() {
		driver.get("http://localhost:5000/admin");
		
		adminHomePage = new AdminHomePageObject(driver);
		adminHomePage
			.goToEntrySection()
			.deleteEntry("My newest post");
	    
	    driver.quit();
	}
}

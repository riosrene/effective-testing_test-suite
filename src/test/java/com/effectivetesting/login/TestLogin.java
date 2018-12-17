package com.effectivetesting.login;

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

import com.effectivetesting.loader.CsvFileLoader;
import com.effectivetesting.loader.PropertyFileLoader;
import com.effectivetesting.pageobject.LoginPageObject;

public class TestLogin {
	private WebDriver driver;
	private CsvFileLoader csvLoader;
	private Map<String, String> testData;
	private LoginPageObject loginPage;
	
	@Test
	public void postIsSuccessfull() {
		loginPage = new LoginPageObject(driver);
		String currentMessage = loginPage
				.login(testData.get("email"), testData.get("pass"))
				.toString();
	}
	
	@Before
	public void setUp() {
		csvLoader = new CsvFileLoader();
		List<String> csvParams = new ArrayList<String>();
		csvParams.add("users.csv");
		csvParams.add("email");
		csvParams.add("pass");
		testData = csvLoader.getTestData(csvParams);

//		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "/opt/chromedriver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("localhost:5000");
	}
	
	@After
	public void teardDown() {
	    driver.quit();
	}
}

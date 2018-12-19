package com.effectivetesting.entry;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.effectivetesting.loader.PropertyFileLoader;
import com.effectivetesting.pageobject.LoginPageObject;

public class TestCreateEntry {
	private PropertyFileLoader dataLoader;
	private Map<String, String> testData;
	private Map<String, String> testCredentials;
	private WebDriver driver;
	private LoginPageObject loginPage;
	
	final static Logger logger = Logger.getLogger(TestCreateEntry.class);
	
	@Rule 
	public TestName name = new TestName();
	
	@Test
	public void postIsSuccessfull() {
		logger.info("Starting Test Case: " + name.getMethodName());
		
		loginPage = new LoginPageObject(driver);
		String currentMessage = loginPage
				.login(testCredentials.get("email"), testCredentials.get("pass"))
				.goToCreateEntry()
				.createEntry(testData.get("name"),testData.get("body"))
				.getResultMessage();
		
		logger.info("Asserting operation: " + currentMessage);
		assertTrue(currentMessage.contains("Entry '" + testData.get("name") + "' created successfully."));
	}
	
	@Before
	public void setUp() {
		dataLoader = new PropertyFileLoader();
		
		List<String> credentialParams = new ArrayList<String>();
		credentialParams.add("admin_credentials.properties");
		credentialParams.add("email");
		credentialParams.add("pass");
		
		List<String> testParams = new ArrayList<String>();
		testParams.add("create_entry.properties");
		testParams.add("name");
		testParams.add("body");
		
		testCredentials = dataLoader.getTestData(credentialParams);
		logger.info("Credentials to be used: " + credentialParams.get(1) + "--> " + testCredentials.get("email"));
		logger.info("Credentials to be used: " + credentialParams.get(2) + "--> " + testCredentials.get("pass"));

		testData = dataLoader.getTestData(testParams);
		logger.info("Entry to be used: " + testParams.get(1) + "--> " + testData.get("name"));
		logger.info("Entry to be used: " + testParams.get(2) + "--> " + testData.get("body"));
		
		logger.info("WebDriver information: ");
//		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "/opt/chromedriver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		String url = "localhost:5000";
		logger.info("Opening environment URL: " + url);
		driver.get(url);
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

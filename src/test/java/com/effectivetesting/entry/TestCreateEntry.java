package com.effectivetesting.entry;

import static io.restassured.RestAssured.delete;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.effectivetesting.entities.User;
import com.effectivetesting.pageobject.LoginPageObject;

public class TestCreateEntry {
	private static final String DEFAULT_BASE_URL = "http://localhost:5000/api";
	private static final String ID = "23";
	
	private WebDriver driver;
	private LoginPageObject loginPage;
	
	@Test
	public void postIsSuccessfull() {
		loginPage = new LoginPageObject(driver);
		String currentMessage = loginPage
				.login("userx@gmail.com", "userx")
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
		
		User user = createTestUser();
		
		given()
			.contentType("application/json")
			.body(user)
		
		.when()
			.post(DEFAULT_BASE_URL + "/user");
	}

	@After
	public void teardDown() {
		@SuppressWarnings("rawtypes")
		ArrayList entryID = given()
						.contentType("application/json")
					
					.when()
						.get(DEFAULT_BASE_URL + "/entry")
					
					.then()
						.extract()
						.path("objects.id");
					
		delete(DEFAULT_BASE_URL + "/entry/" + entryID.get(entryID.size() - 1));
		delete(DEFAULT_BASE_URL + "/user/" + ID);
		
	    driver.quit();
	}
	
	private User createTestUser() {

		User user = new User();

		user.setId(ID);
		user.setEmail("userx@gmail.com");
		user.setpassword_hash("userx");
		user.setName("John Doe");
		
		return user;

	}
}

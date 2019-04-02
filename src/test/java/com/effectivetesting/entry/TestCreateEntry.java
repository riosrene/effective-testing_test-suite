package com.effectivetesting.entry;

import static io.restassured.RestAssured.delete;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.effectivetesting.entities.User;
import com.effectivetesting.helpers.UserHelper;
import com.effectivetesting.pageobject.LoginPageObject;

import io.restassured.path.json.JsonPath;

public class TestCreateEntry {
	private static final String DEFAULT_BASE_URL = "http://localhost:5000/api";
	private WebDriver driver;
	private LoginPageObject loginPage;
	private String userID;
	private User user;
	
	@Before
	public void setUp() {
		UserHelper userHelper = new UserHelper();
		userID = "99";
		user = userHelper.createTestUser(userID);
		
		given()
			.contentType("application/json")
			.body(user)
		.when().post(DEFAULT_BASE_URL + "/user");

		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("localhost:5000");
	}
	
	@Test
	public void postIsSuccessfull() {
		loginPage = new LoginPageObject(driver);
		String mail = user.getEmail();
		String pass = user.getpassword_hash();
		
		String currentMessage = loginPage
				.login(mail, pass)
				.goToCreateEntry()
				.createEntry("My newest post", "This is a post.")
				.getResultMessage();
		
		assertTrue(currentMessage.contains("Entry 'My newest post' created successfully."));
	}

	@After
	public void teardDown() {
        JsonPath jsonPath = given()
				.contentType("application/json")
				
				.when()
					.get(DEFAULT_BASE_URL + "/api/entry")
				
                .thenReturn().jsonPath();

        System.out.println(jsonPath.getString(String.format("%s", "objects.id")));
        System.out.println(jsonPath.getString(String.format("%s", "objects.title")));
		
		
		//delete(DEFAULT_BASE_URL + "/api/entry/" + entryID.get(entryID.size() - 1));

		delete(DEFAULT_BASE_URL + "/user/" + userID);
		
	    driver.quit();
	}
}

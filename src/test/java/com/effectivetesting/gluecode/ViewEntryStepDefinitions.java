package com.effectivetesting.gluecode;

import static com.github.restdriver.serverdriver.RestServerDriver.body;
import static com.github.restdriver.serverdriver.RestServerDriver.delete;
import static com.github.restdriver.serverdriver.RestServerDriver.post;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.effectivetesting.common.EntityHelper;
import com.effectivetesting.entities.Entry;
import com.effectivetesting.entities.User;
import com.effectivetesting.pageobject.LoginPageObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.restdriver.serverdriver.http.response.Response;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dada;
import cucumber.api.java.es.Entonces;

public class ViewEntryStepDefinitions {
	private static final String USER_ID = "99";
	private static final String ENTRY_ID = "99";
	private static final String DEFAULT_BASE_URL = "http://localhost:5000";
	private WebDriver driver;
	private LoginPageObject loginPage;
	private String email = "userx@gmail.com";
	private String password = "userx";
	private String availableEntries;
	
	@Before
	public void setUp() throws JsonProcessingException {
		User user = EntityHelper.createTestUser(USER_ID, "John Doe", email, password);
		ObjectMapper mapper = new ObjectMapper();
		
		String jsonInString = mapper.writeValueAsString(user);
		
		post(DEFAULT_BASE_URL + "/api/user", body(jsonInString, "application/json"));
		
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(DEFAULT_BASE_URL);
	}
	
	@Dada("^la entrada \"([^\"]*)\" con el texto \"([^\"]*)\"$")
	public void la_entrada_con_el_texto(String title, String body) throws Throwable {
		Entry entry = EntityHelper.createTestEntry(99, 99, title, body, title.replace(" ", "-"), 0);
		ObjectMapper mapper = new ObjectMapper();
		
		String jsonInString = mapper.writeValueAsString(entry);
		
		System.out.println("Injected entry:\n" + jsonInString);
		Response response = post(DEFAULT_BASE_URL + "/api/entry", body(jsonInString, "application/json"));
		System.out.println("Response status: " + response.getStatusCode());
	}

	@Cuando("^el usuario ingresa a la sección de entradas$")
	public void el_usuario_ingresa_a_la_sección_de_entradas() throws Throwable {
	    loginPage = new LoginPageObject(driver);
	    availableEntries = loginPage
								.login(email, password)
								.goToEntryList()
								.getAvailableEntries();
	}

	@Entonces("^obtiene un listado de las entradas realizadas conteniendo la entrada \"([^\"]*)\"$")
	public void obtiene_un_listado_de_las_entradas_realizadas_conteniendo_la_entrada(String expectedEntry) throws Throwable {
		System.out.println("Available Entries:\n" + availableEntries);
		Assert.assertTrue(availableEntries.contains(expectedEntry));
	}
	

	@After
	public void tearDown() {
		driver.quit();
		delete(DEFAULT_BASE_URL + "/api/user/" + USER_ID);
		delete(DEFAULT_BASE_URL + "/api/user/" + ENTRY_ID);
	}
}

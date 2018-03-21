package com.effectivetesting.user;

import static io.restassured.RestAssured.delete;
import static io.restassured.RestAssured.given;

import org.junit.After;
import org.junit.Test;

import com.effectivetesting.helpers.UserHelper;

public class TestCreateUser {
	private static final String DEFAULT_BASE_URL = "http://localhost:5000/api";
	private static final String ID = "23";
	
	@Test
	public void postUser() {
		UserHelper userHelper = new UserHelper();
		
        given()
        	.contentType("application/json")
        	.body(userHelper.createTestUser(ID))
        	
        .when()
    		.post(DEFAULT_BASE_URL + "/user")
        	
    	.then()
    		.statusCode(201);
	}

    @After
    public void tearDown() {
        delete(DEFAULT_BASE_URL + "/user/" + ID);
    }
	

}

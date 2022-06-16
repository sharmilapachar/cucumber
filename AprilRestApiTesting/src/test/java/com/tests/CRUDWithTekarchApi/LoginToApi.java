package com.tests.CRUDWithTekarchApi;

import java.io.IOException;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LoginToApi {
	
	@Test
	
	public static void loginToTekarchApi() throws IOException {
		Response res=  RestAssured.given().contentType(ContentType.JSON)
				.body("{\"username\":\"Sharmila.pachar64@ta.com\",\"password\":\"Sharmila.pachar64@123\"}")
             	.when()
				.post(" https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/login");
			
				res.then().statusCode(201);
		res.then().extract().body().asString();
		res.body().prettyPrint();
		String userId=res.body().jsonPath().getString("[0].userid");
		String token=res.body().jsonPath().getString("[0].token");
		System.out.println("USER ID ="+userId);
		System.out.println("TOKEN ="+token);
		
	}
}

package com.tests.CRUDWithTekarchApi;


import java.io.IOException;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//import com.test.constants.Endpoints;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class GetUser {
	
	//@BeforeClass
	//public static void init() {
		//RestAssured.baseURI ="https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net";
	//}
	@Test
	public static String loginToTekarchApi() {
		Response response=RestAssured.
				given().contentType("application/json").
				body("{\"username\":\"Sharmila.pachar64@ta.com\",\"password\":\"Sharmila.pachar64@123\"}").
				when().
				post("https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/login");
response.prettyPrint();

		String token=response.body().jsonPath().get("[0].token");
		System.out.println("="+token);
	
		return token;
	}
	@Test
	public static void getUserData() throws IOException {
		
		
		Header header = new Header("token",loginToTekarchApi());
		Response response = RestAssured.given().header(header)
				.when().get("https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/getdata");
		
		//response.then().log().all();
		response.then().statusCode(200);
		//response.then().extract().body().asString();
		//response.body().prettyPrint();
		
		String accnum=response.jsonPath().get("[0].accountno");
		System.out.println("USER acc ="+accnum);
		//System.out.println("TOKEN ="+token);
	
		
		System.out.println("number of records="+response.jsonPath().get("$.size()"));
		String userId = response.jsonPath().get("[0].userid");
		String id=response.jsonPath().get("[0].id");
		System.out.println("salary="+response.jsonPath().get("[0].salary"));
		System.out.println("first entry userdata userid is= " +userId );
		System.out.println("first entry userdata id is= " +id);
		
		
	}}






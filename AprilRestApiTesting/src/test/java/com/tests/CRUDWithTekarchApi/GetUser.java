package com.tests.CRUDWithTekarchApi;


import java.io.IOException;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//import com.test.constants.Endpoints;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class GetUser {
	
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
		System.out.println("valuse of header :"+response.header("header"));
		System.out.println("res body :"+response.then().extract().body().asString());
		String accnum=response.jsonPath().get("[0].accountno");
		System.out.println("USER acc ="+accnum);
		//System.out.println("TOKEN ="+token);
	String s=response.then(). extract().body().asString();
	System.out.println(s);
		
		System.out.println("number of records="+response.jsonPath().get("$.size()"));
		//String userId = response.jsonPath().get("[0].userid");
		String id=response.jsonPath().get("[0].id");
		System.out.println("salary="+response.jsonPath().get("[0].salary"));
		Assert.assertEquals(response.jsonPath().get("[0].salary"),"655");
		System.out.println(response.header(id));
		//System.out.println("first entry userdata userid is= " +userId);
		//System.out.println("first entry userdata id is= " +id);
		
		
	}
	@Test
	public static void updateUserData() throws IOException {
		// convert json to string online https://tools.knowledgewalls.com/json-to-string
		Header header = new Header("token", loginToTekarchApi());
		Response response = RestAssured.given().contentType("application/json").header(header)
				.body("{\"accountno\":\"TA-SP11111\",\"departmentno\":\"109\",\"salary\":\"655\",\"pincode\":\"654321\",\"userid\":\"mU6hIQUZQfsauAPg6TXX\",\"id\":\"B67ZhJfdsS5o7Uzri8uU\"}")
				//.when().log().all()
				.when().put(" https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/updateData");
		//response.then().log().all();
		//response.then().statusCode(200);
		String status = response.jsonPath().get("status");
	
		System.out.println("UPDATE STATUS ="+status);
		Assert.assertEquals(status, "success");
		Assert.assertEquals(response.statusCode(), 200);
		//Assert.assertEquals(response.header("contentType"), "application/json");
	}
	}






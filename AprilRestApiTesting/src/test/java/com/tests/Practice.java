package com.tests;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
public class Practice {
	static String id;
	@Test(priority=3)
	
	
	public static void test1() throws IOException {
		//Header header = new Header("id",id);
		Response res=RestAssured.given().contentType(ContentType.JSON).
				when().get("https://reqres.in/api/users/2");
				//res.then().statusCode(200)
		String s=res.getHeader("Content-Type");
		System.out.println("header is :"+s);
	
				res.then().log().all();
		
	}
	@Test(priority=1)
	
	void create() {
		HashMap data=new HashMap();
		data.put("name","pp");
		data.put("job","trainer");
				
		Response res=RestAssured.given().contentType(ContentType.JSON).body(data)
				.when().post("https://reqres.in/api/users");
		res.then().statusCode(201)
		.log().all();
		id=res.jsonPath().get("id");
		System.out.println("id="+id);
		
	}
	@Test(priority=2)
	public static void update() throws IOException {
		//Header header = new Header("id",id);
		HashMap data=new HashMap();
		data.put("name","io");
		data.put("job","kl");
		Response res=RestAssured.given().contentType(ContentType.JSON).body(data).
				when().put("https://reqres.in/api/users/"+id);
				res.then().statusCode(200);
				res.then().log().all();
				
				System.out.println("id="+id);
}
}
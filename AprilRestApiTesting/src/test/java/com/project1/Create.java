package com.project1;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Create {
	@Test
	public static void create()throws IOException{ 
		Pojo12 pp=new Pojo12();
		pp.setAge("23");
		pp.setId("25");
		pp.setSalary("123");
		pp.setName("test");
		
Response res= RestAssured.given()     .contentType("application/json").body("pp")
.when().post("https://dummy.restapiexample.com/api/v1/create");
	res.then(). statusCode(200);
	String s=res.then().extract().body().asString();
	System.out.println(s);
	
}}


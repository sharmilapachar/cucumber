package com.project1;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetData11 {
	//static String token1;
	@Test
	public static void getdata()throws IOException{
Response res= RestAssured.given().contentType("aplication/json")
.when().get("https://dummy.restapiexample.com/api/v1/employees");
//res.then().statusCode(200);
//int status= res.getStatusCode();
//System.out.println("status code is:"+status);
//Pojo11[] pp= res.as(Pojo11[].class);
//pojo11[] pp=res.as(Pojo[].class);
//System.out.println("records="+pp.length);
String id=res.jsonPath().get([1].id);
System.out.println(id);
//System.out.println("number of records="+res.jsonPath().get("[0].id"));


}
}

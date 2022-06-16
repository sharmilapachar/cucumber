package com.tests;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestWithSimpleRest {
@Test(enabled=false)
public static void getFlightdata() {
	RestAssured
	.given()
	.when()
	.get("http://ilt.mulesoft-training.com/essentials/united/flights")
	.then()
	.contentType(ContentType.JSON)
	.statusCode(200)
	.time(Matchers.lessThan(5000l));
	
}
@Test
public static void getFlightdata1() {
	RequestSpecification req=RestAssured.given();
	Response response=req.when()
	.get("http://ilt.mulesoft-training.com/essentials/united/flights");
	response.then()
	.contentType(ContentType.JSON)
	.statusCode(200)
	.time(Matchers.lessThan(5000l));
	response.body().prettyPrint();
	String planetype=response.jsonPath().get("flights[0].planeType");
	System.out.println("plane type=="+planetype);
	
}
}

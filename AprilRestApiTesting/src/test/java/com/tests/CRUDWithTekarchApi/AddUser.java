package com.tests.CRUDWithTekarchApi;

	import java.io.IOException;

import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;
	import io.restassured.RestAssured;
	import io.restassured.http.Header;
	import io.restassured.response.Response;

	public class AddUser {
		//@BeforeClass
		//public static void init() {
			//RestAssured.baseURI ="https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net";
		//}
		
		public static String loginToTekarchApi() {
			Response response=RestAssured.
					given().contentType("application/json").
					body("{\"username\":\"Sharmila.pachar64@ta.com\",\"password\":\"Sharmila.pachar64@123\"}").
					when().
					post(" https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/login");
			String token=response.body().jsonPath().getString("[0].token");
			return token;
		}
		@Test
		public static void addUserData() throws IOException {
			// convert json to string online https://tools.knowledgewalls.com/json-to-string
			Header header = new Header("token", loginToTekarchApi());
			Response response = RestAssured.given().contentType("application/json").header(header)
					.body("{\"accountno\":\"TA-SP11111\",\"departmentno\":\"13\",\"salary\":\"655\",\"pincode\":\"654321\"}")
					//.when().log().all()
					.when().post(" https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/addData");
			//response.then().log().all();
			response.then().statusCode(201);
		
				String h=	response.header("header");
			System.out.println("value of header : "+h);
			String status = response.jsonPath().get("status");
		
			System.out.println("STATUS ="+status);
			System.out.println(response.body().asString());
		//response.body()
			//AssertJUnit.assertEquals(status, "success");
			Assert.assertEquals(status, "success");
		}

	}


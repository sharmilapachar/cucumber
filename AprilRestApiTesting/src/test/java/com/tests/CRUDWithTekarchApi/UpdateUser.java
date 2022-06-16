package com.tests.CRUDWithTekarchApi;

	import java.io.IOException;

	//import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;
	import io.restassured.RestAssured;
	import io.restassured.http.Header;
	import io.restassured.response.Response;

	public class UpdateUser {
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
			System.out.println("token generated is="+token);
			return token;
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
			response.then().statusCode(200);
			String status = response.jsonPath().get("status");
			
			System.out.println("UPDATE STATUS ="+status);
			//AssertJUnit.assertEquals(status, "success");
		}

	}




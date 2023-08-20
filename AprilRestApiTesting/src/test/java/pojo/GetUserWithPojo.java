package pojo;

import java.io.IOException;

//import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;


public class GetUserWithPojo {
	static String token1;
	
	
	public static void loginToTekarchApi() {
		Response response=RestAssured.
				given().contentType("application/json").
				body("{\"username\":\"Sharmila.pachar64@ta.com\",\"password\":\"Sharmila.pachar64@123\"}").
				when().
				post(" https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/login");
		 token1=response.body().jsonPath().getString("[0].token");
		 System.out.println("token="+token1);
		//return token;
	}
	@Test
	public static void getUserDataWithPojo() throws IOException {
		
		if(token1==null) {
			loginToTekarchApi();}
		
		Header header = new Header("token",token1);
		Response response = RestAssured.given().contentType("application/json").header(header)
				
			.log().all()
				.when().get(" https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/getdata");
		response.then().log().cookies();
		UserpojoNew[] listOfUsers=response.as(UserpojoNew[].class);// DESERILIZATION
		System.out.println("records="+listOfUsers.length);
		System.out.println(listOfUsers[0].getSalary());
		response.then().statusCode(200);
		String accNumber=response.jsonPath().get("[0].accountno");
		System.out.println("ACCOUNTNO.="+accNumber);
		
	}

}








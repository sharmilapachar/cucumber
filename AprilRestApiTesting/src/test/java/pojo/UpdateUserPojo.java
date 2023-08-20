package pojo;
import java.io.IOException;

import org.testng.AssertJUnit;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class UpdateUserPojo {
	static String token1;
	//@BeforeClass
	//public static void init() {
		//RestAssured.baseURI ="https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net";
	//}
	
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
	public static void updateUserDataWithPojo() throws IOException {
		if(token1==null) {
			loginToTekarchApi();}
		UserpojoNew obj =new UserpojoNew();
		obj.setAccountno("TA-SP11111");
		obj.setDepartmentno("1111");
		obj.setPincode("654321");
		obj.setSalary("655");
		obj.setUserid("mU6hIQUZQfsauAPg6TXX");
		obj.setId("FZdbmZ3DmmCUWb4MhKue");
		
		Header header = new Header("token",token1);
		Response response = RestAssured.given().contentType("application/json").header(header)
				.body(obj)
				.when().log().all()
				.when().put(" https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/updateData");
		response.then().log().all();
		response.then().statusCode(200);
		String status = response.jsonPath().get("status");
	
		System.out.println("STATUS ="+status);
	
		AssertJUnit.assertEquals(status, "success");
		
	}

}






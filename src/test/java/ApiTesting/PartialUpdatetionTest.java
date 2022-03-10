package ApiTesting;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PartialUpdatetionTest {

	@Test
	public void update() {
		JSONObject obj	=new JSONObject();
		obj.put("name", "sudarshan");
		obj.put("job", "TE");
		
		RequestSpecification response = RestAssured.given();
		response.body(obj);
		response.contentType(ContentType.JSON);
		
		Response response1 = response.patch("https://reqres.in/api/users/2");
		
		System.out.println(response1.getContentType());
		
		ValidatableResponse validate = response1.then();
		validate.log().all();
	}
	
	
}

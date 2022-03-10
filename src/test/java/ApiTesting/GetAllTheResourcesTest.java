package ApiTesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetAllTheResourcesTest {

	@Test
	public void GetResource() {
		Response response = RestAssured.get("http://localhost:8084/projects");
		
		System.out.println(response.getContentType());
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody());
		System.out.println(response.getHeader("vary"));
		
//		response.prettyPrint();
//		response.prettyPeek();
//		System.out.println(response.asString());
		
		ValidatableResponse validate = response.then();
		validate.log().all();
	}
	
}

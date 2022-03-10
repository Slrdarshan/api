package ApiTesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DeleteResourceTest {

	@Test
	public void Delete()  {
		
		Response response = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_1404");
		
		ValidatableResponse validate = response.then();
		validate.assertThat().statusCode(204);
		validate.log().all();
		
		
	}
	
	
	
}

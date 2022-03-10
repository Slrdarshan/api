package EndToEndTesting;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RequestChaining {

	@Test
	public void chaining() {
		Response res = when()
		 .get("http://localhost:8084/projects");
		
		String proId = res.jsonPath().get("[0].projectId");
		
		given()
			.pathParam("ProjectID", proId)
		.when()
		   .delete("http://localhost:8084/projects/{ProjectID}")
		.then()
			.assertThat().statusCode(204)
			.log().all();
		
		
		
	}
	
	
	
	
}

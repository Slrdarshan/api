package rngyantra.com;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteResourcesTest {

	@Test
	public void DeleteResource() {
		
		given()
		 .delete("http://localhost:8084/projects/TY_PROJ_2204")
		
		.then()
		  .assertThat().statusCode(204);
	}
	
	
	
	
}

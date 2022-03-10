package rngyantra.com;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponseValidation {

	@Test
	public void staticValidation() {
		
		String exceptedProjectId = "TY_PROJ_1802";
		
	  Response res = when()
	   		.get("http://localhost:8084/projects");
	  String actualId = res.jsonPath().get("[1].projectId");
	  
	  System.out.println(actualId);
	  
	  res.then()
	  		.assertThat().statusCode(200)
	  		.contentType(ContentType.JSON)
	  		.log().all();
		
		Assert.assertEquals(exceptedProjectId, actualId);
		
	}
	
}

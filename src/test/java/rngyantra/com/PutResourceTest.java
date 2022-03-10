package rngyantra.com;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PutResourceTest {

	@Test
	public void putResource() {
		
		JSONObject obj=new JSONObject();
		obj.put("createdBy", "slr");
		obj.put("projectName", "SLR1");
		obj.put("status", "completed");
		obj.put("teamSize", 2);
		
	   given()
	   		.contentType(ContentType.JSON)
	   		.body(obj)
	   		
	   .when()
	   		.put("http://localhost:8084/projects/TY_PROJ_30")
	   		
	   .then()
	   		.assertThat().contentType(ContentType.JSON)
	   		.assertThat().statusCode(200)
	   		.log().all();
		
		
	}
	
	
	
	
}

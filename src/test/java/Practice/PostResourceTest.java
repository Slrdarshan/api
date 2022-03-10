package Practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostResourceTest {
	
	@Test
	public void postResource() {
		
		JSONObject obj=new JSONObject();
		obj.put("createdBy", "slr");
		obj.put("projectName", "SLR10");
		obj.put("status", "completed");
		obj.put("teamSize", 2);
		
		given()
		  .contentType(ContentType.JSON)
		  .body(obj)
		  
		.when()
		 .post("http://localhost:8084/addProject")
		 
		 .then()
		   .assertThat().statusCode(201)
		   .assertThat().contentType(ContentType.JSON)
		  .log().all();		
		
	}

}

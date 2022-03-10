package rngyantra.com;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PatchResourcesTest {

	@Test
	public void patchResource() {
		
		
		JSONObject obj=new JSONObject();
		
		   obj.put("name", "morpheus");
		    obj.put("job", "zion resident");
		
		    given()
               .contentType(ContentType.JSON)
               .body(obj)
               
		    .when()
		       .patch("https://reqres.in/api/users/2")
		       
		    .then()
		      .assertThat().contentType(ContentType.JSON)
		      .assertThat().statusCode(200)
		      .log().all();
		    
		    
		
	}
	
}

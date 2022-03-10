package Practice;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateJsonObjectUsingHashMapTest {
	
	@Test
	public void creatFile() {
		
		
		HashMap hs=new HashMap();
			  hs.put("createdBy", "manju");
			  hs.put("projectName", "mugali");
			  hs.put("status", "On Going");
			  hs.put("teamSize", 2);
			
		
		given()
			
			.contentType(ContentType.JSON)
			.body(hs)
			
		.when()
			.post("http://localhost:8084/addProject")

		.then()
			.assertThat().contentType(ContentType.JSON)
			.assertThat().statusCode(201)
			.log().all();
			}
	
	

}

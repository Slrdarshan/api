package rngyantra.com;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class JsonObjectUsingFileTest {
	
	
	@Test
	public void createdFile() {
		
		File file = new File("./src/test/resources/data.json");
		
		given()
			.body(file)
			.contentType(ContentType.JSON)
			
		.when()
		    .post("http://localhost:8084/addProject")
		    
		.then()
		    .assertThat().contentType(ContentType.JSON)
		    .assertThat().statusCode(201)
		    .log().all();
		
	}

}

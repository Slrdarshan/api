package rngyantra.com;

import org.testng.annotations.Test;

import com.mysql.cj.log.Log;

import CommanApitestingProject.Pojo_Library;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PojoImplementationTest {

	@Test
	public void cratePojo() {
		
		Pojo_Library pl=new Pojo_Library("sudarshan","SLR33","SLRProject1","completed",32);
		
	
		
		given()
		   .body(pl)
		   .contentType(ContentType.JSON)
		   
		.when()
		   .post("http://localhost:8084/addProject")
		   
		.then()
		   .assertThat().statusCode(201)
		   .assertThat().contentType(ContentType.JSON)
		   .log().all();
		
	}
	
}

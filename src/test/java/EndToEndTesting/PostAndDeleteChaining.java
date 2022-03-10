package EndToEndTesting;

import org.testng.annotations.Test;

import CommanApitestingProject.Pojo_Library;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

import java.util.List;
import java.util.Random;

public class PostAndDeleteChaining {
	
	
	@Test
	public void createDelete() {
		
		Random no=new Random();
		int randomNo = no.nextInt(1000);
		
		String ProjectName="tyss"+randomNo;
		
		
		Pojo_Library pl=new Pojo_Library("sudarsgan",ProjectName,"fghjk","rtyhujik",4);
		
		Response res = given()
			.body(pl)
			.contentType(ContentType.JSON)
		 .when()
			.post("http://localhost:8084/addProject");
		res.then()
		   .assertThat().statusCode(201)
		   .assertThat().contentType(ContentType.JSON)
		   .log().all();
		
		String proId = res.jsonPath().get("projectId");
		System.out.println(proId);
		
	    given()
	     .pathParam("projectId", proId)
		.when()
			.delete("http://localhost:8084/projects/{projectId}")
		.then()
		    .assertThat().statusCode(204);
		
		
	}
	
	

}

package Practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PutTest {
	
	@Test
	public void put() {
		
		JSONObject obj =new JSONObject();
		obj.put("createdBy", "darshan");
		obj.put("projectName", "SLRBCA");
		obj.put("status","completed");
		obj.put("teamSize", 2);
		
		RequestSpecification res = RestAssured.given();
		res.contentType(ContentType.JSON);
		res.body(obj);
		
		Response r = res.put("http://localhost:8084/projects/TY_PROJ_2003");
		
		ValidatableResponse validate = r.then();
		validate.assertThat().statusCode(200);
		validate.assertThat().contentType(ContentType.JSON);
		
		validate.log().all();
		
	}

}

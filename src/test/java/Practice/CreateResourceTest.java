package Practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateResourceTest {

	@Test
	public void Create() {
		
		JSONObject obj=new JSONObject();
		obj.put("createdBy", "string");
		obj.put("projectName", "string");
		obj.put("status", "string");
		obj.put("teamSize", 0);
		
		RequestSpecification res = RestAssured.given();
		res.contentType(ContentType.JSON);
		res.body(obj);
		
		Response response = res.post("http://localhost:8084/addProject");
		
		ValidatableResponse val = response.then();
		val.assertThat().statusCode(201);
		val.assertThat().contentType(ContentType.JSON);
		
		val.log().all();
		
	}
	
}

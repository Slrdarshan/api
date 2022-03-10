package rngyantra.com;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Iterator;
import java.util.List;

public class CreatingPostRequestAssertion {
	
	@Test
	public void createPost() {
		
		JSONObject js=new JSONObject();
		
	js.put("createdBy", "darshan");
	js.put ("projectName", "Tyss420");
	js.put  ("status", "completed");
	js.put  ("teamSize", 2);
	
	String expProjName = "Tyss420";

	given()
		.body(js)
        .contentType(ContentType.JSON);
	
	Response res =post("http://localhost:8084/addProject");
	
	
	res.then().log().all();
		
	 Object actprojectName = res.jsonPath().get("projectName");

	 Assert.assertEquals(actprojectName, expProjName);
	 
	
	}
	
	}
	
	
	



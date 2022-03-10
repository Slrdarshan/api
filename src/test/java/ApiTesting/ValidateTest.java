package ApiTesting;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class ValidateTest {

	@Test
	public void Validate() {
		
		JSONObject obj=new JSONObject();
		obj.put("createdBy","sudarshan");
		obj.put("projectName","volly");
		obj.put("status","completed");
		obj.put("teamSize",200);
		
		RequestSpecification resounse = RestAssured.given();
		 resounse.contentType(ContentType.JSON);
		 resounse.body(obj);
		 
		 Response response1 = resounse.put("http://localhost:8084/projects/TY_PROJ_1404");
		 
		 ValidatableResponse validate = response1.then();
		 validate.assertThat().statusCode(200);
		 validate.assertThat().contentType(ContentType.JSON);
		 
		 validate.log().all();
		
	}
	
	
}

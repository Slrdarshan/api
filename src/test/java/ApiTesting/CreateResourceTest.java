package ApiTesting;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateResourceTest {

	@Test
	public void create() {
	JSONObject obj=new JSONObject();
	obj.put("createdBy","sudarshan");
	obj.put("projectName","vollyball");
	obj.put("status","completed");
	obj.put("teamSize",200);
	
 RequestSpecification resounse = RestAssured.given();
 resounse.contentType(ContentType.JSON);
 resounse.body(obj);
 
 Response response1 = resounse.post("http://localhost:8084/addProject");
 
 ValidatableResponse validate = response1.then();
 validate.assertThat().statusCode(201);
 validate.assertThat().contentType(ContentType.JSON);
 
 validate.log().all();
 
	
	}
}

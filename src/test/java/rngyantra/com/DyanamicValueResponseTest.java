package rngyantra.com;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DyanamicValueResponseTest {

	@Test
	public void dyanamicValueTest() {
		
		String exceptedProjectId = "TY_PROJ_1405";
		Response res = when()
			.get("http://localhost:8084/projects");
		List<String> actualProjectId = res.jsonPath().get("projectId");
		boolean flag=false;
		for(String proid:actualProjectId) {
			if(proid.equalsIgnoreCase(exceptedProjectId)) {
				System.out.println("value is matching");
				flag=true;
			}
		}
		Assert.assertEquals(flag, true);
		//Assert.assertTrue(flag);
		
		
	}
	
	
}

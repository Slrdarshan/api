package rngyantra.com;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSender;

import static io.restassured.RestAssured.*;

public class HeaderValidationTest {

	@Test
	public void validation() {
		
		String expectedContentType = "application/json";
		String expectedContentValue = "Access-Control-Request-Headers";
		
		Response rs = when()
			.get("http://localhost:8084/projects");
		String actualContentType = rs.getContentType();
		String actualVaryValue = rs.getHeader("vary");
		
		rs.then().log().all();
		
		Assert.assertEquals(expectedContentType, actualContentType);
		Assert.assertEquals(expectedContentValue, actualVaryValue );
		
	}
	
	
}

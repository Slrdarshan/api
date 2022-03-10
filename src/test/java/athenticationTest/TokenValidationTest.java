package athenticationTest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class TokenValidationTest {
	
	@Test
	public void tokenTest() {
		
		given()
		   .auth().oauth2("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")
		.when()
		   .get("https://api.github.com/users/Slrdarshan/repos")
		 .then()
		     .statusCode(200)
		     .log().all();
		
		
	}
	
	
	

}

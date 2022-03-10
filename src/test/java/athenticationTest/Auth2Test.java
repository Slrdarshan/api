package athenticationTest;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Auth2Test {
	@Test
	public void authantication() {
	
	Response res = given()
		.formParam("client_id", "SLR")
	    .formParam("client_secret", "d6daa6e3a962a4931659f448e07b572d")
    	.formParam("grant_type", "client_credentials")
	    .formParam("redirect_uri", "https://example.com")
	.when()
		.post("http://coop.apps.symfonycasts.com/token");
	String token = res.jsonPath().get("access_token");
	System.out.println(token);
	
	given()
		.auth().oauth2(token)
		.pathParam("USER_ID", 2928)
	.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")
	.then()
	    .log().all();
		
	}
	
	

}

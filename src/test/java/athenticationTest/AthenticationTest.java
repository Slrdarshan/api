package athenticationTest;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class AthenticationTest {
	
	@Test
	public void preemptiveAuth() {
		given()
		   .auth().preemptive().basic("rmgyantra", "rmgy@9999")
		.when()
		   .get("http://localhost:8084/login")
		 .then()
		     .log().all();
	}
	
	@Test
	public void digestiveAuth() {
		given()
		   .auth().digest("rmgyantra", "rmgy@9999")
	   .when()
	       .get("http://localhost:8084/login")
	   .then()
	      .log().all();
	}
	
	
	

}

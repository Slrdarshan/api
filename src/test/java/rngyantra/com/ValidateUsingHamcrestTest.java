package rngyantra.com;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class ValidateUsingHamcrestTest {
	
	@Test
	public void validate() {
	    when()
	    	.get("http:localhost:8084/projects")
	    .then()
	    	.assertThat().time(Matchers.lessThan(900L),TimeUnit.MILLISECONDS)
	    	.log().all();
	    
	}

}

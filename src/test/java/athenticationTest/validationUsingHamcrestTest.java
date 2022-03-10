package athenticationTest;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class validationUsingHamcrestTest {
	
   @Test
	public void validate() {
	   
	   when()
	    	.get("http://localhost:8084/projects")
	    .then()
	    	.assertThat().time(Matchers.lessThan(3000L),TimeUnit.MILLISECONDS)
	    	.assertThat().body("[0].projectName", Matchers.equalTo("SLR1"))
	    	.assertThat().contentType(Matchers.equalTo("application/json"))
	    	.log().all();
	   
   }

}

package PathPathParameter;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class MultiParameterTest {
	
	@Test
	public void parameter() {
		given()
		 .pathParam("username", "Slrdarshan")
		 .queryParam("sort", "created")
		 .queryParam("page", "2")
       .when()
       		.get("https://api.github.com/users/{username}/repos")
       .then()
          .assertThat().statusCode(200)
          .log().all();
	}
	
	

}

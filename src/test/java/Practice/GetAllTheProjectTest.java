package Practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllTheProjectTest {
	@Test
	public void GetProject() {
		Response response = RestAssured.get("http://localhost:8084/projects");
		
		//response.prettyPeek();   //this will print all the response including header.
		//response.prettyPrint();   //header parts are not printing
          System.out.println(response.asString());  //this will print all the details in a single line
	}

}

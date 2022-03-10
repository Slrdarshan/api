package EndToEndTesting;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.testng.annotations.Test;

import CommanApitestingProject.Emp_Pojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class TC_02 {
	
	@Test
	public void postAndGet() {
		
		
		Random no=new Random();
		int randomno = no.nextInt(1000);
		// String projectName = "tyss"+randomno;
		 String username="SLR"+randomno;
				 
		 Emp_Pojo pl=new Emp_Pojo("SDET","25/05/1999","paven@gmail.com","nithesh","15","9888777657","pavan","ROLE_ADMIN",username);
	
		  Response res = given()
		   .body(pl)
		   .contentType(ContentType.JSON)
		.when()
		  .post("http://localhost:8084/employees");
	      	
		  res.then()
		     .assertThat().statusCode(201)
		     .assertThat().contentType(ContentType.JSON)
		     .log().body();
		  
		  Object empid = res.jsonPath().get("employeeId");
		  System.out.println(empid);
		  
		   
		  Response response = given()
		   	.pathParam("id", empid)
		  
		  .when()
		    .get("http://localhost:8084/employees/{id}");
		 response.then()
		     .assertThat().statusCode(200)
		     .assertThat().contentType(ContentType.JSON)
		     .log().body();
		
	}

}

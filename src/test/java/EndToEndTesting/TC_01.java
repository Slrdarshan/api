package EndToEndTesting;

import org.testng.annotations.Test;

import CommanApitestingProject.Emp_Pojo;
import CommanApitestingProject.Pojo_Library;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class TC_01 {

	@Test
	public void EndToEndTest() {
		
		Random no=new Random();
		int randomno = no.nextInt(1000);
		 String projectName = "tyss"+randomno;
		 String username="SLR"+randomno;
		
		Pojo_Library pl=new Pojo_Library("sudarsgan",projectName,"fghjk","rtyhujik",4);
		
		Response res = given()
		  .body(pl)
		  .contentType(ContentType.JSON)
		.when()
		  .post("http://localhost:8084/addProject");
		res.then().assertThat().statusCode(201).contentType(ContentType.JSON);
		
		Object proName = res.jsonPath().get("ProjectName");
	//	System.out.println(proName);
		
		
		Emp_Pojo ep=new Emp_Pojo("SDET","25/05/1999","nithesh@gmail.com","nithesh","15","9888777657",proName,"ROLE_ADMIN",username);
		
		Response responce = given()
			.body(ep)
            .contentType(ContentType.JSON)
       .when()
        	.post("http://localhost:8084/employees");
		
		responce.then()
			.log().body()
			.assertThat().statusCode(201)
			.assertThat().contentType(ContentType.JSON);
		
		String unName = responce.jsonPath().get("username");
		String empId = responce.jsonPath().get("employeeId");
		
		System.out.println("userName "+unName+"    empId   "+empId);
		
		
         given()
         	.pathParam("emp", empId)
         .when()
         	.delete("http://localhost:8084/employees/{emp}")
         .then()
         	.assertThat().statusCode(204);
		
	}
	
	
	
}

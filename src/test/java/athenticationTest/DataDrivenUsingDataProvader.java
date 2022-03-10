package athenticationTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommanApitestingProject.Pojo_Library;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DataDrivenUsingDataProvader {
	
	
	@Test(dataProvider = "getData")
	public void dataTest(String createdBy, String projectName, String projectId,String status,int teamSize) {
		
		Pojo_Library pl=new Pojo_Library(createdBy, projectName, projectId, status, teamSize);
	
		given()
		    .body(pl)
		    .contentType(ContentType.JSON)
		.when()
		    .post("http://localhost:8084/addProject")
		.then()
		    .assertThat().statusCode(201)
		    .assertThat().contentType(ContentType.JSON)
		    .log().all();
		
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] objArray=new Object[3][5];
		
		objArray[0][0]="sudarshan";
		objArray[0][1]="aaaaa";
		objArray[0][2]="proId111";
		objArray[0][3]="completed";
		objArray[0][4]=3;
		

		objArray[1][0]="sudarshan";
		objArray[1][1]="bbbbbb";
		objArray[1][2]="proId101";
		objArray[1][3]="completed";
		objArray[1][4]=3;
		

		objArray[2][0]="sudarshan";
		objArray[2][1]="ccccc";
		objArray[2][2]="proId101";
		objArray[2][3]="completed";
		objArray[2][4]=3;
		
		return objArray;
		
	}

}

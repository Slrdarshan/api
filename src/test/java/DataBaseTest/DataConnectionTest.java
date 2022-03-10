package DataBaseTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

import CommanApitestingProject.Pojo_Library;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class DataConnectionTest {	
	@Test
	public void dabaseTest() throws SQLException {
		Random no=new Random();
		int randomno = no.nextInt(1000);
		 String projectName = "tyss"+randomno;
		Pojo_Library pl=new Pojo_Library("sudarsgan",projectName,"fghjk","rtyhujik",4);
		Response res = given()
			.body(pl)
            .contentType(ContentType.JSON)
        .when()
        	.post("http://localhost:8084/addProject");
		res.then()
		   .assertThat().statusCode(201)
		   .assertThat().contentType(ContentType.JSON)
		   .log().body();		
		String proId = res.jsonPath().get("projectId");
		System.out.println(proId);
		System.out.println("<-----------dataBase Test---------->");
		
		String projectId= proId;
	Connection conn = null;
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		System.out.println("----connection is done------");
		Statement stat = conn.createStatement();
		String query = "select * from project";
		ResultSet resultSet = stat.executeQuery(query);
		boolean flag = false;
		while(resultSet.next()) {
			String actualProjectId = resultSet.getString(1);
			if(actualProjectId.equalsIgnoreCase(projectId)) {
				System.out.println(actualProjectId+"   Project is created");
				flag=true;
			}
		}
		Assert.assertTrue(flag);		
			conn.close();
			System.out.println("-----connection is close------");
		}	
	}


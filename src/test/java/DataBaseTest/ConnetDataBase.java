package DataBaseTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class ConnetDataBase {
	
	@Test
	public void test() throws SQLException {
		
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		Statement stat = conn.createStatement();
		String queary = "select * from project";
		ResultSet result = stat.executeQuery(queary);
		while(result.next()) {
			System.out.println(result.getString(1));
		}
		conn.close();
		
	}
	
	

}

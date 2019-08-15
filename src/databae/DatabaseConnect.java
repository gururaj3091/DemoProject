package databae;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DatabaseConnect {
	
	@Test
	public void connectDatabase() throws SQLException, ClassNotFoundException
	{
		String url = "jdbc:mysql://localhost:3306/world";
		String username = "root";
		String password = "welcome";
		String query = "select * from country;";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,username,password);
		
		Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery(query);
		
		while(rs.next())
		{
			String code = rs.getString(1);								        
            String country = rs.getString(2);					                               
            System. out.println(code+"  "+country);
		}
		
		System.out.println("---------------------------");
		
		
		
		con.close();
		
		
	}

}

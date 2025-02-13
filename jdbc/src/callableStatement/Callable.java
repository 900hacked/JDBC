package callableStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Callable {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/schoolregister";
		String user = "root";
		String password = "JavaCommunity2!";
		
		String query = "CREATE PROCEDURE greet_me()\r\n"
				+ "BEGIN\r\n"
				+ "    SELECT * FROM Employee;\r\n"
				+ "END";
		
		try {
			Connection conn = DriverManager.getConnection(url,user,password);
			
			Statement stat = conn.createStatement();
			
			stat.execute(query);
			
			System.out.println("Run Successfully");
		}
		catch(SQLException e) {
			System.out.println("Failed to Run" + e);
		}

	}

}

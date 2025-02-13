package callableStatement;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Statement;

public class Insert {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/schoolregister";
		String user = "root";
		String password = "JavaCommunity2!";
		
		String query ="CREATE PROCEDURE help_him()\r\n"
				+ "BEGIN\r\n"
				+ "    SELECT * FROM Employee;\r\n"
				+ "END";
		
		try {
			Connection conn = DriverManager.getConnection(url,user,password);
			
			Statement stat = conn.createStatement();
			
			stat.execute(query);
			
			System.out.println("Run Successfully");
			
			conn.close();
			stat.close();
		}
		catch(SQLException e) {
			System.out.println("Failed to Run" + e);
		}

	}

}

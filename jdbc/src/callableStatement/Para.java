package callableStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Para {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/schoolregister";
		String user = "root";
		String password = "JavaCommunity2!";
		
		String query = "CALL add_employee(13,'Alicia',7000.0)";
		
		try {
			Connection conn = DriverManager.getConnection(url,user,password);
			
			Statement stat = conn.createStatement();
			
			stat.execute(query);
			
			System.out.println("Run Succesfully");
			
			conn.close();
			stat.close();
		}
		catch(SQLException e) {
			System.out.println("Failed to run" + e);
		}

	}

}

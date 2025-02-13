package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/schoolregister";
		String user = "root";
		String password = "JavaCommunity2!";
		
		String query = "DELETE FROM Employee WHERE EmployeeID = 02";
				
		
		try {
			Connection connection = DriverManager.getConnection(url,user,password);
			
			Statement statement = connection.createStatement();
			
			statement.executeUpdate(query);
			
			System.out.println("Deleted Successfuly");
		}
		catch(SQLException e) {
			System.out.println("Failed to run" + e);
		}

	}

}

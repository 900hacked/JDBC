package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Specific {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/schoolregister";
		String user = "root";
		String password = "JavaCommunity2!";
		
		String query = "SELECT EmployeeID, EmployeeName FROM Employee";
		
		try {
		Connection connection = DriverManager.getConnection(url,user,password);
		
		Statement statement = connection.createStatement();
		
		ResultSet rs = statement.executeQuery(query);
		
		while(rs.next()) {
			int id = rs.getInt("EmployeeID");
			String name = rs.getString("EmployeeName");
			System.out.println("EmployeeID: " + id + ", EmployeeName: " + name);
			
		}
		System.out.println("Run Successfully");
		
		rs.close();
		statement.close();
		connection.close();
		
		
		
		}
		catch(SQLException e) {
			System.out.println("Failed to execute");
		}

	}

}

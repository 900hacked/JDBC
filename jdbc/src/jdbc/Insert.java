package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/schoolregister";
		String user = "root";
		String password = "JavaCommunity2!";
		String query = "INSERT INTO Employee(EmployeeID,EmployeeName,Salary)"
				+ "VALUES"
				+"(01,'Hashim',500000),"
				+"(02,'Muhammed',700000),"
				+"(03,'Salim',1000000),"
				+"(04,'Nathan',2000000)";
				
		
		try {
			Connection connection = DriverManager.getConnection(url,user,password);
			
			
			Statement statement = connection.createStatement();
			
			statement.executeUpdate(query);
			
			System.out.println("Run Successfuly");
			
			
			statement.close();
			connection.close();
		}
		catch(SQLException e) {
			System.out.println("Failed to execute" + e);
		}

	}

}

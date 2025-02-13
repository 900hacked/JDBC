package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Batch {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/schoolregister";
		String user = "root";
		String password = "JavaCommunity2!";
		
		String query1 = "INSERT INTO Employee(EmployeeID,EmployeeName,Salary) "
				+"VALUES "
				+"(03,'Hassan',100)";
		
		String query2 = "INSERT INTO Employee(EmployeeID,EmployeeName,Salary) "
				+"VALUES "
				+"(05,'David',350)";
		
		try {
			Connection connection = DriverManager.getConnection(url,user,password);
			
			Statement statement = connection.createStatement();
			
			connection.setAutoCommit(false);
			
			statement.addBatch(query1);
			statement.addBatch(query2);
			
			statement.executeBatch();
			
			connection.commit();
			
			System.out.println("Run Successfully");
			
			statement.close();
			connection.close();
		}
		catch(SQLException e) {
			System.out.println("Failed to Execute" + e);
		}

	}

}

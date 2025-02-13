package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/schoolregister";
		String user = "root";
		String password = "JavaCommunity2!";
		String query = "SELECT * FROM Employee";
		
		try {
		Connection connection = DriverManager.getConnection(url,user,password);
		
		Statement statement = connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery(query);
		
		while(resultSet.next()) {
			int id = resultSet.getInt("EmployeeID");
			String name = resultSet.getString("EmployeeName");
			int salary = resultSet.getInt("Salary");
			System.out.println("EmployeeID: " + id + ", EmployeeName: " + name + ", Salary: " + salary);
		}
		
		resultSet.close();
		statement.close();
		connection.close();
		
		}
		catch(SQLException e) {
			System.out.println("Failed to execute" + e);
		}

	}

}

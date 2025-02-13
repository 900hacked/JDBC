package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Tablee {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/schoolregister";
		String user = "root";
		String password = "JavaCommunity2!";
		
		String query = "CREATE TABLE Employee("
				+ "EmployeeID int primary key not null,"
				+ "EmployeeName varchar(100) NOT NULL,"
				+ "Salary int NOT NULL )";
		try {
			Connection connection = DriverManager.getConnection(url,user,password);
			System.out.println("Connected Successfully");
			
			Statement statement = connection.createStatement();
			
			statement.execute(query);
			
			connection.close();
			statement.close();
		}
		
		catch(SQLException e) {
			System.out.println("Failed" + e);
		}

	}

}

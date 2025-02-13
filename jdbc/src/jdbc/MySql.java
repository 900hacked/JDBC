package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySql {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/schoolregister";
		String user = "root";
		String password = "JavaCommunity2!";
		String query = "SELECT * FROM Students";
		try {
		Connection connection = DriverManager.getConnection(url,user,password);
		System.out.println("You have successfully connected to your database");
		
		//create a statement
		
		Statement statement = connection.createStatement();
		
		//Execute Query
		ResultSet resultSet = statement.executeQuery(query);
		
		//process the results
		
		while(resultSet.next()) {
			int id = resultSet.getInt("StudentID");
			String name = resultSet.getString("StudentName");
			String address = resultSet.getString("Address");
			System.out.println("StudentID: " + id + ", StudentName: " + name + ", Address: " + address);
			
		
		}
		
		resultSet.close();
		statement.close();
		connection.close();
		
		}
		catch(SQLException e) {
			System.out.println("You have failed to connect to the database" + e);
		}

	}

}

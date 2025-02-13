package callableStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Call {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/schoolregister";
		String user = "root";
		String password = "JavaCommunity2!";
		
		String query = "CALL help_him()";
		
		try {
			Connection conn = DriverManager.getConnection(url,user,password);
			
			Statement stat = conn.createStatement();
			
			stat.execute(query);
			
			ResultSet rs = stat.executeQuery(query);
			
			while(rs.next()) {
				int employeeID = rs.getInt("EmployeeID");
				String name = rs.getString("EmployeeName");
				int salary = rs.getInt("Salary");
				System.out.println("EmployeeID: " + employeeID + ", EmployeeName: " + name + ", Salary: " + salary);
				}
			
			System.out.println("Run Successfully");
			
			
			
			conn.close();
			stat.close();
			rs.close();
		}
		catch(SQLException e) {
			System.out.println("Failed to Run" + e);
		}

	}

}



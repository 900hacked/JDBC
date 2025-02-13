package callableStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Batch {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/schoolregister";
		String user = "root";
		String password = "JavaCommunity2!";
		
		String query =  "CREATE PROCEDURE add_emp(IN empID INT, IN empName VARCHAR(255), IN empSalary DECIMAL(10,2))\r\n"
				+ "BEGIN\r\n"
				+ "    INSERT INTO Employee(EmployeeID, EmployeeName, Salary)\r\n"
				+ "    VALUES (empID, empName, empSalary);\r\n"
				+ "    COMMIT; \r\n"
				+ "END";
		
		try {
			Connection conn = DriverManager.getConnection(url,user,password);
			
			PreparedStatement pps = conn.prepareStatement(query);
			
			pps.execute();
			
			System.out.println("Run Successfully");
			
			conn.close();
			pps.close();
		}
		catch(SQLException e) {
			System.out.println("Failed to Run" + e);
		}

	}

}

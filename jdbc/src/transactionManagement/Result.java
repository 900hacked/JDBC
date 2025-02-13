package transactionManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class Result {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/schoolregister";
		String user = "root";
		String password = "JavaCommunity2!";
		
		String query = "SELECT DoctorID, DoctorName FROM Doctors";
		
		try {
			Connection conn = DriverManager.getConnection(url,user,password);
			
			Statement stat = conn.createStatement();
			
			ResultSet rs = stat.executeQuery(query);
			
			ResultSetMetaData rsmd = rs.getMetaData();
			
			System.out.println("Total columns: " + rsmd.getColumnCount());
			System.out.println("Column name: " + rsmd.getColumnName(1));
			System.out.println("Column type: " + rsmd.getColumnType(1));
			
			conn.close();
			stat.close();
			
		}
		catch(SQLException e) {
			System.out.println("Failed to Run" + e);
		}

	}

}

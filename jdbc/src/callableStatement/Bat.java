package callableStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Bat {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/schoolregister";
		String user = "root";
		String password = "JavaCommunity2!";
		
		String query = "CALL add_emp(?,?,?)";
		
		try {
			Connection conn = DriverManager.getConnection(url,user,password);
			
			conn.setAutoCommit(false);
			
			PreparedStatement pps = conn.prepareStatement(query);
			
			pps.setInt(1, 11);
			pps.setString(2, "Marcia");
			pps.setDouble(3, 5000.0);
			pps.addBatch();
			
			pps.setInt(1, 12);
			pps.setString(2, "Ashley");
			pps.setDouble(3, 5000.0);
			pps.addBatch();
			
			pps.executeBatch();
			
			conn.commit();
			
			System.out.println("Run Successfully");
			
			conn.close();
			pps.close();
		}
		catch(SQLException e) {
			System.out.println("Failed to Run" + e);
		}

	}

}

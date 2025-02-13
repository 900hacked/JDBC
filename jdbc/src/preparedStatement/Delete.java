package preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/schoolregister";
		String user = "root";
		String password = "JavaCommunity2!";
		
		String query = "DELETE FROM Doctors WHERE DoctorID = ?";
		
		try {
			Connection conn = DriverManager.getConnection(url,user,password);
			
			PreparedStatement pps = conn.prepareStatement(query);
			
			pps.setInt(1, 2);
			
			pps.execute();
			
			System.out.println("Deleted Succcessfully");
			
			conn.close();
			pps.close();
		}
		catch(SQLException e) {
			System.out.println("Failed to Run" + e);
		}

	}

}

package preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/schoolregister";
		String user = "root";
		String password = "JavaCommunity2!";
		
		String query = "UPDATE Doctors SET Age = ? WHERE DoctorID = ? ";
		
		try {
			Connection conn = DriverManager.getConnection(url,user,password);
			
			PreparedStatement pps = conn.prepareStatement(query);
			
			pps.setInt(2, 4);
			pps.setInt(1, 56);
			
			pps.execute();
			
			System.out.println("Updated Successfully");
			
			conn.close();
			pps.close();
		}
		catch(SQLException e) {
			System.out.println("Failed to Run");
		}

	}

}

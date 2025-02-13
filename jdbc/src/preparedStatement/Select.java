package preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/schoolregister";
		String user = "root";
		String password = "JavaCommunity2!";
		
		String query = "SELECT DoctorName, Age FROM Doctors";
		
		try {
			Connection conn = DriverManager.getConnection(url,user,password);
			
			PreparedStatement pps = conn.prepareStatement(query);
			
			ResultSet rs = pps.executeQuery(query);
			
			while(rs.next()) {
				String DocName = rs.getString("DoctorName");
				int Age = rs.getInt("Age");
				System.out.println("DoctorsName: " + DocName + ", Age: " + Age);
			}
			
			System.out.println("Run Successfully");
			
			conn.close();
			pps.close();
			rs.close();
		}
		catch(SQLException e) {
			System.out.println("Failed to Run" + e);
		}

	}

}

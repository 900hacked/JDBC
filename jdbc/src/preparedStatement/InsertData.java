package preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/schoolregister";
		String user = "root";
		String password = "JavaCommunity2!";
		
		String query = "INSERT INTO Doctors(DoctorID,DoctorName,Age) "
				+ "VALUES (?,?,?),(?,?,?)";
				
				
		
		try {
			Connection connection = DriverManager.getConnection(url,user,password);
			
			PreparedStatement pps = connection.prepareStatement(query);
			
			pps.setInt(1, 6);
			pps.setString(2, "Martha");
			pps.setInt(3, 56);
			pps.setInt(4, 7);
			pps.setString(5, "Tendo");
			pps.setInt(6, 35);
			
			pps.execute();
			
			System.out.println("Run Successfully");
			
			connection.close();
			pps.close();
		}
		catch(SQLException e) {
			System.out.println("Failed to run" + e);
		}

	}

}

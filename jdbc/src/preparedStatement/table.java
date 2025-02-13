package preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class table {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/schoolregister";
		String user = "root";
		String password = "JavaCommunity2!";
		
		String query = "CREATE TABLE Doctors( "
				+"DoctorID int primary key not null, "
				+"DoctorName varchar(100) not null, "
				+"Age int not null)";
		
		try {
			Connection connection = DriverManager.getConnection(url,user,password);
			
			PreparedStatement  pps = connection.prepareStatement(query);
			
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

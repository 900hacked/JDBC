package transactionManagement;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataMeta {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/schoolregister";
		String user = "root";
		String password = "JavaCommunity2!";
		
		try {
			Connection conn = DriverManager.getConnection(url,user,password);
			
			DatabaseMetaData dbmd = conn.getMetaData();
			
			System.out.println("Driver Name: " + dbmd.getDriverName());
			System.out.println("Driver Version: " + dbmd.getDriverVersion());
			System.out.println("Database Username: " + dbmd.getUserName());
			System.out.println("Database Product Name: " + dbmd.getDatabaseProductName());
			System.out.println("Database Product Version: " + dbmd.getDatabaseProductVersion());
			
			conn.close();
		}
		catch(SQLException e) {
			System.out.println("Failed to Run" + e);
		}

	}

}

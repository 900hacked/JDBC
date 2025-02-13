package transactionManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class transact {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/schoolregister";
		String user = "root";
		String password = "JavaCommunity2!";
		
		String query1 = "INSERT INTO Doctors(DoctorID,DoctorName,Age)"
				+ "VALUES (14,'Kalisa',45)";
		
		String query2 = "INSERT INTO Doctors(DoctorID,DoctorName,Age)"
				+ "VALUES (15,'Mwiza',40)";
		
		Connection conn = null;
		try {
			 conn = DriverManager.getConnection(url,user,password);
			
			//Disable auto commit
			conn.setAutoCommit(false);
			
			Statement stat = conn.createStatement();
			
			stat.executeUpdate(query1);
			
			stat.executeUpdate(query2);
			
			conn.commit();
			
			System.out.println("Transaction completed successfully");
			
			conn.close();
			stat.close();
		}
		catch(SQLException e) {
			
			 if (conn != null) {
			        try {
			            conn.rollback();
			        } catch (SQLException rollbackEx) {
			            rollbackEx.printStackTrace();
			        }
			    }
			    e.printStackTrace();
		}

	}

}



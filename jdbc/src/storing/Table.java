package storing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Table {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/schoolregister";
		String user = "root";
		String password = "JavaCommunity2!";
		
		String query = "CREATE TABLE Movies( "
				+ "MovieID int primary key not null,"
				+ "MovieName varchar(255) not null,"
				+ "Year int not null, "
				+ "MyFile LONGBLOB"
				+ ")";
		
		try {
			Connection conn = DriverManager.getConnection(url,user,password);
			
			Statement stat = conn.createStatement();
			
			stat.execute(query);
			
			System.out.println("Table created");
		}
		catch(SQLException e) {
			System.out.println("Failed to Create Table" + e);
		}
				

	}

}

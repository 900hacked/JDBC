package storing;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class blob {

	public static void main(String[] args) {
		//inserting values and storing the file
				String url = "jdbc:mysql://localhost:3306/schoolregister";
				String user = "root";
				String password = "JavaCommunity2!";
				
				String filePath = "C:\\Users\\Dorian\\eclipse-workspace\\jdbc\\Movie.txt";
				
				String query = "INSERT INTO Movies(MovieID,MovieName,year,MyFile) "
						+ "VALUES (?,?,?,?)";
				
				try {
					Connection conn = DriverManager.getConnection(url,user,password);
					
					
					PreparedStatement pps = conn.prepareStatement(query);
					
					
					File file = new File(filePath);
					FileInputStream inputStream = new FileInputStream(file);
					
					
					
					pps.setInt(1,1);
					pps.setString(2, "Interstellar");
					pps.setInt(3, 2014);
					pps.setBinaryStream(4, inputStream,(int) file.length());
					
					int rowsInserted = pps.executeUpdate();
					if (rowsInserted > 0) {
						System.out.println("Run Successfully");
					}
				}
				catch(Exception e) {
					System.out.println("Failed to Run" + e);
				}


	}

}

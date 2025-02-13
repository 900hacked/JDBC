package storing;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



public class Movie {

	public static void main(String[] args) {
		//creating a file
		File objFile = new File("Movie.txt");
		
		try {
			boolean x = objFile.createNewFile();
			System.out.println(x);
			
		}
		catch(IOException e) {
			System.out.println("Failed to create file" + e);
		}
		
		
	}

}

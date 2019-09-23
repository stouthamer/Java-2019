package src;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 

// This class can be used to initialize the database connection 
public class DatabaseConnection { 
	public static Connection initializeDatabase() 
		throws SQLException, ClassNotFoundException 
	{ 
		// Initialize all the information regarding 
		// Database Connection 
		Class.forName("com.mysql.jdbc.Driver");
	      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","");
		
		return con; 
	} 
} 


package edu.temple.quietLounge;

import com.mysql.jdbc.Driver;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory; 

public class SQLDatabaseConnection {
	
	// Creating only instance
	private static SQLDatabaseConnection instance = new SQLDatabaseConnection();

	// Database Credentials
	private static final String url = "jdbc:mysql://aae49nhnftqu2.cfjstbrfli0s.us-east-1.rds.amazonaws.com:3306/ebdb";
	private static final String user = "foxy"; 
	private static final String password = "halobuster1982";
	
	// The connection to MySQL Database
	private static Connection con; 
	
	// Create Logger object
	private Log log = LogFactory.getLog(SQLDatabaseConnection.class);
	
	private SQLDatabaseConnection() {
		connectToDB();
	}
	
	private void connectToDB() {
		try { 
			DriverManager.registerDriver(new Driver ());
			con = DriverManager.getConnection(url, user, password); 
			log.info("Connecting to Database: Successfully Connected");
		}  catch (SQLException sqlEx) { 
			sqlEx.printStackTrace(); 
		}
	}
	
	public static SQLDatabaseConnection getInstance() {
		return instance;
	}

	public static Connection getCon() {
		return con;
	}

}

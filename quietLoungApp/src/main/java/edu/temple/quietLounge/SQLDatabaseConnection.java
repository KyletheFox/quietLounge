package edu.temple.quietLounge;

import com.mysql.jdbc.Driver;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory; 

/**
 * This class is a singleton that is designed to create a connection to the
 * MySQL database I have set up for this project. This connection will be used
 * to input and output data about the lounges that are currently being 
 * tracked by the server
 *
 */
public class SQLDatabaseConnection {
	
	// Creating only instance
	private static SQLDatabaseConnection instance = new SQLDatabaseConnection();

	// Database Credentials
	public static final String url = "jdbc:mysql://aae49nhnftqu2.cfjstbrfli0s.us-east-1.rds.amazonaws.com:3306/ebdb?autoReconnect=true";
	public static final String user = "foxy"; 
	public static final String password = "halobuster1982";
	
//	public static final String url = "jdbc:mysql://localhost:3306/";
//	public static final String user = "root"; 
//	public static final String password = "";
	
	// The connection to MySQL Database
	private static Connection con; 
	
	// Create Logger object
	private Log log = LogFactory.getLog(SQLDatabaseConnection.class);
	
	/**
	 * Private constructor. Outside classes must call public methods to access the
	 * connection or the instance of this class
	 */
	private SQLDatabaseConnection() {
		connectToDB();
	}
	
	/**
	 * Attempts to connect to the database server
	 */
	private void connectToDB() {
		try { 
			DriverManager.registerDriver(new Driver ());
			con = DriverManager.getConnection(url, user, password); 
			log.info("Connecting to Database: Successfully Connected");
		}  catch (SQLException sqlEx) { 
			sqlEx.printStackTrace(); 
		}
	}
	
	/**
	 * Gets the instance of the DB connection. Only way to get the this object
	 * @return Instance of the SQLDatabaseConnection Object
	 */
	public static SQLDatabaseConnection getInstance() {
		return instance;
	}
	
	/**
	 * Gets the connection to the database created in this singleton
	 * @return Connection to the database
	 */
	public static Connection getCon() {
		return con;
	}

}

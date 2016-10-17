package edu.temple.quietLounge;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement;

public class SQLDatabaseConnection {
	
	// Creating only instance
	private static SQLDatabaseConnection instance = new SQLDatabaseConnection();

	// Database Credentials
	private static final String url = "jdbc:mysql://aae49nhnftqu2.cfjstbrfli0s.us-east-1.rds.amazonaws.com:3306/ebdb";
	private static final String user = "foxy"; 
	private static final String password = "halobuster1982";
	
	private static Connection con; 
//	private static Statement stmt; 
//	private static ResultSet rs;
	
	private SQLDatabaseConnection() {
		connectToDB();
	}
	
	private void connectToDB() {
		try { 
			con = DriverManager.getConnection(url, user, password); 
			//System.out.println(con);
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

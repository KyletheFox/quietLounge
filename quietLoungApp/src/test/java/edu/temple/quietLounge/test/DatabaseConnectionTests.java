/**
 * 
 */
package edu.temple.quietLounge.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.util.Assert;

import com.mysql.jdbc.Driver;

import edu.temple.quietLounge.SQLDatabaseConnection;
import edu.temple.quietLounge.DAO.SqlQueryStringFactory;

/**
 * @author TheFoxx
 *
 */
public class DatabaseConnectionTests { 
	
	// These values are defined in SQLDatabaseConnection.java
	private final static String url = SQLDatabaseConnection.url;
	private final static String user = SQLDatabaseConnection.user; 
	private final static String password = SQLDatabaseConnection.password;
	private static Connection con;
	private ResultSet rs;						// Results from query
	private String sql;
	private Statement stmt;
	
	@BeforeClass
	public static void setUpDBconnection() throws SQLException {
		DriverManager.registerDriver(new Driver ());
		con = DriverManager.getConnection(url, user, password); 
	}
	
	
	@Test
    public void checkDatabaseConnection() throws Exception {
		Assert.notNull(con);    	
    }
	
	@Test
	public void MakeSureTableExists() throws SQLException{
		sql = SqlQueryStringFactory.getAllSensorDataQuery();
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		Assert.notNull(rs);
	}
	
	@Test
	public void checkForTestSensorInDatabase() throws SQLException {
		sql = "SELECT * FROM Sensors WHERE Sensor_ID='TEST'";
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		rs.next();
		assertEquals(rs.getString(1), "TEST");
	}
	
	

}

package com.remotesound;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;

import com.mysql.jdbc.Driver;
import com.remotesound.DAO.QueryFactory;
import com.remotesound.VO.SoundData;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RemoteSoundApplicationTests {
	
	@Autowired
    private MockMvc mockMvc;
	
	QueryFactory qF;
	SoundData sd;
	
	// These values are defined in SQLDatabaseConnection.java
	private final static String url = SQLDatabaseConnection.url;
	private final static String user = SQLDatabaseConnection.user; 
	private final static String password = SQLDatabaseConnection.password;
	private static Connection con;
	private ResultSet rs;						// Results from query
	private String sql;
	private Statement stmt;
	
	@Before
	public void before() {
		
	}

	@Test
	public void createQueryFactoryObject() {
		qF = new QueryFactory();
		Assert.notNull(qF);
	}
	
	@Test
	public void createSoundDataObject() {
		sd = new SoundData();
		Assert.notNull(sd);
	}
	
	@Test
	public void pingStatusOk() throws Exception {
		this.mockMvc.perform(get("/ping")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void getSoundDataStatusOk() throws Exception {
		this.mockMvc.perform(get("/getSoundData")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void inputSoundStatusOk() throws Exception {
		this.mockMvc.perform(post("/inputSound").param("id", "ID").param("sound", "SOUND")).andDo(print()).andExpect(status().isOk());
	}
	
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
		sql = "SELECT * FROM Sensors";
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

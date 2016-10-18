package edu.temple.quietLounge.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edu.temple.quietLounge.SQLDatabaseConnection;
import edu.temple.quietLounge.VO.Lounge;

public class LoungeCoordinates extends ArrayList<Lounge>{
	
	private static final long serialVersionUID = 1L;
	private final int DEFAULT_MAX = 50;
	private int maxLounges;
	
	public LoungeCoordinates() {
		this.maxLounges = this.DEFAULT_MAX;
		pullAllLoungeCoords();
	}
	
	public LoungeCoordinates(int maxLounges) {
		this.maxLounges = maxLounges;
		pullAllLoungeCoords();
	}
	
	private void pullAllLoungeCoords() {
		
		Statement stmt;
		ResultSet rs;
		Connection con;
		
		// Get Database Connection
		con = SQLDatabaseConnection.getCon();
				
		// Query to pull the lounge data
		String sql = "SELECT * FROM Lounge_List";	
		
		// Run Query
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				this.add(createLounge(rs));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	private Lounge createLounge(ResultSet rs) throws SQLException {
		return new Lounge(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5), rs.getInt(6));
	}

	@Override
	public String toString() {
		return "LoungeCoordinates [loungeDataList=" + this.toString() + "]";
	}

}

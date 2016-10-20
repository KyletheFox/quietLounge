package edu.temple.quietLounge.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edu.temple.quietLounge.SQLDatabaseConnection;
import edu.temple.quietLounge.VO.Lounge;

public class TrackedLoungeData extends ArrayList<Lounge>{
	
	private static final long serialVersionUID = 1L;
	private final int DEFAULT_MAX = 50;
	
	@SuppressWarnings("unused")	
	private int maxLounges;
	// TODO Implement To Get Max Number of Lounges in Response
	
	public TrackedLoungeData() {
		this.maxLounges = this.DEFAULT_MAX;
		pullAllLoungeCoords();
	}
	
	public TrackedLoungeData(int maxLounges) {
		this.maxLounges = maxLounges;
		pullAllLoungeCoords();
	}
	
	private void pullAllLoungeCoords() {
		
		Statement stmt;
		ResultSet rs;
		Connection con;
		SqlQueryStringFactory queryFactory;
		
		// Get Database Connection
		con = SQLDatabaseConnection.getCon();
				
		// Create Query factory 
		queryFactory = new SqlQueryStringFactory();	
		
		// Run Query
		try {
			
			// Get master lounge table data
			stmt = con.createStatement();
			rs = stmt.executeQuery(queryFactory.getSelectAllLoungeDataQuery());
			
			// Add query results to the ArrayList (this)
			while(rs.next()) {
				this.add(createLounge(rs));
			}
			
		} catch (SQLException e) {
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

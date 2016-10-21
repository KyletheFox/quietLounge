package edu.temple.quietLounge.managers;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.temple.quietLounge.SQLDatabaseConnection;
import edu.temple.quietLounge.DAO.SqlQueryStringFactory;
import edu.temple.quietLounge.DAO.TrackedLoungeData;
import edu.temple.quietLounge.VO.DataUpdateResponse;
import edu.temple.quietLounge.VO.FailureDataUpdateResponse;
import edu.temple.quietLounge.VO.Lounge;
import edu.temple.quietLounge.VO.SoundData;
import edu.temple.quietLounge.VO.SuccessfulDataUpdateResponse;

public class QuitetLoungeInputManager {
	
	private SoundData soundData;
	private TrackedLoungeData loungeCoords;
	private Log log = LogFactory.getLog(this.getClass());
	
	public QuitetLoungeInputManager() {
		this.loungeCoords = new TrackedLoungeData();
	}
	
	public QuitetLoungeInputManager(SoundData soundData) {
		this.soundData = soundData;
		this.loungeCoords = new TrackedLoungeData();
	}
	
	public DataUpdateResponse insertNewSoundData() {
		
		// Return immediately if there is bad data
		if (this.soundData.badData) {return new FailureDataUpdateResponse("Error in Data: Not in proper formatting");}
		
		// Temporary Placeholder
		Lounge tmp;
		
		// Create factory to create query statements
		SqlQueryStringFactory queryFactory = new SqlQueryStringFactory();
		
		//get an Iterator object for ArrayList using iterator() method.
	    Iterator<Lounge> itr = this.loungeCoords.iterator();
		
		// See if inputed coords are inside accepted range of any of the lounges.
		while(itr.hasNext()) {
			tmp = itr.next();
			
			double dist = getDistanceInFeet(tmp.getLat(), tmp.getLng());
			log.info("The distance to " + tmp.getName() + ": " + String.format("%.2f", dist) + "ft");
			
			if(getDistanceInFeet(tmp.getLat(), tmp.getLng()) <= tmp.getAcceptRange()) {
				log.info("This Location is within range of: " + tmp.getName());
				
				// Enter new data in to corresponding table
				String sql = queryFactory.getInsertSoundDataQuery(tmp.getName(), soundData);
				Statement stmt = null;
		        Connection con = SQLDatabaseConnection.getCon();
		        
		        try {
					stmt = con.createStatement();
					stmt.executeUpdate(sql);
					log.info("Inserted new Sound data into: " + tmp.getName());
					
					sql = queryFactory.getUpdateLoungeListSoundLevels(tmp.getName(), soundData);
					stmt.executeUpdate(sql);
					log.info("Updated master table with new sound data in Lounge: " + tmp.getName() + " @ " + soundData.getSoundLevel());
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
		        
				// Return Successful update
				return new SuccessfulDataUpdateResponse();
			}
		}
		
		log.info("No Louges Found in Range");
		return new FailureDataUpdateResponse("Out of Range");
	}
	
	private double getDistanceInFeet(double loungeLat, double loungeLng) {
		
		final double MILES_TO_FEET = 5280.00;
		
		double theta = this.soundData.getLng() - loungeLng;
		double dist = Math.sin(deg2rad(this.soundData.getLat())) * Math.sin(deg2rad(loungeLat)) + Math.cos(deg2rad(this.soundData.getLat())) * Math.cos(deg2rad(loungeLat)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		dist = dist * MILES_TO_FEET;
		return dist;
	}
	

	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}


	private static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}
}

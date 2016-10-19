package edu.temple.quietLounge;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.temple.quietLounge.DAO.LoungeCoordinates;
import edu.temple.quietLounge.ResponseObjs.DataUpdateResponse;
import edu.temple.quietLounge.ResponseObjs.FailureDataUpdateResponse;
import edu.temple.quietLounge.ResponseObjs.SuccessfulDataUpdateResponse;
import edu.temple.quietLounge.VO.Lounge;

public class QuitetLoungeInputManager {
	
	private double latitude;
	private double longitude;
	private double soundLevel;
	
	private LoungeCoordinates loungeCoords;
	private Log log = LogFactory.getLog(this.getClass());
	
	public QuitetLoungeInputManager() {
		this.loungeCoords = new LoungeCoordinates();
	}
	
	public QuitetLoungeInputManager(double latitude, double longitude, double soundLevel) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.soundLevel = soundLevel;
		this.loungeCoords = new LoungeCoordinates();
	}
	
	public DataUpdateResponse insertNewSoundData() {
		
		Lounge tmp;
		
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
				String sql = insertQueryFactory(tmp);
				Statement stmt = null;
		        Connection con = SQLDatabaseConnection.getCon();
		        
		        try {
					stmt = con.createStatement();
					stmt.executeUpdate(sql);
					log.info("Inserted new Sound data into: " + tmp.getName());
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
				// Return Successful update
				return new SuccessfulDataUpdateResponse();
			}
		}
		
		log.info("No Louges Found in Range");
		return new FailureDataUpdateResponse("Out of Range");
	}
	
	private String insertQueryFactory(Lounge lounge) {
		return "INSERT INTO " + lounge.getName() + " (Latitude, Longitude, SoundReading) " +
					"VALUES (" + this.latitude + ", " + this.longitude + ", " +
					this.soundLevel + ")";
	}
	
	private double getDistanceInFeet(double loungeLat, double loungeLng) {
		
		final double MILES_TO_FEET = 5280.00;
		
		double theta = this.longitude - loungeLng;
		double dist = Math.sin(deg2rad(this.latitude)) * Math.sin(deg2rad(loungeLat)) + Math.cos(deg2rad(this.latitude)) * Math.cos(deg2rad(loungeLat)) * Math.cos(deg2rad(theta));
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

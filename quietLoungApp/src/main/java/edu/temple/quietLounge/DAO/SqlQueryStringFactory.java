/**
 * 
 */
package edu.temple.quietLounge.DAO;

import edu.temple.quietLounge.VO.SoundData;

/**
 * A factory that generates all the SQL query strings needed to for the server. 
 */
public class SqlQueryStringFactory {
	
	/**
	 * No-args Constructor
	 */
	public SqlQueryStringFactory() {}
	
	/**
	 * Creates query to insert sound data into the DB
	 * @param tableName - Name of table to insert into
	 * @param soundData - Decibel Level
	 * @return INSERT query string
	 */
	public String getInsertSoundDataQuery(String tableName, SoundData soundData) {
		return "INSERT INTO " + tableName + " (Latitude, Longitude, SoundReading) " +
				"VALUES (" + soundData.getLat() + ", " + soundData.getLng() + ", " +
				soundData.getSoundLevel() + ")";
	}
	
	/**
	 * Creates query to get all the lounge data
	 * @return SELECT query string
	 */
	public String getSelectAllLoungeDataQuery() {
		return "SELECT * FROM Lounge_List";
	}
	
	/**
	 * Creates a query string to update the sound levels of a specific lounge
	 * @param loungeName - The lounge to update
	 * @param soundData	- The decibel level
	 * @return UPDATE query string
	 */
	public String getUpdateLoungeListSoundLevels(String loungeName, SoundData soundData) {
		return "UPDATE Lounge_List SET lastSoundLevel=" + soundData.getSoundLevel() + ", lastUpdateTime='" + 
				soundData.getTimeStamp() + "' WHERE name='" + loungeName + "'"; 
	}

}

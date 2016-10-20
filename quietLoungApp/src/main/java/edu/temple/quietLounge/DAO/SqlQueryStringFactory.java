/**
 * 
 */
package edu.temple.quietLounge.DAO;

import edu.temple.quietLounge.VO.SoundData;

/**
 * @author TheFoxx
 *
 */
public class SqlQueryStringFactory {
	
	public SqlQueryStringFactory() {}
	
	public String getInsertSoundDataQuery(String tableName, SoundData soundData) {
		return "INSERT INTO " + tableName + " (Latitude, Longitude, SoundReading) " +
				"VALUES (" + soundData.getLat() + ", " + soundData.getLng() + ", " +
				soundData.getSoundLevel() + ")";
	}
	
	public String getSelectAllLoungeDataQuery() {
		return "SELECT * FROM Lounge_List";
	}
	
	public String getUpdateLoungeListSoundLevels(String loungeName, double soundLevel) {
		return "UPDATE Lounge_List SET lastSoundLevel=" + soundLevel + "WHERE name='" + loungeName + "'"; 
	}

}

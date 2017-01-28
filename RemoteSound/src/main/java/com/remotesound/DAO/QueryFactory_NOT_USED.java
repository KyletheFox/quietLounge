/**
 * 
 */
package com.remotesound.DAO;

/**
 * @author TheFoxx
 *
 */
public class QueryFactory_NOT_USED {
	
	String query;
	StringBuilder sb;
	
	public QueryFactory_NOT_USED() {
		sb = new StringBuilder();
	}
	
	public String getInsertSoundDataQuery(String tableName) {
		sb.setLength(0);
		sb.append("INSERT INTO ")
			.append(tableName);
		return sb.toString();
			
//		tableName + " (Latitude, Longitude, SoundReading) " +
//		"VALUES (" + soundData.getLat() + ", " + soundData.getLng() + ", " +
//		soundData.getSoundLevel() + ")";
	}
	
	/**
	 * Creates query to get all the lounge data
	 * @return SELECT query string
	 */
	public String getSelectAllMicrophoneDataQuery() {
		sb.setLength(0);
		sb.append("SELECT * FROM Sensors");
		return sb.toString();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return query;
	}

	
}

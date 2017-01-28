/**
 * 
 */
package com.remotesound.VO;

import java.util.Date;

/**
 * @author TheFoxx
 *
 */
public class InsertResponse {
	private String DIN;
	private Date timestamp;
	private double soundLevel;
	
	
	/**
	 * No_Arg Constructor
	 */
	public InsertResponse() {
		super();
	}
	
	/**
	 * @return the dIN
	 */
	public String getDIN() {
		return DIN;
	}
	/**
	 * @param dIN the dIN to set
	 */
	public void setDIN(String dIN) {
		DIN = dIN;
	}
	/**
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}
	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	/**
	 * @return the soundLevel
	 */
	public double getSoundLevel() {
		return soundLevel;
	}
	/**
	 * @param soundLevel the soundLevel to set
	 */
	public void setSoundLevel(double soundLevel) {
		this.soundLevel = soundLevel;
	}
}

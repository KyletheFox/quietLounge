/**
 * 
 */
package com.remotesound.VO;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author TheFoxx
 *
 */
public class SoundData {
	
	private String deviceId;
	private double soundLevel;
	private String timeStamp;
	
	private Log log = LogFactory.getLog(this.getClass());

	/**
	 * 
	 */
	public SoundData() {
		setTimeStamp();
	}

	/**
	 * @param deviceId
	 * @param soundLevel
	 * @param timeStamp
	 */
	public SoundData(String deviceId, double soundLevel) {
		this.deviceId = deviceId;
		this.soundLevel = soundLevel;
		setTimeStamp();
	}
	
	
	
	/**
	 * @return the deviceId
	 */
	public String getDeviceId() {
		return deviceId;
	}

	/**
	 * @param deviceId the deviceId to set
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
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

	private void setTimeStamp() {
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.timeStamp = sdf.format(dt);
	}
	
	
}

package edu.temple.quietLounge.VO;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SoundData {
	private double lat;
	private double lng;
	private double soundLevel;
	private String timeStamp;
	
	public boolean badData;
	private Log log = LogFactory.getLog(this.getClass());
	
	public SoundData() {
		this.badData = false;
		this.lat = 0;
		this.lng = 0;
		this.soundLevel = 0;
		setTimeStamp();
	}
	
	public SoundData(double lat, double lng, double soundLevel) {
		this.badData = false;
		this.lat = lat;
		this.lng = lng;
		this.soundLevel = soundLevel;
		setTimeStamp();
	}
	
	public SoundData(String lat, String lng, String soundLevel) {
		try {
			this.lat = Double.parseDouble(lat);
			this.lng = Double.parseDouble(lng);
			this.soundLevel = Double.parseDouble(soundLevel);
		} catch (Exception e) {
			this.lat = 0;
			this.lng = 0;
			this.soundLevel = 0;
			log.info("Invalid Param Input: Bad Data - NOT INPUTED INTO DB");
			this.badData = true;
		}
		
		setTimeStamp();
	}
	
	private void setTimeStamp() {
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.timeStamp = sdf.format(dt);
	}
	
	public String getTimeStamp() {
		return this.timeStamp;
	}
	
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public double getSoundLevel() {
		return soundLevel;
	}
	public void setSoundLevel(double soundLevel) {
		this.soundLevel = soundLevel;
	}
	
}

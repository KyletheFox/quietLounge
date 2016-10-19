package edu.temple.quietLounge.VO;

import java.text.ParseException;

public class SoundData {
	private double lat;
	private double lng;
	private double soundLevel;
	
	public SoundData() {
		this.lat = 0;
		this.lng = 0;
		this.soundLevel = 0;
	}
	
	public SoundData(double lat, double lng, double soundLevel) {
		this.lat = lat;
		this.lng = lng;
		this.soundLevel = soundLevel;
	}
	
	public SoundData(String lat, String lng, String soundLevel) {
		try {
			this.lat = Double.parseDouble(lat);
			this.lng = Double.parseDouble(lng);
			this.soundLevel = Double.parseDouble(soundLevel);
		} catch (Exception e) {
			e.printStackTrace();
		}
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

package edu.temple.quietLounge.VO;

public class SoundData {
	private double lat;
	private double lng;
	private double soundLevel;
	
	public SoundData() {
	
	}
	
	public SoundData(double lat, double lng, double soundLevel) {
		this.lat = lat;
		this.lng = lng;
		this.soundLevel = soundLevel;
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

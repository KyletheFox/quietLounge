package edu.temple.quietLounge.VO;

/**
 * Holds data about each lounge. Used when the lounge data is being returned to
 * the sender
 *
 */
public class Lounge {
	
	// Variables
	private int id;
	private String name;
	private double lat;
	private double lng;
	private double lastSoundLevel;
	private int acceptRange;
	
	/**
	 * No-arg Constructor
	 */
	public Lounge() {
		this.id = 0;
		this.name = null;
		this.lat = 0;
		this.lng = 0;
		this.lastSoundLevel = 0;
		this.acceptRange = 0;
	}
	
	/**
	 * Constuctor filling in all the values
	 * @param id
	 * @param name
	 * @param lat
	 * @param lng
	 * @param lastSoundLevel
	 * @param acceptRange
	 */
	public Lounge(int id, String name, double lat, double lng, double lastSoundLevel, int acceptRange) {
		this.id = id;
		this.name = name;
		this.lat = lat;
		this.lng = lng;
		this.lastSoundLevel = lastSoundLevel;
		this.acceptRange = acceptRange;
	}

	// Setters and Getters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public double getLastSoundLevel() {
		return lastSoundLevel;
	}

	public void setLastSoundLevel(double lastSoundLevel) {
		this.lastSoundLevel = lastSoundLevel;
	}

	public int getAcceptRange() {
		return acceptRange;
	}

	public void setAcceptRange(int acceptRange) {
		this.acceptRange = acceptRange;
	}

	@Override
	public String toString() {
		return "Lounge [id=" + id + ", name=" + name + ", lat=" + lat + ", lng=" + lng + ", lastSoundLevel="
				+ lastSoundLevel + ", acceptRange=" + acceptRange + "]";
	}
	
	
	
}

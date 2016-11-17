package edu.temple.quietLounge.VO;

import java.util.ArrayList;

/**
 * Response that is sent back to the sender containing the latest lounge data
 *
 */
public class LoungeListResponse {
	
	// Variables
	private Lounge[] lounges;
	
	/**
	 * Constructor - Creates Array from ArrayList
	 * @param loungeList
	 */
	public LoungeListResponse(ArrayList<Lounge> loungeList) {
		this.lounges = new Lounge[loungeList.size()];
		this.lounges =  loungeList.toArray(lounges);
	}
	
	// Setter and Getter

	public Lounge[] getLounges() {
		return lounges;
	}

	public void setLounges(Lounge[] lounges) {
		this.lounges = lounges;
	}
	
}

package edu.temple.quietLounge.VO;

import java.util.ArrayList;

public class LoungeListResponse {
	
	private Lounge[] lounges;
	
	public LoungeListResponse(ArrayList<Lounge> loungeList) {
		this.lounges = new Lounge[loungeList.size()];
		this.lounges =  loungeList.toArray(lounges);
	}

	public Lounge[] getLounges() {
		return lounges;
	}

	public void setLounges(Lounge[] lounges) {
		this.lounges = lounges;
	}
	
}

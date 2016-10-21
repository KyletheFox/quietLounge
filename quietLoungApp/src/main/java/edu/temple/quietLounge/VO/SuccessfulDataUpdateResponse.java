package edu.temple.quietLounge.VO;

public class SuccessfulDataUpdateResponse extends DataUpdateResponse {

	public SuccessfulDataUpdateResponse() {
		super(true);
		this.setMsg("Successful Database Input");
	}
	
}

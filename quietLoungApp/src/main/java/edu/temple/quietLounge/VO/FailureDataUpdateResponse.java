package edu.temple.quietLounge.VO;

public class FailureDataUpdateResponse extends DataUpdateResponse {

	public FailureDataUpdateResponse() {
		super(false);
		this.setMsg("Unsuccessful Data Input. Please Try Again");
	}
	
	public FailureDataUpdateResponse(String msg) {
		super(false);
		this.setMsg(msg);
	}

}

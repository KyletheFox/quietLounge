package edu.temple.quietLounge.ResponseObjs;

public class FailureDataUpdateResponse extends DataUpdateResponse {

	public FailureDataUpdateResponse() {
		super(false);
		// TODO Auto-generated constructor stub
		this.setMsg("Unsuccessful Data Input. Please Try Again");
	}
	
	public FailureDataUpdateResponse(String msg) {
		super(false);
		// TODO Auto-generated constructor stub
		this.setMsg(msg);
	}

}

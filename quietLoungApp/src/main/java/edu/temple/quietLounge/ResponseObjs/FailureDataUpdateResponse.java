package edu.temple.quietLounge.ResponseObjs;

public class FailureDataUpdateResponse extends DataUpdateResponse {

	public FailureDataUpdateResponse() {
		super("Fail");
		// TODO Auto-generated constructor stub
		this.setMsg("Unsuccessful Data Input. Please Try Again");
	}

}

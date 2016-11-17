package edu.temple.quietLounge.VO;

/**
 * Message to be sent to user if the data sent was put into the DB
 * @author kyleoneill
 *
 */
public class SuccessfulDataUpdateResponse extends DataUpdateResponse {

	public SuccessfulDataUpdateResponse() {
		super(true);
		this.setMsg("Successful Database Input");
	}
	
}

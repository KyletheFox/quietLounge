/**
 * 
 */
package edu.temple.quietLounge.VO;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
/**
 * The response object that is to be delivered back to the sender. The
 * message will contain information like a time stamp and if the
 * data was entered into the DB
 *
 */
public abstract class DataUpdateResponse {
	
	// Variables
	protected Timestamp ts;				// Time stamp of the update
	protected boolean responseSuccess;	// Flag to determine if the request was successful
	protected String msg;				// Message of what happened
	
	/**
	 * No-Arg Constructor
	 */
	public DataUpdateResponse() {
		createTimestamp();
	}
	
	/**
	 * Constructor with success flag
	 * @param responseSuccess
	 */
	public DataUpdateResponse(boolean responseSuccess) {
		this.responseSuccess = responseSuccess;
		createTimestamp();
	}
	
	/**
	 * Creates a time stamp to insert into database
	 */
	protected void createTimestamp() {
		Calendar cal = Calendar.getInstance();
		Date now = cal.getTime();
		this.ts = new Timestamp(now.getTime());
	}
	
	// Setters/Getters
	
	public boolean getResponseSuccess() {
		return responseSuccess;
	}

	public void setResponseSuccess(boolean responseSuccess) {
		this.responseSuccess = responseSuccess;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Timestamp getTs() {
		return ts;
	}
	
}

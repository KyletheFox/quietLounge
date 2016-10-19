/**
 * 
 */
package edu.temple.quietLounge.ResponseObjs;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
/**
 * @author TheFoxx
 *
 */
public abstract class DataUpdateResponse {
	
	protected Timestamp ts;
	protected boolean responseSuccess;
	protected String msg;
	
	public DataUpdateResponse() {
		createTimestamp();
	}

	public DataUpdateResponse(boolean responseSuccess) {
		this.responseSuccess = responseSuccess;
		createTimestamp();
	}
	
	protected void createTimestamp() {
		Calendar cal = Calendar.getInstance();
		Date now = cal.getTime();
		this.ts = new Timestamp(now.getTime());
	}

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

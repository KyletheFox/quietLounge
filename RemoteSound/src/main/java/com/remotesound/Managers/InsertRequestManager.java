/**
 * 
 */
package com.remotesound.Managers;

import com.remotesound.VO.InsertResponse;

/**
 * @author TheFoxx
 *
 */
public class InsertRequestManager {
	
	private InsertResponse response;
	
	/**
	 * No_Arg Constructor
	 */
	public InsertRequestManager() {
		super();
	}

	/**
	 * @return the response
	 */
	public InsertResponse getResponse() {
		return response;
	}

	/**
	 * @param response the response to set
	 */
	public void setResponse(InsertResponse response) {
		this.response = response;
	}

}

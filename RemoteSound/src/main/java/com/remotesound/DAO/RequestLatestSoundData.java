/**
 * 
 */
package com.remotesound.DAO;

import java.util.ArrayList;

import com.remotesound.VO.SoundData;

/**
 * @author TheFoxx
 *
 */
public class RequestLatestSoundData extends ArrayList<SoundData>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7653056890985252532L;
	
	public RequestLatestSoundData() {
		super();
	}

	/**
	 * fill object with all the sound data entries
	 */
	public void sendResquest(){
		
		// Create and send query to get ResultSet of all the latest SoundData entries
		
		// Loop through each row and create a new SoundData obj with table info
		//		-- Insert each one into this --
		
	}

}

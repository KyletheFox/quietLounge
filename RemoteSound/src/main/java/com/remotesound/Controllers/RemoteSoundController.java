/**
 * 
 */
package com.remotesound.Controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author TheFoxx
 *
 */
@CrossOrigin
@RestController
public class RemoteSoundController {
	
	/**
     * GET request that returns a String. Allows client to check to see if the server
     * is up and running
     * @return A String saying "ping you"
     */
	@RequestMapping(value = "/ping", method = RequestMethod.GET)
    public String ping() {
    	return "Remote Sound is here!!!!";
    }
	
	/**
	 * GET request returning all sensor sound data
	 */
	@RequestMapping(value = "/getSoundData", method = RequestMethod.GET)
    public String getSoundData() {
    	return "Here is some sound data lol...";
    }
	
	/**
	 * POST request to enter data into dbs
	 */
	 @RequestMapping(value = "/inputSound", method = RequestMethod.POST)
	 public String addNewSoundData(@RequestParam(value="id") String deviceId, @RequestParam(value="sound") String soundLevel, 
			 @RequestParam(value="timestamp") String timestamp) {
		 return "You sent me data...";
	 }
	
	

}

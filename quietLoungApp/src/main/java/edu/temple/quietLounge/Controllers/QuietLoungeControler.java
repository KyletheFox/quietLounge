package edu.temple.quietLounge.Controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.temple.quietLounge.DAO.TrackedLoungeData;
import edu.temple.quietLounge.VO.DataUpdateResponse;
import edu.temple.quietLounge.VO.Lounge;
import edu.temple.quietLounge.VO.LoungeListResponse;
import edu.temple.quietLounge.VO.SoundData;
import edu.temple.quietLounge.managers.QuitetLoungeInputManager;
import java.util.ArrayList;

/**
 * 
 * This is that controller for the incoming HTTP request. This lays out the
 * params and types of request that the serve can handle. It also sets up
 * the URI that need to be attached to the end point. These tell the server
 * which action it needs to perform 
 *
 */
@CrossOrigin
@RestController
public class QuietLoungeControler {
    
	/**
	 * The controller to handle returning the current data about the lounges.
	 * This needs GET request to return the data
	 * @return A POJO that holds all the data about the lounges
	 */
	@RequestMapping(value = "/getLoungeData", method = RequestMethod.GET)
    public LoungeListResponse getLoungeData() {
		ArrayList<Lounge> loungeList = new TrackedLoungeData();
    	return new LoungeListResponse(loungeList);
    }
    
	/**
	 * This controller attempts to place new sound data into the database. It 
	 * is a POST request that requires 3 params to return a successful response
	 * @param lat - Current Latitude of the sound level
	 * @param lng - Current Longitude of the sound level
	 * @param soundLevel - Sound level of location in Decibel
	 * @return A POJO message that tells the caller if the DB was updated
	 */
    @RequestMapping(value = "/inputSound", method = RequestMethod.POST)
    public DataUpdateResponse addNewSoundData(@RequestParam(value="lat") String lat, 
    		@RequestParam(value="lng") String lng, @RequestParam(value="sound") String soundLevel) {
    	SoundData soundData = new SoundData(lat, lng, soundLevel);
		QuitetLoungeInputManager manager = new QuitetLoungeInputManager(soundData);
		return manager.insertNewSoundData();
    }
    
    /**
     * GET request that returns a String. Allows client to check to see if the server
     * is up and running
     * @return A String saying "ping you"
     */
    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public String getSoundData() {
    	return "ping you";
    }	
    
}

package edu.temple.quietLounge.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.temple.quietLounge.DAO.TrackedLoungeData;
import edu.temple.quietLounge.VO.DataUpdateResponse;
import edu.temple.quietLounge.VO.FailureDataUpdateResponse;
import edu.temple.quietLounge.VO.SoundData;
import edu.temple.quietLounge.managers.QuitetLoungeInputManager;
import java.text.ParseException;

@RestController
public class QuietLoungeControler {
    
	@RequestMapping(value = "/getLoungeData", method = RequestMethod.GET)
    public TrackedLoungeData getLoungeData() {
    	return new TrackedLoungeData();
    }
    
    @RequestMapping(value = "/inputSound", method = RequestMethod.POST)
    public DataUpdateResponse addNewSoundData(@RequestParam(value="lat") String lat, 
    		@RequestParam(value="lng") String lng, @RequestParam(value="sound") String soundLevel) {
    	SoundData soundData = new SoundData(lat, lng, soundLevel);
		QuitetLoungeInputManager manager = new QuitetLoungeInputManager(soundData);
		return manager.insertNewSoundData();
    }
    
    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public String getSoundData() {
    	return "ping you";
    }	
    
}

package edu.temple.quietLounge.Controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.temple.quietLounge.QuitetLoungeInputManager;
import edu.temple.quietLounge.SQLDatabaseConnection;
import edu.temple.quietLounge.DAO.LoungeCoordinates;
import edu.temple.quietLounge.ResponseObjs.DataUpdateResponse;
import edu.temple.quietLounge.ResponseObjs.SuccessfulDataUpdateResponse;
import junk.Greeting;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@RestController
public class QuietLoungeControler {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
	private Log log = LogFactory.getLog(QuietLoungeControler.class);
    
    @RequestMapping("/getLounges")
    public LoungeCoordinates getLoungeCooridnates() {
    	return new LoungeCoordinates();
    }
    
    @RequestMapping(value = "/inputSound", method = RequestMethod.POST)
    public DataUpdateResponse addNewSoundData(@RequestParam(value="lat") String lat, @RequestParam(value="lng") String lng, @RequestParam(value="sound") String sound) {
    	
    	QuitetLoungeInputManager manager = new QuitetLoungeInputManager(Double.parseDouble(lat), Double.parseDouble(lng), Double.parseDouble(sound));
    	return manager.insertNewSoundData();
    
    }
    
    @RequestMapping(value = "/createDatabase", method = RequestMethod.POST)
    public String addDBTable(@RequestParam(value="lat") String lat, @RequestParam(value="lng") String lng, @RequestParam(value="sound") String sound) {
        System.out.println(sound);
    	
    	Statement stmt = null;
        Connection con = SQLDatabaseConnection.getCon();
        
        String sql = "CREATE TABLE " + sound +
                "(id INTEGER not NULL)";
        
        //System.out.println(con.toString());
        
        try {
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			return "Created new Table named: " + sound;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
    	
    	return con.toString();
    }
    
    
}

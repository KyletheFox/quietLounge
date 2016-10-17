package edu.temple.quietLounge;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@RestController
public class QuietLoungeControler {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    // Variable never used. Only called to initalize the db connection singleton
    @SuppressWarnings("unused")
	private final SQLDatabaseConnection dbInstance = SQLDatabaseConnection.getInstance(); 

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping(value = "/insertData", method = RequestMethod.POST)
    public String addNewSoundData(@RequestParam(value="lat") String lat, @RequestParam(value="lng") String lng, @RequestParam(value="sound") String sound) {
        System.out.println(sound);
    	
    	Statement stmt = null;
        Connection con = SQLDatabaseConnection.getCon();
        
        String sql = "CREATE TABLE " + sound +
                "(id INTEGER not NULL)";
        
        System.out.println(con.toString());
        
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
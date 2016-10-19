package junk;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Giphy {
	//private String response;
	
	public Giphy() {
		RestTemplate gif = new RestTemplate();
		String url = "http://api.giphy.com/v1/gifs/search?q=funny+cat&api_key=dc6zaTOxFJmzC";
		ResponseEntity<String> str = gif.exchange(url, HttpMethod.GET, null, String.class);
		System.out.println(str);
	}
}

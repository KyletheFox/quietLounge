/**
 * 
 */
package junk;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @author kyleoneill
 *
 */
public class RestTemplateExample {
	
	RestTemplate restTemplate = new RestTemplate();
	String fooResourceUrl = "http://localhost:8080/spring-security-rest-full/foos";
	ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl + "/1", String.class);
}

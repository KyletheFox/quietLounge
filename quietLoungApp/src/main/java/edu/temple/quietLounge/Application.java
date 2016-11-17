package edu.temple.quietLounge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 
 * @author Kyle Oneill
 * @author Hong Ear
 * 
 * This the main that starts the project and configures the server
 *
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

	@Override
    protected SpringApplicationBuilder configure(
                      SpringApplicationBuilder application) {
      return application.sources(Application.class);
    }
  
}


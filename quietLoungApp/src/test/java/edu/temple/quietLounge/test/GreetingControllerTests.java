/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.temple.quietLounge.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;

import com.mysql.jdbc.Driver;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GreetingControllerTests {
	
	@Autowired
    private MockMvc mockMvc;
	
	@Test
	public void simpleTest() throws Exception {
		Assert.isTrue(true);
	}
	
	@Test
	public void callControllerThatDoesntExist() throws Exception {
		this.mockMvc.perform(get("/THIS_IS_NOT_A_CONTROLLER")).andExpect(status().is4xxClientError());
	}
	
	@Test
	public void pingShouldRetrunMessage() throws Exception {
		this.mockMvc.perform(get("/ping")).andDo(print()).andExpect(status().isOk())
					.andExpect(content().string("ping you"));
	}
	
	@Test
	public void inputSoundShouldReturnOkStatus() throws Exception {
		this.mockMvc.perform(post("/inputSound").param("lat", "SHOULD_BE_NUMBER").param("lng", "0").param("sound", "0"))
		.andExpect(status().isOk());
	}
	
	@Test
	public void getLoungeDataShouldReturnOkStatus() throws Exception {
		this.mockMvc.perform(get("/getLoungeData")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void invalidParamLatInputSoundData() throws Exception {
		this.mockMvc.perform(post("/inputSound").param("lat", "SHOULD_BE_NUMBER").param("lng", "0").param("sound", "0"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.responseSuccess").value(false));
	}
	
	@Test
	public void invalidParamLngInputSoundData() throws Exception {
		this.mockMvc.perform(post("/inputSound").param("lat", "0").param("lng", "SHOULD_BE_NUMBER").param("sound", "0"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.responseSuccess").value(false));
	}
	
	@Test
	public void invalidParamSoundInputSoundData() throws Exception {
		this.mockMvc.perform(post("/inputSound").param("lat", "0").param("lng", "0").param("sound", "SHOULD_BE_NUMBER"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.responseSuccess").value(false));
	}

    @Test
    public void checkDatabaseConnection() throws Exception {
    	String url = "jdbc:mysql://aae49nhnftqu2.cfjstbrfli0s.us-east-1.rds.amazonaws.com:3306/ebdb";
    	String user = "foxy"; 
    	String password = "halobuster1982";
    	Connection con; 
    	
    	DriverManager.registerDriver(new Driver ());
		con = DriverManager.getConnection(url, user, password); 
		
		Assert.notNull(con);    	
    }

}

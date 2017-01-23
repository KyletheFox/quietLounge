package com.remotesound;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;

import com.remotesound.DAO.QueryFactory;
import com.remotesound.VO.SoundData;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RemoteSoundApplicationTests {
	
	@Autowired
    private MockMvc mockMvc;
	
	QueryFactory qF;
	SoundData sd;
	
	@Before
	public void before() {
		qF = new QueryFactory();
	}

	@Test
	public void createQueryFactoryObject() {
		Assert.notNull(qF);
	}
	
	@Test
	public void createSoundDataObject() {
		sd = new SoundData();
		Assert.notNull(sd);
	}
	
	@Test
	public void pingStatusOk() throws Exception {
		this.mockMvc.perform(get("/ping")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void getSoundDataStatusOk() throws Exception {
		this.mockMvc.perform(get("/getSoundData")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void inputSoundStatusOk() throws Exception {
		this.mockMvc.perform(post("/inputSound").param("id", "ID").param("sound", "SOUND")).andDo(print()).andExpect(status().isOk());
	}

}

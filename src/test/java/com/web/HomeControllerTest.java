package com.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;


public class HomeControllerTest {

	@Test
	public void testHomePage() throws Exception{
		HomeController controller = new HomeController();
		
		StandaloneMockMvcBuilder mockMvcBuilder
		= MockMvcBuilders.standaloneSetup(controller);
		
		MockMvc mockMvc = mockMvcBuilder.build();
				
		mockMvc.perform(MockMvcRequestBuilders.get("/homepage"))
			.andExpect(MockMvcResultMatchers.view().name("home"));
		 
	}

}

package com.rt.bakery.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.rt.bakery.server.main.SpringBootRestApiApplication;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
@ContextConfiguration(classes = SpringBootRestApiApplication.class)
public class OrderControllerTest {
	
	@Autowired
	private MockMvc mockMVC;
	
	@Test
	public void when_Order_then_ShouldReturnOK() throws Exception {
		// given - I am hungry and see a bakery
		String orderURL = "/generateMyOrder";
		
		// when - I will order
		ResultActions result = mockMVC.perform(get(orderURL));
		
		// then - I should get result OK 
		result.andExpect(status().isOk());
	}	
}

package com.rt.bakery.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.rt.bakery.order.controllers.OrderController;
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


	@Test
	public void when_Order10VegemitteScroll_then_ShouldGetBestPackageAlongWithCost() throws Exception {
		// given - I am hungry and see a bakery
		String orderURL = "/generateMyOrder?productName=VS5&quantity=10";

		// when - I will order 10 vegemitte scroll
		ResultActions result = mockMVC.perform(get(orderURL));

		// then - I should get best packaging along with cost details 

		String expectedResponse = "{\"productName\":\"VS5\","
				+ "\"totalQuantity\":10,"
				+ "\"totalCost\":17.98,"
				+ "\"packageDTOList\":[{\"noOfPacks\":2,\"packOf\":5,\"costPerPack\":8.99}]}";

		result.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(content().json(expectedResponse));
	}
	
	@Test
	public void when_Order5Croissant_then_ShouldGetBestPackageAlongWithCost() throws Exception {
		// given
		String orderURL = "/generateMyOrder?productName=CF&quantity=5";

		// when
		ResultActions result = mockMVC.perform(get(orderURL));

		// then 

		String expectedResponse = "{\"productName\":\"CF\","
				+ "\"totalQuantity\":5,"
				+ "\"totalCost\":9.95,"
				+ "\"packageDTOList\":[{\"noOfPacks\":1,\"packOf\":5,\"costPerPack\":9.95}]}";

		result.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(content().json(expectedResponse));
	}
	
}

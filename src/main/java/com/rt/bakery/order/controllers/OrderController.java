package com.rt.bakery.order.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rt.bakery.order.dto.OrderDTO;
import com.rt.bakery.order.processor.OrderProcessor;

@RestController
public class OrderController {

	@RequestMapping(value = "/generateMyOrder", method = RequestMethod.GET)
	public OrderDTO generateOrderRequest(
			@RequestParam(value = "productCode", defaultValue = "VS5") String productCode,
			@RequestParam(value = "quantity", defaultValue = "0") int quantity) {

		OrderProcessor orderProcessor = new OrderProcessor();

		return orderProcessor.processOrder(productCode, quantity);
	}

}

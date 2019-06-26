package com.rt.bakery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrderController {
	
	@RequestMapping(value = "/generateMyOrder", method = RequestMethod.GET)
	public String generateOrderRequest() {
		return "Ok";
	}

}

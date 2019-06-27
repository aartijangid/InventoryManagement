package com.rt.bakery.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rt.bakery.order.dto.OrderDTO;
import com.rt.bakery.order.dto.PackageDTO;

@Controller
public class OrderController {
	
	@RequestMapping(value = "/generateMyOrder", method = RequestMethod.GET)
	@ResponseBody	
	public OrderDTO generateOrderRequest(
			@RequestParam(value = "productName", defaultValue = "VS5") String productName,
			@RequestParam(value = "quantity", defaultValue = "0") int quantity) {
		
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setProductName("VS5");
		orderDTO.setTotalQuantity(10);
		orderDTO.setTotalCost(17.98);
		List<PackageDTO> listOfPackage = new ArrayList<PackageDTO>();
		PackageDTO packOne = new PackageDTO();
		packOne.setNoOfPacks(2);
		packOne.setPackOf(5);
		packOne.setCostPerPack(8.99);
		listOfPackage.add(packOne);
		orderDTO.setPackageDTOList(listOfPackage);
		
		return orderDTO;
	}

}

package com.rt.bakery.order.processor;

import java.util.ArrayList;
import java.util.List;

import com.rt.bakery.order.dto.OrderDTO;
import com.rt.bakery.order.dto.PackageDTO;

public class OrderProcessor {
	
	public OrderDTO returnOrderDetail(String productCode, int quantity) {
		
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

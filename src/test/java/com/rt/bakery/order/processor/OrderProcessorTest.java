package com.rt.bakery.order.processor;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rt.bakery.order.dto.OrderDTO;
import com.rt.bakery.order.dto.PackageDTO;

public class OrderProcessorTest {
	@Test
	public void givenProductCodeAndQuantiyShouldReturnOrderDetail() throws JsonProcessingException {
		// Given
		String productCode = "VS5";
		int quantity = 10;
		OrderProcessor orderProcessor = new OrderProcessor();
		OrderDTO expectedOrderDTO = new OrderDTO();
		ObjectMapper objectMapper = new ObjectMapper();

		// When
		expectedOrderDTO.setProductName("VS5");
		expectedOrderDTO.setTotalQuantity(10);
		expectedOrderDTO.setTotalCost(17.98);
		List<PackageDTO> listOfPackage = new ArrayList<PackageDTO>();
		PackageDTO packOne = new PackageDTO();
		packOne.setNoOfPacks(2);
		packOne.setPackOf(5);
		packOne.setCostPerPack(8.99);
		listOfPackage.add(packOne);
		expectedOrderDTO.setPackageDTOList(listOfPackage);

		// Then
		assertEquals(
				objectMapper.writeValueAsString(expectedOrderDTO),
				objectMapper.writeValueAsString(orderProcessor.returnOrderDetail(productCode, quantity))
				);
	}
}

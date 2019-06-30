package com.rt.bakery.order.processor;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rt.bakery.order.dto.OrderDTO;
import com.rt.bakery.order.dto.PackageDTO;

public class OrderProcessorTest {
	@Test
	public void givenProductCodeVS5AndQuantiy10ShouldReturnOrderDetail() throws JsonProcessingException {
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
				objectMapper.writeValueAsString(orderProcessor.processOrder(productCode, quantity))
				);
	}

	@Test
	public void givenProductCodeMB11AndQuantiy14ShouldReturnOrderDetail() throws JsonProcessingException {
		// Given
		String productCode = "MB11";
		int quantity = 14;
		OrderProcessor orderProcessor = new OrderProcessor();
		OrderDTO expectedOrderDTO = new OrderDTO();
		ObjectMapper objectMapper = new ObjectMapper();

		// When
		expectedOrderDTO.setProductName("MB11");
		expectedOrderDTO.setTotalQuantity(14);
		expectedOrderDTO.setTotalCost(54.8);
		List<PackageDTO> listOfPackage = new ArrayList<PackageDTO>();
		PackageDTO packOne = new PackageDTO();
		packOne.setNoOfPacks(1);
		packOne.setPackOf(8);
		packOne.setCostPerPack(24.95);
		listOfPackage.add(packOne);
		PackageDTO packTwo = new PackageDTO();
		packTwo.setNoOfPacks(3);
		packTwo.setPackOf(2);
		packTwo.setCostPerPack(9.95);
		listOfPackage.add(packTwo);

		expectedOrderDTO.setPackageDTOList(listOfPackage);

		// Then
		assertEquals(
				objectMapper.writeValueAsString(expectedOrderDTO),
				objectMapper.writeValueAsString(orderProcessor.processOrder(productCode, quantity))
				);
	}
}

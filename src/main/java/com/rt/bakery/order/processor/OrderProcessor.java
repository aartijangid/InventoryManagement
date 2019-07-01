package com.rt.bakery.order.processor;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import com.rt.bakery.inventory.BakeryInventoryManager;
import com.rt.bakery.order.dto.OrderDTO;
import com.rt.bakery.order.dto.PackageDTO;
import com.rt.bakery.product.beans.ProductNameCode;
import com.rt.bakery.product.beans.ProductPackageDetails;

public class OrderProcessor {

	private HashMap<Integer, Double> packageMap;
	private List<Integer> packages;
	private OrderDTO orderDTO = new OrderDTO();
	private List<PackageDTO> packageDTOList = null;
	private double totalCost = 0.0;

	public OrderDTO processOrder(String productCode, int quantity) {
		packageMap = new HashMap<Integer, Double>();
		packages = new ArrayList<Integer>();
		packageDTOList = new ArrayList<PackageDTO>();
		DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
		DecimalFormat df = new DecimalFormat("$ #.##", symbols);

		ProductNameCode inventoryProductDetails = BakeryInventoryManager.productMap.get(productCode);

		orderDTO.setProductName(productCode);
		orderDTO.setTotalQuantity(quantity);

		for(ProductPackageDetails packageDetail : inventoryProductDetails.getPackageDetailsArray()) {
			packageMap.put(packageDetail.getPackOf(), packageDetail.getCostOfPack());
			packages.add(packageDetail.getPackOf());
		}

		int mod = 0;
		double div = 0;
		Collections.sort(packages, Collections.reverseOrder());

		for(int i=0; i < packages.size(); i++) {
			if(packages.get(i) <= quantity) {
				mod = quantity % packages.get(i);
				div = quantity / packages.get(i);

				if(mod == 0) {
					packageDTOList.add(addPack((int)div, packages.get(i), packageMap.get(packages.get(i))));
					totalCost = totalCost + (div * packageMap.get(packages.get(i)));
					break;
				} else if(i != packages.size()-1) {
					if((mod / packages.get(i+1) > 0) || (div <= 0 && (mod / packages.get(i+1)) > 0)) {
						packageDTOList.add(addPack((int)div, packages.get(i), packageMap.get(packages.get(i))));
						totalCost = totalCost + (div * packageMap.get(packages.get(i)));
						quantity = mod;
					}
				}
			}
		}
		if(mod == 0) {
			orderDTO.setTotalCost(df.format(totalCost));
			orderDTO.setPackageDTOList(packageDTOList);
			return orderDTO;
		}else
			throw new RuntimeException("Order can not be processed!");
	}

	private PackageDTO addPack(int noOfPack, Integer packOf, Double costPerPack) {
		PackageDTO packageDetails = new PackageDTO();
		packageDetails.setNoOfPacks(noOfPack);
		packageDetails.setPackOf(packOf);
		packageDetails.setCostPerPack(costPerPack);
		return packageDetails;
	}
}

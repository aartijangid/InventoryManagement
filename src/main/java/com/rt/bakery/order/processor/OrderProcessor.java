package com.rt.bakery.order.processor;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

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
		DecimalFormat df = new DecimalFormat("#.##");
		
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
					PackageDTO packageDetails = new PackageDTO();
					packageDetails.setNoOfPacks((int) div);
					packageDetails.setPackOf(packages.get(i));
					packageDetails.setCostPerPack(packageMap.get(packages.get(i)));
					packageDTOList.add(packageDetails);
					totalCost = totalCost + (div * packageMap.get(packages.get(i)));
					break;
				} else if((mod / packages.get(i+1) > 0) || (div <= 0 && (mod / packages.get(i+1)) > 0)) {
					PackageDTO packageDetails = new PackageDTO();
					packageDetails.setNoOfPacks((int) div);
					packageDetails.setPackOf(packages.get(i));
					packageDetails.setCostPerPack(packageMap.get(packages.get(i)));
					packageDTOList.add(packageDetails);
					totalCost = totalCost + (div * packageMap.get(packages.get(i)));
					quantity = mod;
				}
			}
		}

		orderDTO.setTotalCost(df.format(totalCost));
		orderDTO.setPackageDTOList(packageDTOList);
		return orderDTO;
	}
}

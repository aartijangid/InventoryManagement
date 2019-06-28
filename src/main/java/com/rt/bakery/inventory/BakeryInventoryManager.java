package com.rt.bakery.inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.rt.bakery.product.beans.ProductNameCode;
import com.rt.bakery.product.beans.ProductPackageDetails;

public class BakeryInventoryManager {

	public static  Map<String, ProductNameCode> productMap = new HashMap<String, ProductNameCode>();

	static {
		createBakeryProductData();
	}

	public static Map<String, ProductNameCode> createBakeryProductData() {

		productMap = new HashMap<String, ProductNameCode>();

		// Vegemitte Scroll packs added
		ProductNameCode vegemitteScroll = new ProductNameCode();
		vegemitteScroll.setProductCode("VS5");
		vegemitteScroll.setProductName("Vegemitte Scroll");

		ArrayList<ProductPackageDetails> vegemitteScrollPacks = new ArrayList<ProductPackageDetails>();
		ProductPackageDetails vegemitteScrollPack1 = new ProductPackageDetails();
		vegemitteScrollPack1.setPackOf(3);
		vegemitteScrollPack1.setCostOfPack(6.99);
		vegemitteScrollPacks.add(vegemitteScrollPack1);
		ProductPackageDetails vegemitteScrollPack2 = new ProductPackageDetails();
		vegemitteScrollPack2.setPackOf(5);
		vegemitteScrollPack2.setCostOfPack(8.99);
		vegemitteScrollPacks.add(vegemitteScrollPack2);

		vegemitteScroll.setPackageDetailsArray(vegemitteScrollPacks);
		productMap.put("VS5", vegemitteScroll);

		// Blueberry Muffin packs added
		ProductNameCode blueberryMuffin = new ProductNameCode();
		blueberryMuffin.setProductCode("MB11");
		blueberryMuffin.setProductName("Blueberry Muffin");

		ArrayList<ProductPackageDetails> blueberryMuffinPacks = new ArrayList<ProductPackageDetails>();
		ProductPackageDetails blueberryMuffinPack1 = new ProductPackageDetails();
		blueberryMuffinPack1.setPackOf(2);
		blueberryMuffinPack1.setCostOfPack(9.95);
		blueberryMuffinPacks.add(blueberryMuffinPack1);
		ProductPackageDetails blueberryMuffinPack2 = new ProductPackageDetails();
		blueberryMuffinPack2.setPackOf(5);
		blueberryMuffinPack2.setCostOfPack(16.95);
		blueberryMuffinPacks.add(blueberryMuffinPack2);

		ProductPackageDetails blueberryMuffinPack3 = new ProductPackageDetails();
		blueberryMuffinPack3.setPackOf(8);
		blueberryMuffinPack3.setCostOfPack(24.95);
		blueberryMuffinPacks.add(blueberryMuffinPack3);

		blueberryMuffin.setPackageDetailsArray(blueberryMuffinPacks);
		productMap.put("MB11", blueberryMuffin);

		// Croissant packs added
		ProductNameCode croissant = new ProductNameCode();
		croissant.setProductCode("CF");
		croissant.setProductName("Croissant");

		ArrayList<ProductPackageDetails> croissantPacks = new ArrayList<ProductPackageDetails>();
		ProductPackageDetails croissantPack1 = new ProductPackageDetails();
		croissantPack1.setPackOf(3);
		croissantPack1.setCostOfPack(5.95);
		croissantPacks.add(croissantPack1);

		ProductPackageDetails croissantPack2 = new ProductPackageDetails();
		croissantPack2.setPackOf(5);
		croissantPack2.setCostOfPack(9.95);
		croissantPacks.add(croissantPack2);

		ProductPackageDetails croissantPack3 = new ProductPackageDetails();
		croissantPack3.setPackOf(9);
		croissantPack3.setCostOfPack(16.99);
		croissantPacks.add(croissantPack3);

		croissant.setPackageDetailsArray(croissantPacks);
		productMap.put("CF", croissant);

		return productMap;
	}

}

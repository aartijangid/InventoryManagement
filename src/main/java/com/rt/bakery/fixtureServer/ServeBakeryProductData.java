package com.rt.bakery.fixtureServer;

import java.util.HashMap;
import java.util.Map;

import com.rt.bakery.beans.ProductNameCode;

public class ServeBakeryProductData {
	public static Map<String, ProductNameCode> productMap;
	
	public Map<String, ProductNameCode> createBakeryProductData() {
		productMap = new HashMap<String, ProductNameCode>();
		return productMap;
	}
	
}

package com.rt.bakery.inventory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import com.rt.bakery.inventory.BakeryInventoryManager;
import com.rt.bakery.product.beans.ProductNameCode;

public class BakeryInventoryManagerTest {

	@Test
	public void whenProductsAvailableInBakery() throws Exception {
		assertTrue("Bakery Empty", !BakeryInventoryManager.productMap.isEmpty());
	}

	@Test
	public void testIfVegemitteScrollAvailableInBakery() throws Exception {
		assertTrue("Vegemitte Scroll not available",BakeryInventoryManager.productMap.containsKey("VS5"));
	}

	@Test
	public void testIfBlueberryMuffinPacksAvailableInBakery() throws Exception {
		ProductNameCode blueberryMuffin = BakeryInventoryManager.productMap.get("MB11");
		assertTrue("Blueberry Muffin Packs are not available", blueberryMuffin.getPackageDetailsArray().size() > 0);
	}

	@Test
	public void testIfThreePacksOfCroissantsAvailableInBakery() throws Exception {
		ProductNameCode croissant = BakeryInventoryManager.productMap.get("CF");
		assertTrue("Tree Packs of Croissant not available in Bakery", croissant.getPackageDetailsArray().size() == 3);
	}

	@Test
	public void testIfWheatBreadIsNotAvailableInBakery() {
		ProductNameCode wheatBread;
		wheatBread = BakeryInventoryManager.productMap.get("WB");
		assertEquals(null, wheatBread);
	}
}

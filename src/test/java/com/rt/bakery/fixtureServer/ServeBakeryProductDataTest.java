package com.rt.bakery.fixtureServer;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.rt.bakery.beans.ProductNameCode;
import com.rt.bakery.server.main.SpringBootRestApiApplication;

@RunWith(SpringRunner.class)
@WebMvcTest(ServeBakeryProductData.class)
@ContextConfiguration(classes = SpringBootRestApiApplication.class)
public class ServeBakeryProductDataTest {
	ServeBakeryProductData serveBakeryProductData = new ServeBakeryProductData();

	@Test
	public void noProductInBakery() {
		Map<String, ProductNameCode> productMap = serveBakeryProductData.createBakeryProductData();
		
		assertEquals(productMap.isEmpty(), true);
	}

}

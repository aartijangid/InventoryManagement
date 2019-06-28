package com.rt.bakery.product.beans;

import java.util.ArrayList;

public class ProductNameCode{

	private String productName = "";
	private String productCode = "";
	private ArrayList<ProductPackageDetails> packageDetailsArray = null;

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public ArrayList<ProductPackageDetails> getPackageDetailsArray() {
		return packageDetailsArray;
	}
	public void setPackageDetailsArray(ArrayList<ProductPackageDetails> packageDetailsArray) {
		this.packageDetailsArray = packageDetailsArray;
	}

}

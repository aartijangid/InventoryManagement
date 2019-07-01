package com.rt.bakery.order.dto;

public class PackageDTO {
	private int noOfPacks = 0;
	private int packOf = 0;
	private double costPerPack = 0.0;
	public int getNoOfPacks() {
		return noOfPacks;
	}
	public void setNoOfPacks(int noOfPacks) {
		this.noOfPacks = noOfPacks;
	}
	public int getPackOf() {
		return packOf;
	}
	public void setPackOf(int packOf) {
		this.packOf = packOf;
	}
	public double getCostPerPack() {
		return costPerPack;
	}
	public void setCostPerPack(double costPerPack) {
		this.costPerPack = costPerPack;
	}

}

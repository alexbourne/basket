package com.alexbourne;

public class Apple implements Item {
	
	private double unitCost = 0.25;
	private double tax = 0.2;
	private final double totalCost;
	
	public Apple() {
		totalCost = unitCost * (1. + tax);
	}
	
	public Apple(double unitCost, double tax) {
		this.unitCost = unitCost;
		this.tax = tax;
		this.totalCost = unitCost * (1. + tax);
	}
	
	@Override
	public double getTotalCost() {
		return totalCost;
	}

	@Override
	public double getUnitCost() {
		return 0.25;
	}

	@Override
	public String toString() {
		return "Apple";
	}

}

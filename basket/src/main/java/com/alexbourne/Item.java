package com.alexbourne;

public interface Item {
	
	/**
	 * Get the total cost of the item including any taxes
	 * 
	 * @return The total cost
	 */
	public double getTotalCost();
	
	/**
	 * Get the individual unit cost of the item excluding any taxes
	 * 
	 * @return the unit cost
	 */
	public double getUnitCost();
	
}

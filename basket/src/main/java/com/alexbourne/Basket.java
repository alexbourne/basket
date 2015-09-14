package com.alexbourne;

public interface Basket {
	/**
	 * Add a new item to the basket
	 * 
	 * @param item The item to add
	 */
	public void    addItem(Item item);
	
	/**
	 * Remove an item from the basket
	 * 
	 * @param item The item to remove from the basket
	 * @return True if the item was removed
	 */
	public boolean removeItem(Item item);
	
	/**
	 * Get the total cost (including taxes) of all the
	 * items in the basket
	 * 
	 * @return The total cost
	 */
	public double  getTotalCost();
	
	/**
	 * Get the total number of items in the basket
	 * 
	 * @return The number of items in the basket
	 */
	public int     size();

}

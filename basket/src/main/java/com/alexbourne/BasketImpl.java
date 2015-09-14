package com.alexbourne;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * A basic implementation of a basket. The items are stored in a list
 * and read/write actions for the basket are protected by a read/write
 * lock.
 * 
 * @author alexbourne
 *
 */
public class BasketImpl implements Basket {
	
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	private ReentrantReadWriteLock.ReadLock r;
	private ReentrantReadWriteLock.WriteLock w;
	
	private List<Item> items = new LinkedList<Item>();
	
	public BasketImpl() {
		r = lock.readLock();
		w = lock.writeLock();
	}

	/**
	 * Add a new item to the basket
	 * 
	 * @param item The item to add
	 */
	@Override
	public void addItem(Item item) {
		try {
			w.lock();
			items.add(item);
		} finally {
			w.unlock();
		}

	}

	/**
	 * Remove an item from the basket
	 * 
	 * @param item The item to remove from the basket
	 * @return True if the item was removed
	 */
	@Override
	public boolean removeItem(Item item) {
		try {
			w.lock();
			return items.remove(item);
		} finally {
			w.unlock();
		}
	}

	/**
	 * Get the total cost (including taxes) of all the
	 * items in the basket
	 * 
	 * @return The total cost
	 */
	@Override
	public double getTotalCost() {
		try {
			r.lock();
			return items.stream().mapToDouble(Item::getTotalCost).sum();
		} finally {
			r.unlock();
		}
	}

	/**
	 * Get the total number of items in the basket
	 * 
	 * @return The number of items in the basket
	 */
	@Override
	public int size() {
		try {
			r.lock();
			return items.size();
		} finally {
			r.unlock();
		}
	}

}

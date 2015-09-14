package com.alexbourne;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BasketTest {
	
	@Test
	public void emptyBasketCostsZero() {
		Basket aBasket = new BasketImpl();
		assertThat(aBasket.size(), equalTo(0));
		assertThat(aBasket.getTotalCost(), equalTo(0.));
	}
	
	@Test
	public void twoBananasInBasket() {
		Basket aBasket = new BasketImpl();
		
		Banana banana = new Banana();
		
		aBasket.addItem(banana);
		aBasket.addItem(banana);
		
		assertThat(aBasket.size(), equalTo(2));
		assertThat(aBasket.getTotalCost(), equalTo(0.60));
	}
	
	@Test
	public void selectionOfFruit() {
		Basket aBasket = new BasketImpl();
		
		aBasket.addItem(new Banana());
		aBasket.addItem(new Orange());
		aBasket.addItem(new Lemon());
		aBasket.addItem(new Peach());
		aBasket.addItem(new Banana());
		aBasket.addItem(new Apple());
		aBasket.addItem(new Lemon());
		aBasket.addItem(new Orange());
		
		assertThat(aBasket.size(), equalTo(8));
		assertThat(aBasket.getTotalCost(), equalTo(4.26));
	}
	
	@Test
	public void removeItemNotInBasketReturnsFalse() {
		Basket aBasket = new BasketImpl();
		
		Banana banana = new Banana();
		Peach  peach  = new Peach();
		
		aBasket.addItem(banana);
		
		assertThat(aBasket.size(), equalTo(1));
		assertFalse(aBasket.removeItem(peach));
		assertThat(aBasket.size(), equalTo(1));
	}
	
	@Test
	public void removeItemInBasketReturnsTrue() {
		Basket aBasket = new BasketImpl();
		
		Banana banana = new Banana();
		Peach  peach  = new Peach();
		
		aBasket.addItem(banana);
		aBasket.addItem(peach);
		
		assertThat(aBasket.size(), equalTo(2));
		assertTrue(aBasket.removeItem(peach));
		assertThat(aBasket.size(), equalTo(1));
	}

}

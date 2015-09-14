package com.alexbourne;

public class Main {

	public static void main(String[] args) {
		
		Basket fruitBasket = new BasketImpl();
		
		fruitBasket.addItem(new Banana());
		fruitBasket.addItem(new Orange());
		fruitBasket.addItem(new Lemon());
		fruitBasket.addItem(new Peach());
		fruitBasket.addItem(new Banana());
		
		System.out.format("Total cost of basket is: £%-5.2f", fruitBasket.getTotalCost());
	}
}

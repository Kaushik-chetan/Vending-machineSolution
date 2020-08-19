package com.vm.beans;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {

	private static VendingMachine vendingMachine;

	private Map<Product, Integer> products = new HashMap<>();

	private Map<Coin, Integer> coins = new HashMap<>();

	public static VendingMachine getVendingmachine() {
		if (vendingMachine != null) {
			return vendingMachine;
		}
		vendingMachine = new VendingMachine();
		return vendingMachine;
	}

	private VendingMachine() {
		for (Product product : Product.values()) {
			products.put(product, 10);
		}
		for (Coin coin : Coin.values()) {
			coins.put(coin, 10);
		}
	}

	public Map<Product, Integer> getProducts() {
		return products;
	}

	public Map<Coin, Integer> getCoins() {
		return coins;
	}

}

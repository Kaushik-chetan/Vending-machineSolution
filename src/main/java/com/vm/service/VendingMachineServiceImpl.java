package com.vm.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vm.beans.Coin;
import com.vm.beans.Product;
import com.vm.beans.VendingMachine;
import com.vm.exception.LesserAmountPaidException;
import com.vm.exception.NotEnoughChangeException;
import com.vm.exception.ProductOutOfStockException;

public class VendingMachineServiceImpl implements VendingMachineService{
	
	private VendingMachine vendingMachine = VendingMachine.getVendingmachine();
	
	private Product selectedProduct;
	
	private Coin selectedCoin;
	
	private List<Coin> change = new ArrayList<>();

	@Override
	public int selectProduct(Product product) {
		
		if(vendingMachine.getProducts().get(product)< 0) {
			throw new ProductOutOfStockException("Sorry. product is out of stock. please select any other product");
		} else {
			selectedProduct = product;
			return product.getPrice();
		} 
	}

	@Override
	public void getCoin(Coin coin) {
		if(coin.getValue() < selectedProduct.getPrice()) {
			throw new LesserAmountPaidException("Sorry. Coin value is less than product price. Please pay full price. Extra amount need to pay :" + (selectedProduct.getPrice() - coin.getValue()) );
		} else {
			selectedCoin = coin;
			
			// checking for change as well as storing change for return.
			
			getChange(coin.getValue());			
		}
			// 
	}

	@Override
	public Map<Product, List<Coin>> returnProductWithChange() {
		vendingMachine.getProducts().put(selectedProduct, vendingMachine.getProducts().get(selectedProduct)-1);
		vendingMachine.getCoins().put(selectedCoin, vendingMachine.getCoins().get(selectedCoin)-1);
		Map<Product, List<Coin>> productWithChange = new HashMap<>();
		productWithChange.put(selectedProduct, change);
		return productWithChange;
	}
	
	private void getChange(int coinValue) {
		List<Coin> coinsForChange = new ArrayList<>();
		int changeRequired = coinValue - selectedProduct.getPrice();
		Map<Coin, Integer> availableCoins = new HashMap<>();
		availableCoins.putAll(vendingMachine.getCoins());
		Coin[] coins = Coin.values();
		Arrays.sort(coins, (c1, c2) -> Integer.compare(c2.getValue(), c1.getValue()));
		for (Coin coin : coins) {
			if (availableCoins.get(coin) > 0 && changeRequired >= coin.getValue()) {
				int count = availableCoins.get(coin);
				while (count > 0 && changeRequired >= coin.getValue()) {
					changeRequired = changeRequired - coin.getValue();
					availableCoins.put(coin, availableCoins.get(coin) - 1);
					coinsForChange.add(coin);
					if(changeRequired == 0) {
						break;
					}
				}
				if(changeRequired == 0) {
					break;
				}
			}
		}
		
		if(changeRequired > 0) {
			throw new NotEnoughChangeException("Sorry. vending machine doesn't have enough change");
		} else {
			vendingMachine.getCoins().clear();
			vendingMachine.getCoins().putAll(availableCoins);
			change.clear();
			change.addAll(coinsForChange);
		}
	    
	}	
	
}

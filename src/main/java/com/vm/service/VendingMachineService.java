package com.vm.service;

import java.util.List;
import java.util.Map;

import com.vm.beans.Coin;
import com.vm.beans.Product;

public interface VendingMachineService {

	public int selectProduct(Product product);

	public void getCoin(Coin coin);

	public Map<Product, List<Coin>> returnProductWithChange();

}

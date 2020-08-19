package com.vm.service;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.vm.beans.Coin;
import com.vm.beans.Product;
import com.vm.config.VendingMachineBeanFactory;
import com.vm.exception.LesserAmountPaidException;
import com.vm.exception.ProductOutOfStockException;

public class VendingMachineServiceTest {
	
	private VendingMachineService vendingMachineService = VendingMachineBeanFactory.getVendingMachineService();
	
	@Test
	public void testCompleteVednigMachineFlow() {
		
		List<Coin> expectedChange = Arrays.asList(Coin.DIME, Coin.DIME);
		
		vendingMachineService.selectProduct(Product.CANDY);
		vendingMachineService.getCoin(Coin.QUARTER);
		Map<Product, List<Coin>> productWithChange = vendingMachineService.returnProductWithChange();
		
		assertEquals(Product.CANDY, productWithChange.keySet().iterator().next());
		
		assertEquals(expectedChange, productWithChange.values().iterator().next());
		
	}

	@Test
	public void testSelectProduct() {
		int chocolateProce = vendingMachineService.selectProduct(Product.CHOCOLATE);
		assertEquals(15, chocolateProce);
	}
	
	@Test(expected = LesserAmountPaidException.class)
	public void getCoin_lesserAmoutpaidException() {
		vendingMachineService.selectProduct(Product.CHOCOLATE);
		vendingMachineService.getCoin(Coin.CENT);
	}
	
	
	
	

}

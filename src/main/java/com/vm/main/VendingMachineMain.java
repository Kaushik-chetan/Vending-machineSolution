package com.vm.main;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.vm.beans.Coin;
import com.vm.beans.Product;
import com.vm.config.VendingMachineBeanFactory;
import com.vm.service.VendingMachineService;

public class VendingMachineMain {
	
	public static void main(String[] args) {
		
		VendingMachineService vendingMachineService = VendingMachineBeanFactory.getVendingMachineService();
		
		vendingMachineService.selectProduct(Product.CANDY);
		
	    vendingMachineService.getCoin(Coin.QUARTER);
	    
	    Map<Product, List<Coin>> productWithChange =  vendingMachineService.returnProductWithChange();
	    
	    System.out.print("Product return is : ");
	    
	    Iterator<Product> iterator = productWithChange.keySet().iterator();
	    
	    while(iterator.hasNext()) {
	    	System.out.println(iterator.next());
	    }
	    
	    System.out.print("Change return are : ");
	    
	    productWithChange.values().forEach(coin -> System.out.print(coin.toString() + ' '));
	
	}

}

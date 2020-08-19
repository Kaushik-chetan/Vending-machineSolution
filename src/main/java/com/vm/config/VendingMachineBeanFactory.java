package com.vm.config;

import com.vm.service.VendingMachineService;
import com.vm.service.VendingMachineServiceImpl;

public class VendingMachineBeanFactory {
	
	public static VendingMachineService getVendingMachineService() {
		return new VendingMachineServiceImpl();
	}

}

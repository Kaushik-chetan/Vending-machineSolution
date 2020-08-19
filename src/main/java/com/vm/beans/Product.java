package com.vm.beans;

public enum Product {

	CHOCOLATE(15), CANDY(5), COLDDRINK(40);

	private int price;

	private Product(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}
}

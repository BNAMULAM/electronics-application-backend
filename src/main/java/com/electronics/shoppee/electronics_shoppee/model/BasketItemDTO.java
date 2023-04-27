package com.electronics.shoppee.electronics_shoppee.model;

import java.util.List;

import lombok.Data;
import lombok.ToString;


public class BasketItemDTO {

	private long quantity;
	private double total;
	private List<ProducDTO> products;
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public List<ProducDTO> getProducts() {
		return products;
	}
	public void setProducts(List<ProducDTO> products) {
		this.products = products;
	}
	
	
}

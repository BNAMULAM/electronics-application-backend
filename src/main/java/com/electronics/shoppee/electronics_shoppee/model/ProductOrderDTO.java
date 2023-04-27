package com.electronics.shoppee.electronics_shoppee.model;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;
import lombok.ToString;


public class ProductOrderDTO {
	

	private LocalDate orderDate;
	private double totalAmount;	
	private String orderStatus;
	private List<Integer> products;
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public List<Integer> getProducts() {
		return products;
	}
	public void setProducts(List<Integer> products) {
		this.products = products;
	}
	
	
	
}

package com.electronics.shoppee.electronics_shoppee.model;

import java.util.List;

//import com.electronics.shoppee.electronics_shoppee.entity.BasketEntity;
//import com.electronics.shoppee.electronics_shoppee.entity.BasketItemEntity;
//import com.electronics.shoppee.electronics_shoppee.entity.CustomerEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;


public class BasketDTO {

	private int productCount;
	private double total;
	private List<Integer> productIds;
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public List<Integer> getProductIds() {
		return productIds;
	}
	public void setProductIds(List<Integer> productIds) {
		this.productIds = productIds;
	}
	
	
}

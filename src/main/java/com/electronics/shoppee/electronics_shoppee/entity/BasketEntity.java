package com.electronics.shoppee.electronics_shoppee.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name="basket")

public class BasketEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int basketId;
	private int productCount;
	private double total;
	

	@OneToMany(targetEntity = ProductEntity.class)
	private List<ProductEntity> products;


	public int getBasketId() {
		return basketId;
	}


	public void setBasketId(int basketId) {
		this.basketId = basketId;
	}


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


	public List<ProductEntity> getProducts() {
		return products;
	}


	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}
	
	

}

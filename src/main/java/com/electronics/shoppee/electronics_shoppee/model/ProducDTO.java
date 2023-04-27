package com.electronics.shoppee.electronics_shoppee.model;

import java.time.LocalDate;
import java.util.List;

import com.electronics.shoppee.electronics_shoppee.entity.ProductTypeEntity;

import lombok.Data;
import lombok.ToString;



public class ProducDTO {

	private String  productName;
	private double productPrice;
	private String image;
	private LocalDate createDate;
	private int productTypeId;
	
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public LocalDate getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}
	public int getProductTypeId() {
		return productTypeId;
	}
	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}
	
	
	
}

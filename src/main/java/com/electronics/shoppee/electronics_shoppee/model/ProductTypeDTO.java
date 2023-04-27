package com.electronics.shoppee.electronics_shoppee.model;

import java.util.List;

import com.electronics.shoppee.electronics_shoppee.entity.ProductEntity;
import com.electronics.shoppee.electronics_shoppee.entity.ProductTypeEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;


public class ProductTypeDTO {
	private String productTypeName;

	public String getProductTypeName() {
		return productTypeName;
	}

	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}
	
	

}

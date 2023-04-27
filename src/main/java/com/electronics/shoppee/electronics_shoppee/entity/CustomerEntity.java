package com.electronics.shoppee.electronics_shoppee.entity;

import java.util.ArrayList;
import java.util.List;

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
@Table(name="customer")

public class CustomerEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	private String customerName;
	private String email;
	private String phoneNum;
	
	@OneToOne
	@JoinColumn(name="addressId")
	private AddressEntity address;
	
	@OneToOne
	@JoinColumn(name="basketId")
	private BasketEntity basket;
	 
	@OneToMany(targetEntity = ProductOrderEntity.class)
	private List<ProductOrderEntity> orders;
	
	@OneToOne
	@JoinColumn(name="userId")
	private UserEntity userentity;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

	public BasketEntity getBasket() {
		return basket;
	}

	public void setBasket(BasketEntity basket) {
		this.basket = basket;
	}

	public List<ProductOrderEntity> getOrders() {
		return orders;
	}

	public void setOrders(List<ProductOrderEntity> orders) {
		this.orders = orders;
	}

	public UserEntity getUserentity() {
		return userentity;
	}

	public void setUserentity(UserEntity userentity) {
		this.userentity = userentity;
	}
	
	
	

}

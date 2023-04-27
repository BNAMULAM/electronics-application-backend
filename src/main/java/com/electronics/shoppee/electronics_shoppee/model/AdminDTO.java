package com.electronics.shoppee.electronics_shoppee.model;

import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.electronics.shoppee.electronics_shoppee.entity.AddressEntity;
import com.electronics.shoppee.electronics_shoppee.entity.BasketEntity;
import com.electronics.shoppee.electronics_shoppee.entity.CustomerEntity;
import com.electronics.shoppee.electronics_shoppee.entity.ProductOrderEntity;
import com.electronics.shoppee.electronics_shoppee.entity.UserEntity;

import lombok.Data;
import lombok.ToString;


public class AdminDTO {
	
	private String name;
	private String email;
	private String phoneNum;
	private UserEntity userDetails;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public UserEntity getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserEntity userDetails) {
		this.userDetails = userDetails;
	}
	
	
}

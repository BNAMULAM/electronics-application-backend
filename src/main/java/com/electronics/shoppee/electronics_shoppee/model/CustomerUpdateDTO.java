package com.electronics.shoppee.electronics_shoppee.model;

import java.util.List;

import com.electronics.shoppee.electronics_shoppee.entity.AddressEntity;
import com.electronics.shoppee.electronics_shoppee.entity.BasketEntity;
import com.electronics.shoppee.electronics_shoppee.entity.CustomerEntity;
import com.electronics.shoppee.electronics_shoppee.entity.ProductOrderEntity;
import com.electronics.shoppee.electronics_shoppee.entity.UserEntity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CustomerUpdateDTO {
	private String customerName;
	private String email;
	private String phoneNum;
	private AddressDTO address;
	private UserDTO userDetails;
	private int backetId;
	private List<Integer> orderIds;
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
	public AddressDTO getAddress() {
		return address;
	}
	public void setAddress(AddressDTO address) {
		this.address = address;
	}
	public UserDTO getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDTO userDetails) {
		this.userDetails = userDetails;
	}
	public int getBacketId() {
		return backetId;
	}
	public void setBacketId(int backetId) {
		this.backetId = backetId;
	}
	public List<Integer> getOrderIds() {
		return orderIds;
	}
	public void setOrderIds(List<Integer> orderIds) {
		this.orderIds = orderIds;
	}
	
	
}

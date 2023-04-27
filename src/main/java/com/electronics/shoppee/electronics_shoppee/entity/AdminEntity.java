package com.electronics.shoppee.electronics_shoppee.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name="manager")

public class AdminEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int managerId;
	private String name;
	private String email;
	private String phoneNum;
	@OneToOne
	@JoinColumn(name="userId")
	private UserEntity userentity;
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
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
	public UserEntity getUserentity() {
		return userentity;
	}
	public void setUserentity(UserEntity userentity) {
		this.userentity = userentity;
	}
	
}

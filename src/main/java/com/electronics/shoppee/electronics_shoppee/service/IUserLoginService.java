package com.electronics.shoppee.electronics_shoppee.service;

import com.electronics.shoppee.electronics_shoppee.entity.UserEntity;

public interface IUserLoginService {
	
	public UserEntity regestration(UserEntity userentity);
	public UserEntity login(String username,String password);

}

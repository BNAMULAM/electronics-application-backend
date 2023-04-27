package com.electronics.shoppee.electronics_shoppee.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electronics.shoppee.electronics_shoppee.Repository.IUserRepo;
import com.electronics.shoppee.electronics_shoppee.entity.UserEntity;
import com.electronics.shoppee.electronics_shoppee.exception.DoesnotExistsException;
import com.electronics.shoppee.electronics_shoppee.service.IUserLoginService;

@Service
public class UserLoginServiceImpl implements IUserLoginService {
	
	@Autowired
	private IUserRepo repo;

	@Override
	public UserEntity regestration(UserEntity userentity) {
		// TODO Auto-generated method stub
		this.repo.save(userentity);
		return userentity;
	
	}

	@Override
	public UserEntity login(String username, String password) {
		// TODO Auto-generated method stub
		 UserEntity login=repo.findByUsername(username);
		 if(login!=null && login.getPassword().equals(password)) {
			 return login;
		 }
	 throw new DoesnotExistsException("Not Found");
	}
		

}

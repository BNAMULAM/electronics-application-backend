package com.electronics.shoppee.electronics_shoppee.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electronics.shoppee.electronics_shoppee.Repository.IManagerRepo;
import com.electronics.shoppee.electronics_shoppee.Repository.IUserRepo;
import com.electronics.shoppee.electronics_shoppee.entity.AdminEntity;
import com.electronics.shoppee.electronics_shoppee.entity.UserEntity;
import com.electronics.shoppee.electronics_shoppee.exception.AlreadyExistsException;
import com.electronics.shoppee.electronics_shoppee.exception.DoesnotExistsException;
import com.electronics.shoppee.electronics_shoppee.model.AdminDTO;
import com.electronics.shoppee.electronics_shoppee.service.IAdminService;

@Service
public class AdminServiceImpl implements IAdminService{

	@Autowired
	private IManagerRepo iManagerRepo;
	
	@Autowired
	private IUserRepo iUserRepo;
	
	@Override
	public AdminEntity addManager(AdminDTO managerDTO) {
			if(iUserRepo.findById(managerDTO.getUserDetails().getUsername()).isEmpty()) {
				AdminEntity managerEntity = new AdminEntity();
				managerEntity.setEmail(managerDTO.getEmail());
				managerEntity.setName(managerDTO.getName());
				managerEntity.setPhoneNum(managerDTO.getPhoneNum());
				
				UserEntity userEntity = new UserEntity();
				userEntity.setPassword(managerDTO.getUserDetails().getPassword());
				userEntity.setRole(managerDTO.getUserDetails().getRole());
				userEntity.setUsername(managerDTO.getUserDetails().getUsername());
				userEntity = iUserRepo.save(userEntity);
				managerEntity.setUserentity(userEntity);

				managerEntity = iManagerRepo.save(managerEntity);
				
				return managerEntity;
			}
			else {
				throw new AlreadyExistsException("User already esists with username: "+managerDTO.getUserDetails().getUsername());
			}
	}

	@Override
	public AdminEntity updateManager(int id, AdminDTO managerDTO) {
		if(iManagerRepo.findById(id).isPresent()) {
			if(iUserRepo.findById(managerDTO.getUserDetails().getUsername()).isEmpty()) {
				AdminEntity managerEntity = new AdminEntity();
				managerEntity.setEmail(managerDTO.getEmail());
				managerEntity.setName(managerDTO.getName());
				managerEntity.setPhoneNum(managerDTO.getPhoneNum());
				
				UserEntity userEntity = new UserEntity();
				userEntity.setPassword(managerDTO.getUserDetails().getPassword());
				userEntity.setRole(managerDTO.getUserDetails().getRole());
				userEntity.setUsername(managerDTO.getUserDetails().getUsername());
				managerEntity.setUserentity(userEntity);
				managerEntity.setManagerId(id);
				managerEntity = iManagerRepo.save(managerEntity);
				
				return managerEntity;
			}
			else {
				throw new AlreadyExistsException("User already esists with username: "+managerDTO.getUserDetails().getUsername());
			}

		}
		else {
			throw new DoesnotExistsException("Manager with the Id doesn't exists: "+id);
		}
	}

	@Override
	public AdminEntity deleteManager(int id) {
		if(iManagerRepo.findById(id).isPresent()) {
			AdminEntity managerEntity = iManagerRepo.findById(id).get();
			iManagerRepo.deleteById(id);
			return managerEntity;
		}
		else {
			throw new DoesnotExistsException("Manager with the Id doesn't exists: "+id);
		}
	}

	@Override
	public AdminEntity getManagerId(int id) {
		if(iManagerRepo.findById(id).isPresent()) {
			AdminEntity managerEntity = iManagerRepo.findById(id).get(); 
			return managerEntity;
		}
		else {
			throw new DoesnotExistsException("Manager with the Id doesn't exists: "+id);
		}
	}

	@Override
	public List<AdminEntity> getAllManager() {
		List<AdminEntity> managerEntityList = iManagerRepo.findAll(); 
		return managerEntityList;
	}

}

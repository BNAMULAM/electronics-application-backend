package com.electronics.shoppee.electronics_shoppee.service;

import java.util.List;

import com.electronics.shoppee.electronics_shoppee.entity.AdminEntity;
import com.electronics.shoppee.electronics_shoppee.model.AdminDTO;

public interface IAdminService {

	AdminEntity addManager(AdminDTO managerDTO);

	AdminEntity updateManager(int id, AdminDTO managerDTO);

	AdminEntity deleteManager(int id);

	AdminEntity getManagerId(int id);

	List<AdminEntity> getAllManager();

}

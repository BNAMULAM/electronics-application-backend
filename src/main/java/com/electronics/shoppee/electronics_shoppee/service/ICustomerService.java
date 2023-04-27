package com.electronics.shoppee.electronics_shoppee.service;

import java.util.List;

import com.electronics.shoppee.electronics_shoppee.entity.CustomerEntity;
import com.electronics.shoppee.electronics_shoppee.model.CustomerAddDTO;
import com.electronics.shoppee.electronics_shoppee.model.CustomerUpdateDTO;

public interface ICustomerService {

	CustomerEntity addCustomer(CustomerAddDTO customerAddDTO);

	CustomerEntity updateCustomer(int id, CustomerUpdateDTO customerUpdateDTO);

	CustomerEntity deleteCustomer(int id);

	CustomerEntity getCustomerId(int id);

	List<CustomerEntity> getAllCustomer();

	CustomerEntity getCustomerUserName(String userName);

	CustomerEntity updateCustomerOrder(int customerId, int orderId);

}

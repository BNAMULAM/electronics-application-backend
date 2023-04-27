package com.electronics.shoppee.electronics_shoppee.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electronics.shoppee.electronics_shoppee.Repository.IAddressRepo;
import com.electronics.shoppee.electronics_shoppee.Repository.IBasketRepo;
import com.electronics.shoppee.electronics_shoppee.Repository.ICustomerRepo;
import com.electronics.shoppee.electronics_shoppee.Repository.IProductOrderRepo;
import com.electronics.shoppee.electronics_shoppee.Repository.IUserRepo;
import com.electronics.shoppee.electronics_shoppee.entity.AddressEntity;
import com.electronics.shoppee.electronics_shoppee.entity.BasketEntity;
import com.electronics.shoppee.electronics_shoppee.entity.CustomerEntity;
import com.electronics.shoppee.electronics_shoppee.entity.ProductOrderEntity;
import com.electronics.shoppee.electronics_shoppee.entity.UserEntity;
import com.electronics.shoppee.electronics_shoppee.exception.AlreadyExistsException;
import com.electronics.shoppee.electronics_shoppee.exception.DoesnotExistsException;
import com.electronics.shoppee.electronics_shoppee.model.CustomerAddDTO;
import com.electronics.shoppee.electronics_shoppee.model.CustomerUpdateDTO;
import com.electronics.shoppee.electronics_shoppee.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private IUserRepo iUserRepo;
	
	@Autowired
	private ICustomerRepo iCustomerRepo;
	
	@Autowired
	private IBasketRepo iBasketRepo;
	
	@Autowired
	private IProductOrderRepo iProductOrderRepo;
	
	@Autowired IAddressRepo iAddressRepo;

	@Override
	public CustomerEntity addCustomer(CustomerAddDTO customerAddDTO) {
			if(iUserRepo.findById(customerAddDTO.getUserDetails().getUsername()).isEmpty()) {
				CustomerEntity customerEntity= new CustomerEntity();
				customerEntity.setCustomerName(customerAddDTO.getCustomerName());
				customerEntity.setEmail(customerAddDTO.getEmail());
				customerEntity.setPhoneNum(customerAddDTO.getPhoneNum());
				BasketEntity basketEntity = new BasketEntity();
				basketEntity.setProductCount(0);
				basketEntity.setProducts(null);
				basketEntity.setTotal(0);
				basketEntity = iBasketRepo.save(basketEntity);
				customerEntity.setBasket(basketEntity);
				customerEntity.setOrders(null);
				
				AddressEntity addressEntity = new AddressEntity();
				addressEntity.setCity(customerAddDTO.getAddress().getCity());
				addressEntity.setCountry(customerAddDTO.getAddress().getCountry());
				addressEntity.setLine1(customerAddDTO.getAddress().getLine1());
				addressEntity.setLine2(customerAddDTO.getAddress().getLine2());
				addressEntity.setPostalcode(customerAddDTO.getAddress().getPostalcode());
				addressEntity.setState(customerAddDTO.getAddress().getState());
				addressEntity = iAddressRepo.save(addressEntity);
				customerEntity.setAddress(addressEntity);
				
				UserEntity userEntity = new UserEntity();
				userEntity.setPassword(customerAddDTO.getUserDetails().getPassword());
				userEntity.setRole(customerAddDTO.getUserDetails().getRole());
				userEntity.setUsername(customerAddDTO.getUserDetails().getUsername());
				userEntity = iUserRepo.save(userEntity);
				customerEntity.setUserentity(userEntity);
				
				customerEntity = iCustomerRepo.save(customerEntity);
				
 				return customerEntity;
				
			}else {
				throw new AlreadyExistsException("User already esists with username: "+customerAddDTO.getUserDetails().getUsername());
			}
	}

	@Override
	public CustomerEntity updateCustomer(int id, CustomerUpdateDTO customerUpdateDTO) {
		if(iCustomerRepo.findById(id).isPresent()) {
			//if(iUserRepo.findById(customerUpdateDTO.getUserDetails().getUsername()).isEmpty())
			{
				if(iBasketRepo.findById(customerUpdateDTO.getBacketId()).isEmpty()) {
					throw new DoesnotExistsException("Basket with the id doesn't exists: "+customerUpdateDTO.getBacketId());
				}
				List<ProductOrderEntity> ProductOrderEntityList = new ArrayList<>();
				for(int orderId:customerUpdateDTO.getOrderIds() ) {
					if(iProductOrderRepo.findById(orderId).isPresent()) {
						ProductOrderEntityList.add(iProductOrderRepo.findById(orderId).get());
					}
					else {
						throw new DoesnotExistsException("Order with the id doesn't exists: "+orderId);
					}
				}
				CustomerEntity customerEntity= new CustomerEntity();
				customerEntity.setCustomerName(customerUpdateDTO.getCustomerName());
				customerEntity.setEmail(customerUpdateDTO.getEmail());
				customerEntity.setPhoneNum(customerUpdateDTO.getPhoneNum());
				customerEntity.setBasket(iBasketRepo.findById(customerUpdateDTO.getBacketId()).get());
				customerEntity.setOrders(ProductOrderEntityList);
				
				AddressEntity addressEntity = new AddressEntity();
				addressEntity.setCity(customerUpdateDTO.getAddress().getCity());
				addressEntity.setCountry(customerUpdateDTO.getAddress().getCountry());
				addressEntity.setLine1(customerUpdateDTO.getAddress().getLine1());
				addressEntity.setLine2(customerUpdateDTO.getAddress().getLine2());
				addressEntity.setPostalcode(customerUpdateDTO.getAddress().getPostalcode());
				addressEntity.setState(customerUpdateDTO.getAddress().getState());
				addressEntity = iAddressRepo.save(addressEntity);
				
				customerEntity.setAddress(addressEntity);
				
				UserEntity userEntity = new UserEntity();
				userEntity.setPassword(customerUpdateDTO.getUserDetails().getPassword());
				userEntity.setRole(customerUpdateDTO.getUserDetails().getRole());
				userEntity.setUsername(customerUpdateDTO.getUserDetails().getUsername());
				userEntity = iUserRepo.save(userEntity);
				customerEntity.setUserentity(userEntity);
				
				customerEntity = iCustomerRepo.save(customerEntity);
				
				return customerEntity;
				
			}
//			else {
//				throw new AlreadyExistsException("User already esists with username: "+customerUpdateDTO.getUserDetails().getUsername());
//			}
		}else {
			throw new DoesnotExistsException("Customer with the id doesn't exists: "+id);
		}
	}

	@Override
	public CustomerEntity deleteCustomer(int id) {
		if(iCustomerRepo.findById(id).isPresent()) {
			CustomerEntity customerEntity=iCustomerRepo.findById(id).get();
			iCustomerRepo.deleteById(id);

			return customerEntity;
		}else {
			throw new DoesnotExistsException("Customer with the id doesn't exists: "+id);
		}
	}

	@Override
	public CustomerEntity getCustomerId(int id) {
		if(iCustomerRepo.findById(id).isPresent()) {
			CustomerEntity customerEntity=iCustomerRepo.findById(id).get();
			return customerEntity;
		}else {
			throw new DoesnotExistsException("Customer with the id doesn't exists: "+id);
		}
	}

	@Override
	public List<CustomerEntity> getAllCustomer() {
		List<CustomerEntity> customerEntityList=iCustomerRepo.findAll();
		return customerEntityList;
	}

	@Override
	public CustomerEntity getCustomerUserName(String userName) {

		List<CustomerEntity> customerEntityList=iCustomerRepo.findAll();
		for(CustomerEntity customerEntity: customerEntityList) {
			if(customerEntity.getUserentity().getUsername().equals(userName)){
				return customerEntity;
			}
		}
		return null;
	}

	@Override
	public CustomerEntity updateCustomerOrder(int customerId, int orderId) {
		if(iCustomerRepo.findById(customerId).isPresent()) {
			if(iProductOrderRepo.findById(orderId).isPresent()) {
				CustomerEntity customerEntity=iCustomerRepo.findById(customerId).get();
				List<ProductOrderEntity> orderList =customerEntity.getOrders();
				orderList.add(iProductOrderRepo.findById(orderId).get());
				customerEntity.setOrders(orderList);
				customerEntity= iCustomerRepo.save(customerEntity);
				return customerEntity;
			}
			else {
				throw new DoesnotExistsException("Order with the id doesn't exists: "+orderId);
			}
			
		}else {
			throw new DoesnotExistsException("Customer with the id doesn't exists: "+customerId);
		}
	}

}

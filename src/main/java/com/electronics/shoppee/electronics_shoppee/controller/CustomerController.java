package com.electronics.shoppee.electronics_shoppee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.electronics.shoppee.electronics_shoppee.entity.CustomerEntity;
import com.electronics.shoppee.electronics_shoppee.entity.ProductTypeEntity;
import com.electronics.shoppee.electronics_shoppee.model.CustomerAddDTO;
import com.electronics.shoppee.electronics_shoppee.model.CustomerUpdateDTO;
import com.electronics.shoppee.electronics_shoppee.service.ICustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private ICustomerService iCustomerService;
	
	@PostMapping("/add-customer")
	ResponseEntity<CustomerEntity> addCustomer(@RequestBody CustomerAddDTO customerAddDTO) {
		return new ResponseEntity<CustomerEntity>(iCustomerService.addCustomer(customerAddDTO),HttpStatus.OK);
	}
	
	@PutMapping("/update-customer")
	ResponseEntity<CustomerEntity> updateCustomer(@RequestParam int id,@RequestBody CustomerUpdateDTO customerUpdateDTO) {
		return new ResponseEntity<CustomerEntity>( iCustomerService.updateCustomer(id,customerUpdateDTO),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-customer")  
	ResponseEntity<CustomerEntity> deleteCustomer(@RequestParam int id) {
		return new ResponseEntity<CustomerEntity>(iCustomerService.deleteCustomer(id),HttpStatus.OK);
	}

	@GetMapping("/get-customer-by-id")
	ResponseEntity<CustomerEntity> getCustomerId(@RequestParam int id) {
		return new ResponseEntity<CustomerEntity>(iCustomerService.getCustomerId(id),HttpStatus.OK);
	}
	
	@GetMapping("/get-all-customer")
	List<CustomerEntity> getAllCustomer() {
		return iCustomerService.getAllCustomer();
	}
	
	@GetMapping("/get-customer-by-userName")
	ResponseEntity<CustomerEntity> getCustomerUserName(@RequestParam String userName) {
		return new ResponseEntity<CustomerEntity>(iCustomerService.getCustomerUserName(userName),HttpStatus.OK);
	}
	
	@PutMapping("/add-customer-order")
	ResponseEntity<CustomerEntity> updateCustomerOrder(@RequestParam int customerId,@RequestParam int orderId) {
		return new ResponseEntity<CustomerEntity>( iCustomerService.updateCustomerOrder(customerId,orderId),HttpStatus.OK);
	}
}

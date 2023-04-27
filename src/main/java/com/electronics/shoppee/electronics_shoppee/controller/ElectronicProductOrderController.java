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

import com.electronics.shoppee.electronics_shoppee.entity.ProductOrderEntity;
import com.electronics.shoppee.electronics_shoppee.model.ProductOrderDTO;
import com.electronics.shoppee.electronics_shoppee.service.IElectronicProdctOrderService;

@RestController
public class ElectronicProductOrderController {
	
	@Autowired
	private IElectronicProdctOrderService iElectronicProdctOrderService;
	
	@PostMapping("/add-product-order")
	ResponseEntity<ProductOrderEntity> addProductOrder(@RequestBody ProductOrderDTO productOrderDTO) {
		return new ResponseEntity<ProductOrderEntity>(iElectronicProdctOrderService.addProductOrder(productOrderDTO),HttpStatus.OK);
	}
	

	@PutMapping("/update-product-order")
	ResponseEntity<ProductOrderEntity>  updateProductOrder(@RequestParam int id, @RequestBody ProductOrderDTO productOrderDTO) {
		return new ResponseEntity<ProductOrderEntity> (iElectronicProdctOrderService.updateProductOrder(id,productOrderDTO),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-product-order")
	ResponseEntity<ProductOrderEntity>  deleteProductOrder(@RequestParam int id) {
		return new ResponseEntity<ProductOrderEntity> (iElectronicProdctOrderService.deleteProductOrder(id),HttpStatus.OK);
	}
	
	@GetMapping("/get-all-product-orders")
        List<ProductOrderEntity> getAllProductOrders() {
		return  iElectronicProdctOrderService.getAllProductOrders();
	}

	@GetMapping("/get-product-order-by-id")
	ResponseEntity<ProductOrderEntity>  getProductOrderById(@RequestParam int id) {
		return new ResponseEntity<ProductOrderEntity>(iElectronicProdctOrderService.getProductOrderById(id),HttpStatus.OK);
	}
}

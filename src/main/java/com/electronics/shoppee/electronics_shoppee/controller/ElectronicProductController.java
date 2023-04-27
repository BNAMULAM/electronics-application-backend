package com.electronics.shoppee.electronics_shoppee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.electronics.shoppee.electronics_shoppee.entity.ProductEntity;
import com.electronics.shoppee.electronics_shoppee.model.ProducDTO;
import com.electronics.shoppee.electronics_shoppee.service.IElectronicProductService;

import org.springframework.web.bind.annotation.RequestBody;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ElectronicProductController {
	
	@Autowired
	private IElectronicProductService iElectronicProductService;
	
	@PostMapping("/add-electronic-product")
	ResponseEntity<ProductEntity> addElectronicProduct(@RequestBody ProducDTO producDTO) {
		return new ResponseEntity<ProductEntity>(iElectronicProductService.addElectronicProduct(producDTO),HttpStatus.OK);
	}
	
	@PutMapping("/update-electronic-product")
	ResponseEntity<ProductEntity> updateElectronicProduct(@RequestParam int id,@RequestBody ProducDTO producDTO) {
		return new ResponseEntity<ProductEntity>(iElectronicProductService.updateElectronicProduct(id,producDTO),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-electronic-product")
	ResponseEntity<ProductEntity> deleteElectronicProduct(@RequestParam int id) {
		return new ResponseEntity<ProductEntity>(iElectronicProductService.deleteElectronicProduct(id),HttpStatus.OK);
	}

	@GetMapping("/get-electronic-product-by-id")
	ResponseEntity<ProductEntity> getElectronicProductById(@RequestParam int id) {
		return new ResponseEntity<ProductEntity>(iElectronicProductService.getElectronicProductById(id),HttpStatus.OK);
	}

	@GetMapping("/get-all-electronic-product")
	List<ProductEntity> getAllElectronicProduct() {
		return iElectronicProductService.getAllElectronicProduct();
	}
}

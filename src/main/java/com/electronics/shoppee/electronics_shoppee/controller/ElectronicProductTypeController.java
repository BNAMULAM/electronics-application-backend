package com.electronics.shoppee.electronics_shoppee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.electronics.shoppee.electronics_shoppee.entity.ProductTypeEntity;
import com.electronics.shoppee.electronics_shoppee.model.ProductTypeDTO;
import com.electronics.shoppee.electronics_shoppee.service.IElectronicProductTypeService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ElectronicProductTypeController {
	
	@Autowired
	private IElectronicProductTypeService iElectronicProductTypeService;
	
	@PostMapping("/add-electronic-product-type")
	ResponseEntity<ProductTypeEntity> addElectronicProductType(@RequestBody ProductTypeDTO productTypeDTO) {
		return new ResponseEntity<ProductTypeEntity>( iElectronicProductTypeService.addElectronicProductType(productTypeDTO),HttpStatus.OK);
	}
	

	@PutMapping("/update-electronic-product-type")
	ResponseEntity<ProductTypeEntity> updateElectronicProductType(@RequestParam int id,@RequestBody ProductTypeDTO productTypeDTO) {
		return new ResponseEntity<ProductTypeEntity>(iElectronicProductTypeService.updateElectronicProductType(id,productTypeDTO),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-electronic-product-type")
	ResponseEntity<ProductTypeEntity> deleteElectronicProductType(@RequestParam int id) {
		return new ResponseEntity<ProductTypeEntity>( iElectronicProductTypeService.deleteElectronicProductType(id),HttpStatus.OK);
	}
	

	@GetMapping("/get-electronic-product-type-by-id")
	ResponseEntity<ProductTypeEntity> getElectronicProductTypeById(@RequestParam int id) {
		return new ResponseEntity<ProductTypeEntity>(iElectronicProductTypeService.getElectronicProductTypeById(id),HttpStatus.OK);
	}
	
	@GetMapping("/get-all-electronic-product-type")
	List<ProductTypeEntity> getElectronicProductTypeById() {
		return  iElectronicProductTypeService.getElectronicProductTypeById();
	}

}

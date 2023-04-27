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

import com.electronics.shoppee.electronics_shoppee.entity.AdminEntity;
import com.electronics.shoppee.electronics_shoppee.model.AdminDTO;
import com.electronics.shoppee.electronics_shoppee.service.IAdminService;


@RestController
public class AdminController {
	
	@Autowired
	private IAdminService iManagerService;
	
	@PostMapping("/add-manager")
	ResponseEntity<AdminEntity> addManager(@RequestBody AdminDTO managerDTO) {
		return new ResponseEntity<AdminEntity>(iManagerService.addManager(managerDTO),HttpStatus.OK);
	}
	
	@PutMapping("/update-manager")
	ResponseEntity<AdminEntity> updateManager(@RequestParam int id,@RequestBody AdminDTO managerDTO) {
		return new ResponseEntity<AdminEntity>(iManagerService.updateManager(id,managerDTO),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-manager")  
	ResponseEntity<AdminEntity> deleteManager(@RequestParam int id) {
		return new ResponseEntity<AdminEntity>(iManagerService.deleteManager(id),HttpStatus.OK);
	}

	@GetMapping("/get-manager-by-id")
	ResponseEntity<AdminEntity> getManagerId(@RequestParam int id) {
		return new ResponseEntity<AdminEntity>(iManagerService.getManagerId(id),HttpStatus.OK);
	}
	
	@GetMapping("/get-all-manager")
	List<AdminEntity> getAllManager() {
		return iManagerService.getAllManager();
	}
}

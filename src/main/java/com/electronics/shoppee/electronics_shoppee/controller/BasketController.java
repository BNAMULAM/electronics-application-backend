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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.electronics.shoppee.electronics_shoppee.entity.BasketEntity;
import com.electronics.shoppee.electronics_shoppee.model.BasketDTO;
import com.electronics.shoppee.electronics_shoppee.service.IBasketService; 
@RestController
public class BasketController {
	
	@Autowired
	private IBasketService iBasketService;
	
	@PostMapping("/add-basket")
	ResponseEntity<BasketEntity> addBasket(@RequestBody BasketDTO basketDTO) {
		return new ResponseEntity<BasketEntity>(iBasketService.addBasket(basketDTO),HttpStatus.OK);
	}
	
	@PutMapping("/update-basket")
	ResponseEntity<BasketEntity> updateBasket(@RequestParam int id, @RequestBody BasketDTO basketDTO) {
		return new ResponseEntity<BasketEntity>(iBasketService.updateBasket(id,basketDTO),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-basket")
	ResponseEntity<BasketEntity> deleteBasket(@RequestParam int id) {
		return new ResponseEntity<BasketEntity>(iBasketService.deleteBasket(id),HttpStatus.OK);
	}

	@GetMapping("/get-basket-by-id")
	ResponseEntity<BasketEntity> getBasketById(@RequestParam int id) {
		return new ResponseEntity<BasketEntity>(iBasketService.getBasketById(id),HttpStatus.OK);
	}
	@GetMapping("/get-all-baskets")
	List<BasketEntity> getAllBaskets() {
		return iBasketService.getAllBaskets();
	}
}

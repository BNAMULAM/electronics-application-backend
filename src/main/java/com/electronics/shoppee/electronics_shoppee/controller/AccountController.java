package com.electronics.shoppee.electronics_shoppee.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.electronics.shoppee.electronics_shoppee.entity.UserEntity;
import com.electronics.shoppee.electronics_shoppee.service.IUserLoginService;

@RestController
public class AccountController {
	 @Autowired
	 private IUserLoginService service;
	 
	 @PostMapping("/register")
	  public UserEntity register(@RequestBody UserEntity userentity) {
	 return this.service.regestration(userentity);
	 }
	  @GetMapping("/login")
	 public UserEntity login(@RequestParam String userName,@RequestParam String password) {
	 return service.login(userName, password);
	 }
  
}

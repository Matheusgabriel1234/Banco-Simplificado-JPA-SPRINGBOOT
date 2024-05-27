package com.example.TestePicpay.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.TestePicpay.Domain.User;
import com.example.TestePicpay.dto.UserDTO;
import com.example.TestePicpay.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userServ;
	
	@PostMapping
	ResponseEntity<User> createUser(@RequestBody UserDTO userDto){
		User user = userServ.createUser(userDto);
		return new ResponseEntity<>(user,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAll(){
		List<User> obj =  this.userServ.getAll();
		return ResponseEntity.ok().body(obj);
	}
	public String getMethodName(@RequestParam String param) {
		return new String();
	}
	
}

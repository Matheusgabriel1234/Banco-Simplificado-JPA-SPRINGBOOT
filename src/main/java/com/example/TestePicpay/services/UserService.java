package com.example.TestePicpay.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TestePicpay.Domain.User;
import com.example.TestePicpay.Domain.UserType;
import com.example.TestePicpay.dto.UserDTO;
import com.example.TestePicpay.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
private UserRepository userRepo;

public List<User> getAll(){
	return this.userRepo.findAll();
	}

public User getByDocument(String document){
 User obj = this.userRepo.findUserByDocument(document).orElse(null);
 return obj;
}

public User getByid(Long id) throws Exception{
	User obj = this.userRepo.findById(id).orElseThrow(() -> new Exception("Usuario não encontrado"));
	return obj;
}

public void validateTransition(User sender, BigDecimal amount) throws Exception {
	if(sender.getUserType() == UserType.MERCHANT) {
		throw new Exception("Lojistas não estão autorizados a fazer transações");
	}
	
	if(sender.getBalance().compareTo(amount) < 0) {
		throw new Exception("Usuario não possue saldo suficiente");
		
	}
}

public User createUser(UserDTO newUser) {
	User obj = new User(newUser);
	this.saveUser(obj);
	return obj;
}

public void saveUser(User user) {
	this.userRepo.save(user);
}

}



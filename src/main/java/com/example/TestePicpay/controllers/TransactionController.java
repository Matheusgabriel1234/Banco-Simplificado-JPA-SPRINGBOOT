package com.example.TestePicpay.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.TestePicpay.Domain.Transaction;
import com.example.TestePicpay.dto.TransactionDTO;
import com.example.TestePicpay.services.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
	
	@Autowired
	TransactionService service;

	@PostMapping
	public ResponseEntity<Transaction> creatTransaction(@RequestBody TransactionDTO transactiondto) throws Exception{
		Transaction obj = service.createTransaction(transactiondto);
		return new ResponseEntity<>(obj,HttpStatus.CREATED);
		
		
	}
}

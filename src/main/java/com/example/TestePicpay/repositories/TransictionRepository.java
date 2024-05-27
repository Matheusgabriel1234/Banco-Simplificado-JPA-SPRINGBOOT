package com.example.TestePicpay.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TestePicpay.Domain.Transaction;

public interface TransictionRepository extends JpaRepository<Transaction, Long>{

	
}

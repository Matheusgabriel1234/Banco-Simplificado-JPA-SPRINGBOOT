package com.example.TestePicpay.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TestePicpay.Domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findUserByDocument(String Document);
}

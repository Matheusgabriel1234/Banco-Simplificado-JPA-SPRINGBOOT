package com.example.TestePicpay.dto;

import java.math.BigDecimal;

import com.example.TestePicpay.Domain.UserType;

public record UserDTO(String firstName,String secondName,String document,BigDecimal balance,String email,String password,UserType userType) {

}

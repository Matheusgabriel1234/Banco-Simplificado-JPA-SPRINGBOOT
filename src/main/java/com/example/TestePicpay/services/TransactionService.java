package com.example.TestePicpay.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.TestePicpay.Domain.Transaction;
import com.example.TestePicpay.Domain.User;
import com.example.TestePicpay.dto.TransactionDTO;
import com.example.TestePicpay.repositories.TransictionRepository;

@Service
public class TransactionService {

	@Autowired
private TransictionRepository repository;
	
	@Autowired
private UserService userService;
	
@Autowired	
private RestTemplate restTemplate;




public Transaction createTransaction(TransactionDTO transaction) throws Exception {
    User sender = this.userService.getByid(transaction.senderId());
    User receiver = this.userService.getByid(transaction.receiverId());
    
    userService.validateTransition(sender, transaction.amount());
    
    if (!this.authorizeTransaction(sender, transaction.amount())) {
        throw new Exception("Transação Não Autorizada");
    }
    
    Transaction obj = new Transaction();
    obj.setAmount(transaction.amount());
    obj.setSender(sender);
    obj.setReceiver(receiver);
    
    sender.setBalance(sender.getBalance().subtract(transaction.amount()));
    receiver.setBalance(receiver.getBalance().add(transaction.amount()));
    
    repository.save(obj);
    userService.saveUser(sender);
    userService.saveUser(receiver);
    
    return obj;
}

public Boolean authorizeTransaction(User sender, BigDecimal amount) {
    ResponseEntity<Map> authResponse = restTemplate.getForEntity("https://util.devi.tools/api/v2/authorize", Map.class);

    if (authResponse.getStatusCode() == HttpStatus.OK) {
        Map<String, Object> responseBody = authResponse.getBody();
        if (responseBody != null && "success".equals(responseBody.get("status"))) {
            Map<String, Object> data = (Map<String, Object>) responseBody.get("data");
            if (data != null && Boolean.TRUE.equals(data.get("authorization"))) {
                return true;
            }
        }
    }
    return false;
}

}

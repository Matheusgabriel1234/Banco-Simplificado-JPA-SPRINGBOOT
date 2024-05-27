package com.example.TestePicpay.Domain;

import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_Transactions")
public class Transaction {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private BigDecimal amount;
@ManyToOne
@JoinColumn(name = "sender_id")
private User sender;
@ManyToOne
@JoinColumn(name = "receiver_id")
private User receiver;

public Transaction() {
	
}

public Transaction(Long id, BigDecimal amount, User sender, User receiver) {
	
	this.id = id;
	this.amount = amount;
	this.sender = sender;
	this.receiver = receiver;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public BigDecimal getAmount() {
	return amount;
}

public void setAmount(BigDecimal amount) {
	this.amount = amount;
}

public User getSender() {
	return sender;
}

public void setSender(User sender) {
	this.sender = sender;
}

public User getReceiver() {
	return receiver;
}

public void setReceiver(User receiver) {
	this.receiver = receiver;
}

@Override
public int hashCode() {
	return Objects.hash(id);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Transaction other = (Transaction) obj;
	return Objects.equals(id, other.id);
}






}

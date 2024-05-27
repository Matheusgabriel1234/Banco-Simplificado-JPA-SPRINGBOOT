package com.example.TestePicpay.Domain;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
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


}

package com.example.TestePicpay.Domain;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "tb_users")
@Entity

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Getter
@Setter
private Long id;
@Getter
@Setter
private String firstName;
@Getter
@Setter
private String secondName;
@Column(unique = true)
private String cpf;
@Column(unique = true)
private String email;
@Getter
@Setter
private String password;
@Getter
@Setter
private BigDecimal balance;
@Enumerated(EnumType.STRING)
private UserType userType;





}

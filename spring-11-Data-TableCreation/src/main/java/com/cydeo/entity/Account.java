package com.cydeo.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
@MappedSuperclass // this represents this class is inheritance purpose only - No table needed
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String owner;
    private BigDecimal balance;
    private BigDecimal interestRate;
}

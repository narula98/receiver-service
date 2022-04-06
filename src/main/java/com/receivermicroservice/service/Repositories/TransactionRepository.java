package com.receivermicroservice.service.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.receivermicroservice.entities.Transaction;


public interface TransactionRepository extends JpaRepository<Transaction, String> {

}
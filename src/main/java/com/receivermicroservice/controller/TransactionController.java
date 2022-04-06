package com.receivermicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.receivermicroservice.entities.Transaction;
import com.receivermicroservice.services.TransactionService;

@RestController
@RequestMapping("/receiverTransactions")

public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	@PostMapping(path="/receiver")
	public ResponseEntity<Transaction> decryptTransactionObject(@RequestBody Transaction transactionObject) {
		return transactionService.receieveTransaction(transactionObject);
	}
	
}

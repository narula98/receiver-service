package com.receivermicroservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.receivermicroservice.decryption.Decryption;
import com.receivermicroservice.entities.Transaction;
import com.receivermicroservice.service.Repositories.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository transactionRepository;

	public ResponseEntity<Transaction> receieveTransaction(Transaction t) {
		System.out.println("encrypted" + t.toString());
		t.setAccountNumber(Decryption.decrypt(t.getAccountNumber()));
		t.setAccountFrom(Decryption.decrypt(t.getAccountFrom()));
		t.setAmount(Decryption.decrypt(t.getAmount()));
		t.setcurrency(Decryption.decrypt(t.getcurrency()));
		t.setType(Decryption.decrypt(t.getType()));
		System.out.println("decrypted" + t.toString());
		t = transactionRepository.save((t));
		System.out.println("added to db");
		return new ResponseEntity<Transaction>(t, new ResponseEntity<>(HttpStatus.ACCEPTED).getStatusCode());

	}

}

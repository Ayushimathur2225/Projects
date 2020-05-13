package com.transaction.rest.controller;


import java.util.List;

import com.transaction.rest.model.*;
import com.transaction.rest.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



	@RestController
	@RequestMapping(path="/demo")
	public class TransactionController {

	    private ServiceInterface serviceInterface;
	    
	    @Autowired
	    public TransactionController( ServiceInterface thetransactionservice){
	    	serviceInterface = thetransactionservice;

	    }

	    //For getting all the transactions
	    
	    @GetMapping(path="/transactions", produces = "application/json")
	    public ResponseEntity<List<Transaction>> findAll(){
	        System.out.println(serviceInterface.findAllTransactions().size());
	        return new ResponseEntity<List<Transaction>>(serviceInterface.findAllTransactions(), HttpStatus.OK);

	    }

	    //For getting whether the transaction with a given id is rejected or accepted
	    @GetMapping(path="/transactions/{transactionId}", produces = "application/json")
	    public String screenTransaction(@PathVariable int transactionId)  {
	        String theTransaction = serviceInterface.screenTransactionById(transactionId);

	        return theTransaction;
	    }

	    //For adding a transaction
	    @PostMapping(path="/transactions", produces = "application/json")
	    public Transaction addTransaction(@RequestBody Transaction theTransaction){

	        return (serviceInterface.saveTransaction(theTransaction));
	    }

	    //For updating a transaction
	    @PutMapping(path="/transactions", produces = "application/json")
	    public Transaction updateTransaction(@RequestBody Transaction theTransaction){
	        Transaction transaction = serviceInterface.findTransactionById(theTransaction.getId());
	        if (transaction == null) {
	            throw new RuntimeException("Transaction to update doesn't exist");
	        }
	        return (serviceInterface.saveTransaction(theTransaction));
	    }

	    //For deleting a transaction
	    @DeleteMapping(path="/transactions/{transactionId}", produces = "application/json")
	    public String deleteTransaction(@PathVariable int transactionId){
	        Transaction tempTransaction = serviceInterface.findTransactionById(transactionId);
	        if(tempTransaction == null){
	            throw new RuntimeException("Transaction Id not found");
	        }
	        serviceInterface.deleteTransactionById(transactionId);
	        return "deleted transaction id " + transactionId;

	    }
	}


package com.transaction.rest.service;

import java.time.LocalDate;

import java.util.Arrays;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.transaction.rest.dao.DAOInterface;
import com.transaction.rest.model.Transaction;

	@Service
	public class TransactionService implements ServiceInterface {

		DAOInterface daoInterface;
	    private static final String[] blackListEmails = new String[] {"blacklist1@gmail.com","blacklist2@gmail.com","blacklist3@gmail.com","blacklist4@gmail.com"};

	
	    
	    @Autowired
	    public TransactionService(DAOInterface theTransactionDao){
	    	daoInterface= theTransactionDao;
	    }

	   
	    @Transactional
	    public List<Transaction> findAllTransactions() {
	        return daoInterface.getAllTransactions();
	    }

	 
	    @Transactional
	    public String screenTransactionById(int theId) {
	        Transaction theTransaction=daoInterface.findTransactionById(theId);
	        String dateInString = theTransaction.getDate();
	        LocalDate localDate = LocalDate.parse(dateInString);
	        LocalDate today = LocalDate.now();

	        long difference=DAYS.between(localDate, today);
	        boolean isInBlackList = Arrays.asList(blackListEmails).contains(theTransaction.getEmail());

	        //return Reject if the email id is in blacklist and the transaction has been made in the last 30 days, otherwise return accept
	        if(isInBlackList && difference<30) {
	            return "REJECT";
	        }
	        else {
	            return "ACCEPT";
	        }

	    }

	  
	    @Transactional
	    public Transaction findTransactionById(int theId) {
	        return daoInterface.findTransactionById(theId);
	    }

	    
	    @Transactional
	    public Transaction saveTransaction(Transaction theTransaction) {
	        return daoInterface.saveTransaction(theTransaction);
	    }

	    
	    @Transactional
	    public int deleteTransactionById(int theId) {
	    	daoInterface.deleteTransactionById(theId);
	        return theId;
	    }
	}


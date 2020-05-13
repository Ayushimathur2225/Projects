package com.transaction.rest.service;
import java.util.List;
import com.transaction.rest.model.*;

public interface ServiceInterface {
	 public List<Transaction> findAllTransactions();

	    public String screenTransactionById(int theId);

	    public Transaction findTransactionById(int theId);

	    public Transaction saveTransaction(Transaction theTransaction);

	    public int deleteTransactionById(int theId);
}

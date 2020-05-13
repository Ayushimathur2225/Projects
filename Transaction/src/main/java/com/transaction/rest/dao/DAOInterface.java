package com.transaction.rest.dao;

import java.util.List;
import com.transaction.rest.model.*;

public interface DAOInterface {
	 List<Transaction> getAllTransactions();

	    Transaction findTransactionById(int theId);

	    Transaction saveTransaction(Transaction theTransaction);

	    void deleteTransactionById(int theId);
}

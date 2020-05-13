package com.transaction.rest.dao;

import org.springframework.stereotype.Repository;
import com.transaction.rest.model.Transaction;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;



	@Repository
	public class TransactionDAO implements DAOInterface {

	    private EntityManager entityManager;

	    @Autowired
	    public TransactionDAO(EntityManager entityManager){
	        this.entityManager = entityManager;

	    }
	    
	   //get all the transactions from the database
	   
	    public List<Transaction> getAllTransactions() {
	        Query theQuery= (Query) entityManager.createQuery("from Transaction");
	        List<Transaction> transactions = theQuery.getResultList();

	        return transactions;
	    }

	    //return the transaction by giving id as input
	   
	    public Transaction findTransactionById(int theId) {
	        Transaction theTransaction = entityManager.find(Transaction.class,theId);
	        return theTransaction;
	    }

	    //add the transaction to the database
	    
	    public Transaction saveTransaction(Transaction theTransaction) {
	        Transaction dbTransaction = entityManager.merge(theTransaction);
	        theTransaction.setId(dbTransaction.getId());
	        return theTransaction;
	    }

	    //delete the transaction from the database using transaction id
	    
	    public void deleteTransactionById(int theId) {
	        Query theQuery = (Query) entityManager.createQuery("delete from Transaction where id=:transactionId");
	        theQuery.setParameter("transactionId", theId);
	        theQuery.executeUpdate();
	    }
	}


package id.co.imwizz.bolpax.dao.impl;

import id.co.imwizz.bolpax.dao.TransactionDao;
import id.co.imwizz.bolpax.model.Transaction;

public class TransactionDaoImpl extends GenericDaoImpl<Transaction> implements TransactionDao {

	public TransactionDaoImpl() {
		super(Transaction.class);
	}
	
}

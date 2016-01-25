package id.co.imwizz.bolpax.dao.impl;

import id.co.imwizz.bolpax.dao.TransactionStatusDao;
import id.co.imwizz.bolpax.model.TransactionStatus;

public class TransactionStatusDaoImpl extends GenericDaoImpl<TransactionStatus> implements TransactionStatusDao {

	public TransactionStatusDaoImpl() {
		super(TransactionStatus.class);
	}
	
}

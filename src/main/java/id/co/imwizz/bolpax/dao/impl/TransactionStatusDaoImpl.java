package id.co.imwizz.bolpax.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import id.co.imwizz.bolpax.dao.TransactionStatusDao;
import id.co.imwizz.bolpax.model.TransactionStatus;

@Repository
@Transactional
public class TransactionStatusDaoImpl extends GenericDaoImpl<TransactionStatus> implements TransactionStatusDao {

	public TransactionStatusDaoImpl() {
		super(TransactionStatus.class);
	}
	
}

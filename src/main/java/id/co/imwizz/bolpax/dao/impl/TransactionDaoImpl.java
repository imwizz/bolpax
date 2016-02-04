package id.co.imwizz.bolpax.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import id.co.imwizz.bolpax.dao.TransactionDao;
import id.co.imwizz.bolpax.model.Transaction;

@Repository
@Transactional
public class TransactionDaoImpl extends GenericDaoImpl<Transaction> implements TransactionDao {

	public TransactionDaoImpl() {
		super(Transaction.class);
	}

	@Override
	public List<Transaction> findTrxByUserId(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> findTrxByMerchantId(long merchantId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

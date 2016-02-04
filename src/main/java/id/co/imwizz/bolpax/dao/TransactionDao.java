package id.co.imwizz.bolpax.dao;

import java.util.List;

import id.co.imwizz.bolpax.model.Transaction;

public interface TransactionDao extends GenericDao<Transaction>{

	public List<Transaction> findTrxByUserId(long userId);
	public List<Transaction> findTrxByMerchantId(long merchantId);
	
}

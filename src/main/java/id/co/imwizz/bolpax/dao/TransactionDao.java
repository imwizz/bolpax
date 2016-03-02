package id.co.imwizz.bolpax.dao;

import java.util.List;

import id.co.imwizz.bolpax.model.Transaction;

/**
 * <p>
 * Interface for the Transaction DAO. This is created very simply by extending
 * GenericDAO and specifying the type for the entity class (Transaction)
 * 
 * <p>
 * As a matter of best practice other components reference this interface rather
 * than the implementation of the DAO itself.
 * 
 * @author Sangbas
 * 
 */
public interface TransactionDao extends GenericDao<Transaction>{

	/**
     * Query to find list of transactions according to userId
     * @param long userId
     * @return list of transactions
     */
	public List<Transaction> findTrxByUserId(long userId);
	
	/**
     * Query to find list of transactions according to merchantId
     * @param long merchantId
     * @return list of transactions
     */
	public List<Transaction> findTrxByMerchantId(long merchantId);
	
}

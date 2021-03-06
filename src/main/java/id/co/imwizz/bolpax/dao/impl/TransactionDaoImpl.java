package id.co.imwizz.bolpax.dao.impl;

import id.co.imwizz.bolpax.dao.TransactionDao;
import id.co.imwizz.bolpax.model.Transaction;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * This is the implementation of the Transaction DAO. You can see that we don't
 * actually have to implement anything, it is all inherited from TransactionDao
 * through GenericDAOImpl. We just specify the entity type (Transaction) 
 * 
 * <p>
 * The @Repository allows Spring to recognize this as a managed component (so we
 * don't need to specify it in XML) and also tells spring to do DAO exception
 * translation to the Spring exception hierarchy.
 * 
 * @author Sangbas
 * 
 */
@Repository
@Transactional
public class TransactionDaoImpl extends GenericDaoImpl<Transaction> implements TransactionDao {

	public TransactionDaoImpl() {
		super(Transaction.class);
	}

	@Override
	public List<Transaction> findTrxByUserId(long userId) {
		List<Transaction> trxs = new ArrayList<Transaction>();
		try {
			trxs = em.createQuery("SELECT t FROM Transaction t join t.user u where u.userId = :userId", Transaction.class).setParameter("userId", userId).getResultList();
			//TODO tambahin filter status khusus buyer
		} catch (NoResultException nre){

		} catch (EmptyResultDataAccessException erdae) {
			
		}
		return trxs;
	}

	@Override
	public List<Transaction> findTrxByMerchantId(long merchantId) {
		List<Transaction> trxs = new ArrayList<Transaction>();
		try {
			trxs = em.createQuery("SELECT t FROM Transaction t join t.merchant m where m.merchantId = :merchantId", Transaction.class).setParameter("merchantId", merchantId).getResultList();
			//TODO tambahin filter status khusus merchant
		} catch (NoResultException nre){

		} catch (EmptyResultDataAccessException erdae) {
			
		}
		return trxs;
	}
	
}

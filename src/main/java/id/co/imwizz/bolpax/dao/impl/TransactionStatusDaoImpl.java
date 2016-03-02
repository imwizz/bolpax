package id.co.imwizz.bolpax.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import id.co.imwizz.bolpax.dao.TransactionStatusDao;
import id.co.imwizz.bolpax.model.TransactionStatus;

/**
 * <p>
 * This is the implementation of the Transaction Status DAO. You can see that we don't
 * actually have to implement anything, it is all inherited from TransactionStatusDao
 * through GenericDAOImpl. We just specify the entity type (TransactionStatus) 
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
public class TransactionStatusDaoImpl extends GenericDaoImpl<TransactionStatus> implements TransactionStatusDao {

	public TransactionStatusDaoImpl() {
		super(TransactionStatus.class);
	}
	
}

package id.co.imwizz.bolpax.dao.impl;

import id.co.imwizz.bolpax.dao.TransactionStatusMappingDao;
import id.co.imwizz.bolpax.model.TransactionStatusMapping;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * This is the implementation of the Transaction Status Mapping DAO. You can see that we don't
 * actually have to implement anything, it is all inherited from TransactionStatusMappingDao
 * through GenericDAOImpl. We just specify the entity type (TransactionStatusMapping) 
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
public class TransactionStatusMappingDaoImpl extends GenericDaoImpl<TransactionStatusMapping> implements TransactionStatusMappingDao {

	public TransactionStatusMappingDaoImpl() {
		super(TransactionStatusMapping.class);
	}
	
}

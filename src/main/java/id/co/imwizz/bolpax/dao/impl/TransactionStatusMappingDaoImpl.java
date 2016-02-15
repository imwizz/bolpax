package id.co.imwizz.bolpax.dao.impl;

import id.co.imwizz.bolpax.dao.TransactionStatusMappingDao;
import id.co.imwizz.bolpax.model.TransactionStatusMapping;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class TransactionStatusMappingDaoImpl extends GenericDaoImpl<TransactionStatusMapping> implements TransactionStatusMappingDao {

	public TransactionStatusMappingDaoImpl() {
		super(TransactionStatusMapping.class);
	}
	
}

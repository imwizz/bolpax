package id.co.imwizz.bolpax.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import id.co.imwizz.bolpax.dao.TransactionTrailDao;
import id.co.imwizz.bolpax.model.TransactionTrail;

@Repository
@Transactional
public class TransactionTrailDaoImpl extends GenericDaoImpl<TransactionTrail> implements TransactionTrailDao {

	public TransactionTrailDaoImpl() {
		super(TransactionTrail.class);
	}

	@Override
	public TransactionTrail findTrxTrailByTrxId(long trxId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
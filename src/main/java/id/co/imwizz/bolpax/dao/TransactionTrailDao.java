package id.co.imwizz.bolpax.dao;

import id.co.imwizz.bolpax.model.TransactionTrail;

public interface TransactionTrailDao extends GenericDao<TransactionTrail>{

	public TransactionTrail findTrxTrailByTrxId(long trxId);
	
}

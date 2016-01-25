package id.co.imwizz.bolpax.dao.impl;

import id.co.imwizz.bolpax.dao.TransactionTrailDao;
import id.co.imwizz.bolpax.model.TransactionTrail;

public class TransactionTrailDaoImpl extends GenericDaoImpl<TransactionTrail> implements TransactionTrailDao {

	public TransactionTrailDaoImpl() {
		super(TransactionTrail.class);
	}
	
}
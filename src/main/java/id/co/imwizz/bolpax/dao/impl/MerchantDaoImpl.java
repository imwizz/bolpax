package id.co.imwizz.bolpax.dao.impl;

import id.co.imwizz.bolpax.dao.MerchantDao;
import id.co.imwizz.bolpax.model.Merchant;

public class MerchantDaoImpl extends GenericDaoImpl<Merchant> implements MerchantDao {

	public MerchantDaoImpl() {
		super(Merchant.class);
	}
	
}
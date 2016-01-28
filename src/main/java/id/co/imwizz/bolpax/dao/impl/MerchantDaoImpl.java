package id.co.imwizz.bolpax.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import id.co.imwizz.bolpax.dao.MerchantDao;
import id.co.imwizz.bolpax.model.Merchant;

@Repository
@Transactional
public class MerchantDaoImpl extends GenericDaoImpl<Merchant> implements MerchantDao {

	public MerchantDaoImpl() {
		super(Merchant.class);
	}

	@Override
	public Merchant findMerchantByUserId(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Merchant> findMerchantExceptMe(long userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
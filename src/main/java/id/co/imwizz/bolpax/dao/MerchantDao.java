package id.co.imwizz.bolpax.dao;

import java.util.List;

import id.co.imwizz.bolpax.model.Merchant;

public interface MerchantDao extends GenericDao<Merchant>{

	public Merchant findMerchantByUserId(long userId);
	public List<Merchant> findMerchantExceptMe(long userId);
	
}

package id.co.imwizz.bolpax.dao.impl;

import id.co.imwizz.bolpax.dao.MerchantDao;
import id.co.imwizz.bolpax.model.Merchant;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class MerchantDaoImpl extends GenericDaoImpl<Merchant> implements MerchantDao {

	public MerchantDaoImpl() {
		super(Merchant.class);
	}

	@Override
	public Merchant findMerchantByUserId(long userId) {
		Merchant merchant = new Merchant();
		try {
//			Object[] result = em.createQuery("SELECT m.merchantId, m.merchantName FROM Merchant m join m.user u where u.userId = :userId", Object[].class).setParameter("userId", userId).getSingleResult();
//		    merchant.setMerchantId((long) result[0]);
//		    merchant.setMerchantName((String) result[1]);
		    merchant = em.createQuery("SELECT m FROM Merchant m join m.user u where u.userId = :userId", Merchant.class).setParameter("userId", userId).getSingleResult();
		} catch (NoResultException nre){

		} catch (EmptyResultDataAccessException erdae) {
			
		}
		return merchant;
	}

	@Override
	public List<Merchant> findMerchantsExceptMe(long userId) {
		List<Merchant> merchants = new ArrayList<Merchant>();
		try {
			List<Object[]> result = em.createQuery("SELECT m.merchantId, m.merchantName FROM Merchant m join m.user u where u.userId <> :userId", Object[].class).setParameter("userId", userId).getResultList();
		    for (Object[] objects : result) {
		    	Merchant merchant = new Merchant();
		    	merchant.setMerchantId((long) objects[0]);
			    merchant.setMerchantName((String) objects[1]);
			    merchants.add(merchant);
			}
			
		} catch (NoResultException nre){

		} catch (EmptyResultDataAccessException erdae) {
			
		}
		return merchants;
	}
	
}
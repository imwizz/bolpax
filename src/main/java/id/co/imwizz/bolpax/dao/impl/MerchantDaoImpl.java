package id.co.imwizz.bolpax.dao.impl;

import id.co.imwizz.bolpax.dao.MerchantDao;
import id.co.imwizz.bolpax.model.Merchant;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * This is the implementation of the Merchant DAO. You can see that we don't
 * actually have to implement anything, it is all inherited from MerchantDao
 * through GenericDAOImpl. We just specify the entity type (Merchant) 
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
public class MerchantDaoImpl extends GenericDaoImpl<Merchant> implements MerchantDao {

	public MerchantDaoImpl() {
		super(Merchant.class);
	}

	@Override
	public Merchant findMerchantByUserId(long userId) {
		Merchant merchant = null;
		try {
		    merchant = em.createQuery("SELECT m FROM Merchant m join m.user u where u.userId = :userId", Merchant.class).setParameter("userId", userId).getSingleResult();
		} catch (NoResultException nre){

		} catch (EmptyResultDataAccessException erdae) {
			
		}
		return merchant;
	}

	@Override
	public List<Merchant> findMerchantsExceptMe(long userId) {
		List<Merchant> merchants = null;
		try {
			List<Object[]> result = em.createQuery("SELECT m.merchantId, m.merchantName FROM Merchant m join m.user u where u.userId <> :userId", Object[].class).setParameter("userId", userId).getResultList();
		    if(result.size() > 0) {
		    	merchants = new ArrayList<Merchant>();
		    	for (Object[] objects : result) {
			    	Merchant merchant = new Merchant();
			    	merchant.setMerchantId((long) objects[0]);
				    merchant.setMerchantName((String) objects[1]);
				    merchants.add(merchant);
				}
		    }
		} catch (NoResultException nre){

		} catch (EmptyResultDataAccessException erdae) {
			
		}
		return merchants;
	}
	
}
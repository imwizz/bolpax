package id.co.imwizz.bolpax.dao;

import java.util.List;

import id.co.imwizz.bolpax.model.Merchant;

/**
 * <p>
 * Interface for the Merchant DAO. This is created very simply by extending
 * GenericDAO and specifying the type for the entity class (Merchant)
 * 
 * <p>
 * As a matter of best practice other components reference this interface rather
 * than the implementation of the DAO itself.
 * 
 * @author Sangbas
 * 
 */
public interface MerchantDao extends GenericDao<Merchant>{

	/**
     * Query to find a merchant according to user id
     * @param userId
     * @return a merchant
     */
	public Merchant findMerchantByUserId(long userId);
	
	/**
     * Query to find list of merchants except user login him/herself
     * @param long userId
     * @return list of merchants
     */
	public List<Merchant> findMerchantsExceptMe(long userId);
	
}

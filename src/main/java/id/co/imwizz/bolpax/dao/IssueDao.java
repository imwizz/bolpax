package id.co.imwizz.bolpax.dao;

import java.util.List;

import id.co.imwizz.bolpax.model.Issue;

/**
 * <p>
 * Interface for the Issue DAO. This is created very simply by extending
 * GenericDAO and specifying the type for the entity class (Issue)
 * 
 * <p>
 * As a matter of best practice other components reference this interface rather
 * than the implementation of the DAO itself.
 * 
 * @author Sangbas
 * 
 */
public interface IssueDao extends GenericDao<Issue>{

	/**
     * Query to find list of issues according to user id
     * @param userId
     * @return list of issues
     */
	public List<Issue> findIssueByUserId (long userId);
	
	/**
     * Query to find list of issues according to merchant id
     * @param merchantId
     * @return list of issues
     */
	public List<Issue> findIssueByMerchantId (long merchantId);
	
	/**
     * Query to find an issue according to trx id
     * @param trxId
     * @return an issue
     */
	public Issue findIssueByTrxId (long trxId);
	
}

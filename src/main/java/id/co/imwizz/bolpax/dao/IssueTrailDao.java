package id.co.imwizz.bolpax.dao;

import id.co.imwizz.bolpax.model.IssueTrail;

/**
 * <p>
 * Interface for the Issue Trail DAO. This is created very simply by extending
 * GenericDAO and specifying the type for the entity class (IssueTrail)
 * 
 * <p>
 * As a matter of best practice other components reference this interface rather
 * than the implementation of the DAO itself.
 * 
 * @author Sangbas
 * 
 */
public interface IssueTrailDao extends GenericDao<IssueTrail>{

	/**
     * Query to find list of issue trails according to issue id
     * @param issueId
     * @return list of issue trails
     */
	public IssueTrail findIssueTrailByIssueId(long issueId);
	
}

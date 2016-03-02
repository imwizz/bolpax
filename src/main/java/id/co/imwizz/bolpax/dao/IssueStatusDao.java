package id.co.imwizz.bolpax.dao;

import id.co.imwizz.bolpax.model.IssueStatus;

/**
 * <p>
 * Interface for the Issue Status DAO. This is created very simply by extending
 * GenericDAO and specifying the type for the entity class (IssueStatus)
 * 
 * <p>
 * As a matter of best practice other components reference this interface rather
 * than the implementation of the DAO itself.
 * 
 * @author Sangbas
 * 
 */
public interface IssueStatusDao extends GenericDao<IssueStatus>{

}

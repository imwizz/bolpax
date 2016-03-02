package id.co.imwizz.bolpax.dao;

import id.co.imwizz.bolpax.model.TransactionTrail;

/**
 * <p>
 * Interface for the Transaction Trail DAO. This is created very simply by extending
 * GenericDAO and specifying the type for the entity class (TransactionTrail)
 * 
 * <p>
 * As a matter of best practice other components reference this interface rather
 * than the implementation of the DAO itself.
 * 
 * @author Sangbas
 * 
 */
public interface TransactionTrailDao extends GenericDao<TransactionTrail>{
}

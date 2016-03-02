package id.co.imwizz.bolpax.dao;

import id.co.imwizz.bolpax.model.User;

/**
 * <p>
 * Interface for the User DAO. This is created very simply by extending
 * GenericDAO and specifying the type for the entity class (User)
 * 
 * <p>
 * As a matter of best practice other components reference this interface rather
 * than the implementation of the DAO itself.
 * 
 * @author Sangbas
 * 
 */
public interface UserDao extends GenericDao<User>{
	
	/**
     * Query to find an user according to phone number
     * @param phone
     * @return a user
     */
	public User findUserByPhone(String phone);

}

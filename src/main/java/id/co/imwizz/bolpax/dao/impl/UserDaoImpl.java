package id.co.imwizz.bolpax.dao.impl;

import id.co.imwizz.bolpax.dao.UserDao;
import id.co.imwizz.bolpax.model.User;

import javax.persistence.NoResultException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * This is the implementation of the User DAO. You can see that we don't
 * actually have to implement anything, it is all inherited from UserDao
 * through GenericDAOImpl. We just specify the entity type (User) 
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
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

	public UserDaoImpl() {
		super(User.class);
	}

	@Override
	public User findUserByPhone(String phone) {
		User user = new User();
		try {
			user = (User) em.createQuery("SELECT o FROM User o where o.phone = :phone", User.class).setParameter("phone", phone).getSingleResult();
		} catch (NoResultException nre){

		} catch (EmptyResultDataAccessException erdae) {
			
		}
		return user;
	}
	
}
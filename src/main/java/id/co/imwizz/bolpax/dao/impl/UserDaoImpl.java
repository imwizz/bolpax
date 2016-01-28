package id.co.imwizz.bolpax.dao.impl;

import id.co.imwizz.bolpax.dao.UserDao;
import id.co.imwizz.bolpax.model.User;

import javax.persistence.NoResultException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

	public UserDaoImpl() {
		super(User.class);
	}

	@Override
	public User findUserByPhone(String phone) {
		User user = null;
		try {
			user = (User) em.createQuery("SELECT o FROM User o where o.phone = :phone", User.class).setParameter("phone", phone).getSingleResult();
		} catch (NoResultException nre){

		} catch (EmptyResultDataAccessException erdae) {
			
		}
		return user;
	}
	
}
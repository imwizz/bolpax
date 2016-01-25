package id.co.imwizz.bolpax.dao.impl;

import id.co.imwizz.bolpax.dao.GenericDao;
import id.co.imwizz.bolpax.dao.SearchException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

public class GenericDaoImpl<T> implements GenericDao<T> {
	
	@PersistenceContext
	protected EntityManager em;
	protected Class<T> persistentClass;
	
	public GenericDaoImpl() {
	}
	
	public GenericDaoImpl(final Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }
	
	public final EntityManager entityManager() {
        EntityManager entityManager = em;
        if (entityManager == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return entityManager;
    }

	@Override
	public List<T> getAll() {
		return em.createQuery("SELECT o FROM " + persistentClass.getName() + " o", persistentClass).getResultList();
	}

	@Override
	public List<T> getAllDistinct() {
		Collection<T> result = new LinkedHashSet<T>(getAll());
        return new ArrayList<T>(result);
	}

	@Override
	public List<T> search(String searchTerm) throws SearchException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T get(Object id) {
		return em.find(persistentClass, id);
	}

	@Override
	public boolean exists(Object id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional
	public void persist(T obj) {
		if (em == null) em = entityManager();
        this.em.persist(obj);
	}
	
	@Override
	@Transactional
	public void merge(T object) {
		if (em == null) em = entityManager();
        this.em.merge(object);
	}

	@Override
	public void remove(Object id) {
		if (this.em == null) this.em = entityManager();
        if (this.em.contains(this)) {
            this.em.remove(this);
        } else {
            T attached = get(this);
            this.em.remove(attached);
        }
	}

	@Override
	public List<T> findByNamedQuery(String queryName,
			Map<String, Object> queryParams) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reindex() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reindexAll(boolean async) {
		// TODO Auto-generated method stub
		
	}

}

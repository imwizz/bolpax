package id.co.imwizz.bolpax.dao.impl;

import id.co.imwizz.bolpax.dao.IssueDao;
import id.co.imwizz.bolpax.model.Issue;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class IssueDaoImpl extends GenericDaoImpl<Issue> implements IssueDao {

	public IssueDaoImpl() {
		super(Issue.class);
	}

	@Override
	public List<Issue> findIssueByUserId(long userId) {
		List<Issue> issues = new ArrayList<Issue>();
		try {
			issues = em.createQuery("SELECT i FROM Issue i join i.trx t join t.user u where u.userId = :userId", Issue.class).setParameter("userId", userId).getResultList();
		} catch (NoResultException nre){

		} catch (EmptyResultDataAccessException erdae) {
			
		}
		return issues;	
	}

	@Override
	public List<Issue> findIssueByMerchantId(long merchantId) {
		List<Issue> issues = new ArrayList<Issue>();
		try {
			issues = em.createQuery("SELECT i FROM Issue i join i.trx t join t.merchant m where m.merchantId = :merchantId", Issue.class).setParameter("merchantId", merchantId).getResultList();
		} catch (NoResultException nre){

		} catch (EmptyResultDataAccessException erdae) {
			
		}
		return issues;	
	}
	
}

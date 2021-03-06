package id.co.imwizz.bolpax.dao.impl;

import id.co.imwizz.bolpax.dao.IssueDao;
import id.co.imwizz.bolpax.model.Issue;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * This is the implementation of the Issue DAO. You can see that we don't
 * actually have to implement anything, it is all inherited from IssueDao
 * through GenericDAOImpl. We just specify the entity type (Issue) 
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
public class IssueDaoImpl extends GenericDaoImpl<Issue> implements IssueDao {

	public IssueDaoImpl() {
		super(Issue.class);
	}

	@Override
	public List<Issue> findIssueByUserId(long userId) {
		List<Issue> issues = new ArrayList<Issue>();
		try {
			issues = em.createQuery("SELECT i FROM Issue i join i.trx t join t.user u where u.userId = :userId and i.reporterRole = :role", Issue.class)
					.setParameter("userId", userId)
					.setParameter("role", "buyer")
					.getResultList();
		} catch (NoResultException nre){

		} catch (EmptyResultDataAccessException erdae) {
			
		}
		return issues;	
	}

	@Override
	public List<Issue> findIssueByMerchantId(long merchantId) {
		List<Issue> issues = new ArrayList<Issue>();
		try {
			issues = em.createQuery("SELECT i FROM Issue i join i.trx t join t.merchant m where m.merchantId = :merchantId and i.reporterRole = :role", Issue.class)
					.setParameter("merchantId", merchantId)
					.setParameter("role", "merchant")
					.getResultList();
		} catch (NoResultException nre){

		} catch (EmptyResultDataAccessException erdae) {
			
		}
		return issues;	
	}

	@Override
	public Issue findIssueByTrxId(long trxId) {
		Issue issue = new Issue();
		try {
			issue = em.createQuery("SELECT i FROM Issue i join i.trx t where t.trxId = :trxId", Issue.class).setParameter("trxId", trxId).getSingleResult();
		} catch (NoResultException nre){

		} catch (EmptyResultDataAccessException erdae) {
			
		}
		return issue;	
	}
	
}

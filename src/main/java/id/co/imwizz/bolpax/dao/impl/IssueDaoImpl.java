package id.co.imwizz.bolpax.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import id.co.imwizz.bolpax.dao.IssueDao;
import id.co.imwizz.bolpax.model.Issue;

@Repository
@Transactional
public class IssueDaoImpl extends GenericDaoImpl<Issue> implements IssueDao {

	public IssueDaoImpl() {
		super(Issue.class);
	}

	@Override
	public List<Issue> findIssueByUserId(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Issue> findIssueByMerchantId(long merchantId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

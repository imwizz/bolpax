package id.co.imwizz.bolpax.dao.impl;

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
	public Issue findIssueByTrxId(long trxId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

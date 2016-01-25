package id.co.imwizz.bolpax.dao.impl;

import id.co.imwizz.bolpax.dao.IssueDao;
import id.co.imwizz.bolpax.model.Issue;

public class IssueDaoImpl extends GenericDaoImpl<Issue> implements IssueDao {

	public IssueDaoImpl() {
		super(Issue.class);
	}
	
}

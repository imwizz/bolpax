package id.co.imwizz.bolpax.dao.impl;

import id.co.imwizz.bolpax.dao.IssueStatusDao;
import id.co.imwizz.bolpax.model.IssueStatus;

public class IssueStatusDaoImpl extends GenericDaoImpl<IssueStatus> implements IssueStatusDao {

	public IssueStatusDaoImpl() {
		super(IssueStatus.class);
	}
	
}
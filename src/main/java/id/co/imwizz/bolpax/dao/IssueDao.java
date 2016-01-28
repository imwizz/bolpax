package id.co.imwizz.bolpax.dao;

import id.co.imwizz.bolpax.model.Issue;

public interface IssueDao extends GenericDao<Issue>{

	public Issue findIssueByTrxId (long trxId);
	
}

package id.co.imwizz.bolpax.dao;

import java.util.List;

import id.co.imwizz.bolpax.model.Issue;

public interface IssueDao extends GenericDao<Issue>{

	public List<Issue> findIssueByUserId (long userId);
	public List<Issue> findIssueByMerchantId (long merchantId);
	
}

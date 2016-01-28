package id.co.imwizz.bolpax.dao;

import id.co.imwizz.bolpax.model.IssueTrail;

public interface IssueTrailDao extends GenericDao<IssueTrail>{

	public IssueTrail findIssueTrailByIssueId(long issueId);
	
}

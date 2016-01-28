package id.co.imwizz.bolpax.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import id.co.imwizz.bolpax.dao.IssueTrailDao;
import id.co.imwizz.bolpax.model.IssueTrail;

@Repository
@Transactional
public class IssueTrailDaoImpl extends GenericDaoImpl<IssueTrail> implements IssueTrailDao {

	public IssueTrailDaoImpl() {
		super(IssueTrail.class);
	}

	@Override
	public IssueTrail findIssueTrailByIssueId(long issueId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
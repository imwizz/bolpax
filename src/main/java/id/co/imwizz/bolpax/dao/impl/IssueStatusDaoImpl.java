package id.co.imwizz.bolpax.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import id.co.imwizz.bolpax.dao.IssueStatusDao;
import id.co.imwizz.bolpax.model.IssueStatus;

@Repository
@Transactional
public class IssueStatusDaoImpl extends GenericDaoImpl<IssueStatus> implements IssueStatusDao {

	public IssueStatusDaoImpl() {
		super(IssueStatus.class);
	}
	
}
package id.co.imwizz.bolpax.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import id.co.imwizz.bolpax.dao.IssueTrailDao;
import id.co.imwizz.bolpax.model.IssueTrail;

/**
 * <p>
 * This is the implementation of the Issue Trail DAO. You can see that we don't
 * actually have to implement anything, it is all inherited from IssueTrailDao
 * through GenericDAOImpl. We just specify the entity type (IssueTrail) 
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
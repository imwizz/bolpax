package id.co.imwizz.bolpax.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import id.co.imwizz.bolpax.dao.IssueStatusDao;
import id.co.imwizz.bolpax.model.IssueStatus;

/**
 * <p>
 * This is the implementation of the Issue Status DAO. You can see that we don't
 * actually have to implement anything, it is all inherited from IssueStatusDao
 * through GenericDAOImpl. We just specify the entity type (IssueStatus) 
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
public class IssueStatusDaoImpl extends GenericDaoImpl<IssueStatus> implements IssueStatusDao {

	public IssueStatusDaoImpl() {
		super(IssueStatus.class);
	}
	
}
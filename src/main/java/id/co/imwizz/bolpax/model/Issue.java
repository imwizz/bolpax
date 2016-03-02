package id.co.imwizz.bolpax.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * Simple JavaBean domain object representing an issue.
 *
 * @author Sangbas
 */
@Entity
@Table(name="issue")
public class Issue {
	
	public Issue() {}
	
	public Issue(String subject, String reporterRole, Transaction trx) {
		this.subject = subject;
		this.reporterRole = reporterRole;
		this.trx = trx;
	}
	
	@Id
	@GeneratedValue
	@Column(name = "issue_id")
	private long issueId;
	
	@Column(name = "subject", length = 200)
	private String subject;
	
	@Column(name = "reporter_role", length = 10)
	private String reporterRole;
	
	@ManyToOne
    @JoinColumn(name = "trx_id", referencedColumnName = "trx_id", nullable = false)
	private Transaction trx;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "issue")
	@OrderBy("stsDate")
    private Set<IssueTrail> issueTrails;

	public long getIssueId() {
		return issueId;
	}

	public void setIssueId(long issueId) {
		this.issueId = issueId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getReporterRole() {
		return reporterRole;
	}

	public void setReporterRole(String reporterRole) {
		this.reporterRole = reporterRole;
	}

	public Transaction getTrx() {
		return trx;
	}

	public void setTrx(Transaction trx) {
		this.trx = trx;
	}

	@JsonIgnore
	public Set<IssueTrail> getIssueTrails() {
		return issueTrails;
	}

	public void setIssueTrails(Set<IssueTrail> issueTrails) {
		this.issueTrails = issueTrails;
	}
	
	
}

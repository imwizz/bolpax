package id.co.imwizz.bolpax.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Simple JavaBean domain object representing an issue_trail table.
 *
 * @author Sangbas
 */
@Entity
@Table(name="issue_trail")
public class IssueTrail {
	
	public IssueTrail() {}
	
	public IssueTrail(Character fromAdmin, String issueMessage, Issue issue,
			IssueStatus issueStatus) {
		this.fromAdmin = fromAdmin;
		this.issueMessage = issueMessage;
		this.issue = issue;
		this.issueStatus = issueStatus;
	}

	@Id
	@GeneratedValue
	@Column(name = "issue_trail_id")
	private long issueTrailId;
	
	@Column(name = "from_admin", length = 1)
	private Character fromAdmin;

	@Column(name = "issue_message", length = 200)
	private String issueMessage;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "sts_date")
    private java.util.Date stsDate;
	
	@ManyToOne
    @JoinColumn(name = "issue_id", referencedColumnName = "issue_id", nullable = false)
	private Issue issue;
	
	@ManyToOne
    @JoinColumn(name = "issue_status_id", referencedColumnName = "issue_status_id", nullable = false)
	private IssueStatus issueStatus;
	
	@PrePersist
    protected void onCreate() {
		stsDate = Calendar.getInstance().getTime();
    }

	public long getIssueTrailId() {
		return issueTrailId;
	}

	public void setIssueTrailId(long issueTrailId) {
		this.issueTrailId = issueTrailId;
	}

	public Character getFromAdmin() {
		return fromAdmin;
	}

	public void setFromAdmin(Character fromAdmin) {
		this.fromAdmin = fromAdmin;
	}

	public String getIssueMessage() {
		return issueMessage;
	}

	public void setIssueMessage(String issueMessage) {
		this.issueMessage = issueMessage;
	}

	public java.util.Date getStsDate() {
		return stsDate;
	}

	public void setStsDate(java.util.Date stsDate) {
		this.stsDate = stsDate;
	}

	public Issue getIssue() {
		return issue;
	}

	public void setIssue(Issue issue) {
		this.issue = issue;
	}

	public IssueStatus getIssueStatus() {
		return issueStatus;
	}

	public void setIssueStatus(IssueStatus issueStatus) {
		this.issueStatus = issueStatus;
	}

	
}

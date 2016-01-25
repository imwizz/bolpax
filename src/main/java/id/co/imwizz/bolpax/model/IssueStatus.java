package id.co.imwizz.bolpax.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="issue_status")
public class IssueStatus {

	@Id
	@GeneratedValue
	@Column(name = "issue_status_id")
	private long issueStatusId;
	
	@Column(name = "status", length = 200)
	private String status;
	
	@Column(name = "status_desc", length = 200)
	private String statusDesc;
	
	@OneToMany(mappedBy = "issueStatus")
    private Set<IssueTrail> issueTrails;

	public long getIssueStatusId() {
		return issueStatusId;
	}

	public void setIssueStatusId(long issueStatusId) {
		this.issueStatusId = issueStatusId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public Set<IssueTrail> getIssueTrails() {
		return issueTrails;
	}

	public void setIssueTrails(Set<IssueTrail> issueTrails) {
		this.issueTrails = issueTrails;
	}
	
	
}

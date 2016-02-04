package id.co.imwizz.bolpax.model.rest.request;

public class IssueTrailReq {
	
	private Character fromAdmin;
	private String message;
	private long issueId;
	private long issueStatusId;
	
	public Character getFromAdmin() {
		return fromAdmin;
	}
	public void setFromAdmin(Character fromAdmin) {
		this.fromAdmin = fromAdmin;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getIssueId() {
		return issueId;
	}
	public void setIssueId(long issueId) {
		this.issueId = issueId;
	}
	public long getIssueStatusId() {
		return issueStatusId;
	}
	public void setIssueStatusId(long issueStatusId) {
		this.issueStatusId = issueStatusId;
	}

}

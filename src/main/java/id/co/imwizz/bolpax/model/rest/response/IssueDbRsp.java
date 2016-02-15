package id.co.imwizz.bolpax.model.rest.response;

public class IssueDbRsp {
	
	private long issueId;
	private String buyer;
	private String merchant;
	private String reporterRole;
	private String lastIssueDate;
	private String lastStatus;
	private String issueTitle;
	private String lastIssueHistory;
	
	public String getLastIssueDate() {
		return lastIssueDate;
	}
	public void setLastIssueDate(String lastIssueDate) {
		this.lastIssueDate = lastIssueDate;
	}
	public String getLastStatus() {
		return lastStatus;
	}
	public void setLastStatus(String lastStatus) {
		this.lastStatus = lastStatus;
	}
	public String getIssueTitle() {
		return issueTitle;
	}
	public void setIssueTitle(String issueTitle) {
		this.issueTitle = issueTitle;
	}
	public String getLastIssueHistory() {
		return lastIssueHistory;
	}
	public void setLastIssueHistory(String lastIssueHistory) {
		this.lastIssueHistory = lastIssueHistory;
	}
	public long getIssueId() {
		return issueId;
	}
	public void setIssueId(long issueId) {
		this.issueId = issueId;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public String getMerchant() {
		return merchant;
	}
	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}
	public String getReporterRole() {
		return reporterRole;
	}
	public void setReporterRole(String reporterRole) {
		this.reporterRole = reporterRole;
	}

}

package id.co.imwizz.bolpax.model.rest.response;

import java.util.List;

public class IssueRsp {
	
	private String suspect;
	private String issueDate;
	private String issueLastStatus;
	private Double amount;
	private List<IssueTrailRsp> issueHistory;
	
	public String getSuspect() {
		return suspect;
	}
	public void setSuspect(String suspect) {
		this.suspect = suspect;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public String getIssueLastStatus() {
		return issueLastStatus;
	}
	public void setIssueLastStatus(String issueLastStatus) {
		this.issueLastStatus = issueLastStatus;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public List<IssueTrailRsp> getIssueHistory() {
		return issueHistory;
	}
	public void setIssueHistory(List<IssueTrailRsp> issueHistory) {
		this.issueHistory = issueHistory;
	}
	
	

}

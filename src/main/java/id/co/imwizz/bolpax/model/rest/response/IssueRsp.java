package id.co.imwizz.bolpax.model.rest.response;

/**
*
* @author Sangbas
*/
public class IssueRsp {
	
	private long issueId;
	private String suspect;
	private String issueDate;
	private String issueLastStatus;
	private Double amount;
	
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
	public long getIssueId() {
		return issueId;
	}
	public void setIssueId(long issueId) {
		this.issueId = issueId;
	}
	
	

}

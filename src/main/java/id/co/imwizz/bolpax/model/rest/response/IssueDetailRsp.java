package id.co.imwizz.bolpax.model.rest.response;

import java.util.List;

/**
*
* @author Sangbas
*/
public class IssueDetailRsp {
	
	private String suspect;
	private String issueLastStatus;
	private String subject;
	private Double amount;
	private String product;
	private String reporter;
	private List<IssueTrailRsp> issueHistory;
	
	public String getSuspect() {
		return suspect;
	}
	public void setSuspect(String suspect) {
		this.suspect = suspect;
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
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getReporter() {
		return reporter;
	}
	public void setReporter(String reporter) {
		this.reporter = reporter;
	}

}

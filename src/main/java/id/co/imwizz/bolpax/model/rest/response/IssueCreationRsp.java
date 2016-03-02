package id.co.imwizz.bolpax.model.rest.response;

/**
*
* @author Sangbas
*/
public class IssueCreationRsp {
	
	private long issueId;
	private String status;
	
	public IssueCreationRsp(long issueId, String status) {
		super();
		this.issueId = issueId;
		this.status = status;
	}
	
	public long getIssueId() {
		return issueId;
	}
	public void setIssueId(long issueId) {
		this.issueId = issueId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}

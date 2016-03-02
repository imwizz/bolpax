package id.co.imwizz.bolpax.model.rest.response;

/**
*
* @author Sangbas
*/
public class IssueTrailRsp {
	
	private String fromAdmin;
	private String time;
	private String message;
	private String issueStatus;
	
	public String getFromAdmin() {
		return fromAdmin;
	}
	public void setFromAdmin(String fromAdmin) {
		this.fromAdmin = fromAdmin;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getIssueStatus() {
		return issueStatus;
	}
	public void setIssueStatus(String issueStatus) {
		this.issueStatus = issueStatus;
	}

}

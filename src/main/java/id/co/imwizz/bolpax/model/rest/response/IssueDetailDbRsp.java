package id.co.imwizz.bolpax.model.rest.response;

public class IssueDetailDbRsp {
	
	private String date;
	private String status;
	private String history;
	private Character fromAdmin;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	public Character getFromAdmin() {
		return fromAdmin;
	}
	public void setFromAdmin(Character fromAdmin) {
		this.fromAdmin = fromAdmin;
	}
	
	

}

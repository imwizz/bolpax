package id.co.imwizz.bolpax.model.rest.request;

public class IssueReq {
	
	private String subject;
	private String desc;
	private String role;
	private long trxId;
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public long getTrxId() {
		return trxId;
	}
	public void setTrxId(long trxId) {
		this.trxId = trxId;
	}
	
	

}

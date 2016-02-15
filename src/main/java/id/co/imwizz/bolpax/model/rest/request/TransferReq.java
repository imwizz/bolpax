package id.co.imwizz.bolpax.model.rest.request;

public class TransferReq {
	
	private long trxId;
	private String refund;
	private String token;
	
	public long getTrxId() {
		return trxId;
	}
	public void setTrxId(long trxId) {
		this.trxId = trxId;
	}
	public String getRefund() {
		return refund;
	}
	public void setRefund(String refund) {
		this.refund = refund;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

}

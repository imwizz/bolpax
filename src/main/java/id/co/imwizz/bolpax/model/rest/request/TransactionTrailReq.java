package id.co.imwizz.bolpax.model.rest.request;

public class TransactionTrailReq {
	
	private long trxId;
	private long trxStatusMappingId;
	
	public long getTrxId() {
		return trxId;
	}
	public void setTrxId(long trxId) {
		this.trxId = trxId;
	}
	public long getTrxStatusMappingId() {
		return trxStatusMappingId;
	}
	public void setTrxStatusMappingId(long trxStatusMappingId) {
		this.trxStatusMappingId = trxStatusMappingId;
	}
	
	

}

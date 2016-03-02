package id.co.imwizz.bolpax.model.rest.request;

import java.util.List;

/**
*
* @author Sangbas
*/
public class TransactionTrailReq {
	
	private long trxId;
	private List<TransactionMappingStatusReq> trxStatusMapping;
	
	public long getTrxId() {
		return trxId;
	}
	public void setTrxId(long trxId) {
		this.trxId = trxId;
	}
	public List<TransactionMappingStatusReq> getTrxStatusMapping() {
		return trxStatusMapping;
	}
	public void setTrxStatusMapping(List<TransactionMappingStatusReq> trxStatusMapping) {
		this.trxStatusMapping = trxStatusMapping;
	}

}

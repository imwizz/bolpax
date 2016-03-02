package id.co.imwizz.bolpax.mandiri.model.rest.response;

/**
* Simple JavaBean domain object representing an Mandiri transfer response
*
* @author Sangbas
*/
public class TransferRsp extends BaseRsp {

	private long trxId;
	private String toAccount;
	private String fromAccount;
	private String amount;
	private String trxDate;
	
	public String getToAccount() {
		return toAccount;
	}
	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}
	public String getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getTrxDate() {
		return trxDate;
	}
	public void setTrxDate(String trxDate) {
		this.trxDate = trxDate;
	}
	public long getTrxId() {
		return trxId;
	}
	public void setTrxId(long trxId) {
		this.trxId = trxId;
	}
	
	
	
}

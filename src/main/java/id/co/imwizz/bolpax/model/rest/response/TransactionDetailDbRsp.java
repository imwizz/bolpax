package id.co.imwizz.bolpax.model.rest.response;

/**
*
* @author Sangbas
*/
public class TransactionDetailDbRsp {
	
	private String trxDate;
	private String buyerTrxHistory;
	private String buyerTrxStatus;
	private String merchantTrxHistory;
	private String merchantTrxStatus;
	
	public String getTrxDate() {
		return trxDate;
	}
	public void setTrxDate(String trxDate) {
		this.trxDate = trxDate;
	}
	public String getBuyerTrxHistory() {
		return buyerTrxHistory;
	}
	public void setBuyerTrxHistory(String buyerTrxHistory) {
		this.buyerTrxHistory = buyerTrxHistory;
	}
	public String getBuyerTrxStatus() {
		return buyerTrxStatus;
	}
	public void setBuyerTrxStatus(String buyerTrxStatus) {
		this.buyerTrxStatus = buyerTrxStatus;
	}
	public String getMerchantTrxHistory() {
		return merchantTrxHistory;
	}
	public void setMerchantTrxHistory(String merchantTrxHistory) {
		this.merchantTrxHistory = merchantTrxHistory;
	}
	public String getMerchantTrxStatus() {
		return merchantTrxStatus;
	}
	public void setMerchantTrxStatus(String merchantTrxStatus) {
		this.merchantTrxStatus = merchantTrxStatus;
	}
	
}

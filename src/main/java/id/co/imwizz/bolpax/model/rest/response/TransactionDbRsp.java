package id.co.imwizz.bolpax.model.rest.response;

/**
*
* @author Sangbas
*/
public class TransactionDbRsp {
	
	private String lastTrxDate;
	private long trxId;
	private String buyer;
	private String merchant;
	private String product;
	private Double amount;
	private String buyerTrxStatus;
	private String merchantTrxStatus;
	private String refund;
	
	public String getLastTrxDate() {
		return lastTrxDate;
	}
	public void setLastTrxDate(String lastTrxDate) {
		this.lastTrxDate = lastTrxDate;
	}
	public long getTrxId() {
		return trxId;
	}
	public void setTrxId(long trxId) {
		this.trxId = trxId;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public String getMerchant() {
		return merchant;
	}
	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getBuyerTrxStatus() {
		return buyerTrxStatus;
	}
	public void setBuyerTrxStatus(String buyerTrxStatus) {
		this.buyerTrxStatus = buyerTrxStatus;
	}
	public String getMerchantTrxStatus() {
		return merchantTrxStatus;
	}
	public void setMerchantTrxStatus(String merchantTrxStatus) {
		this.merchantTrxStatus = merchantTrxStatus;
	}
	public String getRefund() {
		return refund;
	}
	public void setRefund(String refund) {
		this.refund = refund;
	}
	
	

}

package id.co.imwizz.bolpax.model.rest.response;

public class TransactionRsp {
	
	private long trxId;
	private String trxDate;
	private String trxLastStatus;
	private Double amount;
	private String merchant;
	private String buyer;
	private String product;
	
	public String getTrxDate() {
		return trxDate;
	}
	public void setTrxDate(String trxDate) {
		this.trxDate = trxDate;
	}
	public String getTrxLastStatus() {
		return trxLastStatus;
	}
	public void setTrxLastStatus(String trxLastStatus) {
		this.trxLastStatus = trxLastStatus;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
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

}

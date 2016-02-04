package id.co.imwizz.bolpax.model.rest.response;

public class TransactionRsp {
	
	private String trxDate;
	private String trxLastStatus;
	private Double amount;
	private String merchant;
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

}

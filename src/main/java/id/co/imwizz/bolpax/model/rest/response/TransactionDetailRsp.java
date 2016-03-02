package id.co.imwizz.bolpax.model.rest.response;

import java.util.List;

/**
*
* @author Sangbas
*/
public class TransactionDetailRsp {
	
	private Double amount;
	private String merchant;
	private String product;
	private String trxLastStatus;
	private List<TransactionTrailRsp> trxHistory;
	
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
	public String getTrxLastStatus() {
		return trxLastStatus;
	}
	public void setTrxLastStatus(String trxLastStatus) {
		this.trxLastStatus = trxLastStatus;
	}
	public List<TransactionTrailRsp> getTrxHistory() {
		return trxHistory;
	}
	public void setTrxHistory(List<TransactionTrailRsp> trxHistory) {
		this.trxHistory = trxHistory;
	}

	
}

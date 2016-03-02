package id.co.imwizz.bolpax.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Simple JavaBean domain object representing an trx_status table.
 *
 * @author Sangbas
 */
@Entity
@Table(name="trx_status")
public class TransactionStatus {

	@Id
	@GeneratedValue
	@Column(name = "trx_status_id")
	private long trxStatusId;
	
	@Column(name = "status", length = 200)
	private String status;
	
	@Column(name = "status_desc", length = 200)
	private String statusDesc;
	
	@OneToMany(mappedBy = "buyerTrxStatus")
    private Set<TransactionStatusMapping> buyerTrxStatusMappings;
	
	@OneToMany(mappedBy = "merchantTrxStatus")
    private Set<TransactionStatusMapping> merchantTrxStatusMappings;

	public long getTrxStatusId() {
		return trxStatusId;
	}

	public void setTrxStatusId(long trxStatusId) {
		this.trxStatusId = trxStatusId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}
	
	public Set<TransactionStatusMapping> getBuyerTrxStatusMappings() {
		return buyerTrxStatusMappings;
	}

	public void setBuyerTrxStatusMappings(
			Set<TransactionStatusMapping> buyerTrxStatusMappings) {
		this.buyerTrxStatusMappings = buyerTrxStatusMappings;
	}

	public Set<TransactionStatusMapping> getMerchantTrxStatusMappings() {
		return merchantTrxStatusMappings;
	}

	public void setMerchantTrxStatusMappings(
			Set<TransactionStatusMapping> merchantTrxStatusMappings) {
		this.merchantTrxStatusMappings = merchantTrxStatusMappings;
	}

	
	
}

package id.co.imwizz.bolpax.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Simple JavaBean domain object representing an trx_status_mapping table.
 *
 * @author Sangbas
 */
@Entity
@Table(name="trx_status_mapping")
public class TransactionStatusMapping {
	
	@Id
	@GeneratedValue
	@Column(name = "trx_status_mapping_id")
	private long trxStatusMappingId;
	
	@ManyToOne
    @JoinColumn(name = "buyer_trx_status_id", referencedColumnName = "trx_status_id", nullable = true)
	private TransactionStatus buyerTrxStatus;
	
	@ManyToOne
    @JoinColumn(name = "merchant_trx_status_id", referencedColumnName = "trx_status_id", nullable = true)
	private TransactionStatus merchantTrxStatus;
	
	@OneToMany(mappedBy = "trxStatusMapping")
	private Set<TransactionTrail> trxTrails;

	public long getTrxStatusMappingId() {
		return trxStatusMappingId;
	}

	public void setTrxStatusMappingId(long trxStatusMappingId) {
		this.trxStatusMappingId = trxStatusMappingId;
	}

	public TransactionStatus getBuyerTrxStatus() {
		return buyerTrxStatus;
	}

	public void setBuyerTrxStatus(TransactionStatus buyerTrxStatus) {
		this.buyerTrxStatus = buyerTrxStatus;
	}

	public TransactionStatus getMerchantTrxStatus() {
		return merchantTrxStatus;
	}

	public void setMerchantTrxStatus(TransactionStatus merchantTrxStatus) {
		this.merchantTrxStatus = merchantTrxStatus;
	}

	public Set<TransactionTrail> getTrxTrails() {
		return trxTrails;
	}

	public void setTrxTrails(Set<TransactionTrail> trxTrails) {
		this.trxTrails = trxTrails;
	}
	
	

}

package id.co.imwizz.bolpax.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

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
	
	@OneToMany(mappedBy = "trxStatus")
    private Set<TransactionTrail> trxTrails;

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

	@JsonIgnore
	public Set<TransactionTrail> getTrxTrails() {
		return trxTrails;
	}

	public void setTrxTrails(Set<TransactionTrail> trxTrails) {
		this.trxTrails = trxTrails;
	}
	
	
}

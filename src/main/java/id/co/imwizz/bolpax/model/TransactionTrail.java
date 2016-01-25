package id.co.imwizz.bolpax.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="trx_trail")
public class TransactionTrail {

	@Id
	@GeneratedValue
	@Column(name = "trx_trail_id")
	private long trxTrailId;
	
	@Column(name = "role", length = 10)
	private String role;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "sts_date")
    private java.util.Date stsDate;
	
	@ManyToOne
    @JoinColumn(name = "trx_id", referencedColumnName = "trx_id", nullable = false)
	private Transaction trx;
	
	@ManyToOne
    @JoinColumn(name = "trx_status_id", referencedColumnName = "trx_status_id", nullable = false)
	private TransactionStatus trxStatus;

	public long getTrxTrailId() {
		return trxTrailId;
	}

	public void setTrxTrailId(long trxTrailId) {
		this.trxTrailId = trxTrailId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public java.util.Date getStsDate() {
		return stsDate;
	}

	public void setStsDate(java.util.Date stsDate) {
		this.stsDate = stsDate;
	}

	public Transaction getTrx() {
		return trx;
	}

	public void setTrx(Transaction trx) {
		this.trx = trx;
	}

	public TransactionStatus getTrxStatus() {
		return trxStatus;
	}

	public void setTrxStatus(TransactionStatus trxStatus) {
		this.trxStatus = trxStatus;
	}
	
	
}

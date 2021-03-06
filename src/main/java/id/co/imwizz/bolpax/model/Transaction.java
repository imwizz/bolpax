package id.co.imwizz.bolpax.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * Simple JavaBean domain object representing an trx table.
 *
 * @author Sangbas
 */
@Entity
@Table(name="trx")
public class Transaction {
	
	public Transaction() {}

	public Transaction(String productName, Double amount, User user, Merchant merchant) {
		this.productName = productName;
		this.amount = amount;
		this.user = user;
		this.merchant = merchant;
	}

	@Id
	@GeneratedValue
	@Column(name = "trx_id")
	private long trxId;
	
	@Column(name = "product_name", length = 200)
	private String productName;
	
	@Column(name = "amount")
	private Double amount;
	
	@ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
	private User user;
	
	@ManyToOne
    @JoinColumn(name = "merchant_id", referencedColumnName = "merchant_id", nullable = false)
	private Merchant merchant;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "trx")
	@OrderBy("stsDate")
    private Set<TransactionTrail> trxTrails;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "trx")
    private Set<Issue> issues;

	public long getTrxId() {
		return trxId;
	}

	public void setTrxId(long trxId) {
		this.trxId = trxId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	@JsonIgnore
	public Set<TransactionTrail> getTrxTrails() {
		return trxTrails;
	}

	public void setTrxTrails(Set<TransactionTrail> trxTrails) {
		this.trxTrails = trxTrails;
	}

	@JsonIgnore
	public Set<Issue> getIssues() {
		return issues;
	}

	public void setIssues(Set<Issue> issues) {
		this.issues = issues;
	}
	
	
}

package id.co.imwizz.bolpax.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="merchant")
public class Merchant {
	
	@Id
	@GeneratedValue
	@Column(name = "merchant_id")
	private long merchantId;
	
	@Column(name = "merchant_name", length = 200)
	private String merchantName;
	
	@OneToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
	private User user;
	
	@OneToMany(mappedBy = "merchant")
    private Set<Transaction> transactions;
	
	public Merchant() {}
	
	public Merchant(String merchantName, User user) {
		this.merchantName = merchantName;
		this.user = user;
	}

	public long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(long merchantId) {
		this.merchantId = merchantId;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@JsonIgnore
	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	
}

package id.co.imwizz.bolpax.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * Simple JavaBean domain object representing an user table.
 *
 * @author Sangbas
 */
@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private long userId;
	
	@Column(name = "email", length = 100, unique=true)
	private String email;
	
	@Column(name = "password", length = 10)
	private String password;
	
	@Column(name = "phone", length = 20, unique=true)
	private String phone;
	
	@Column(name = "fullname", length = 200)
	private String fullname;
	
	@OneToMany(mappedBy = "user")
    private Set<Transaction> transactions;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	@JsonIgnore
	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	
}

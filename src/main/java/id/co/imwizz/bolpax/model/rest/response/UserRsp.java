package id.co.imwizz.bolpax.model.rest.response;

/**
*
* @author Sangbas
*/
public class UserRsp {
	
	private long userId;
	private String email;
	private String phone;
	private String fullname;
	private String balance;
	
	public UserRsp(long userId, String email, String phone, String fullname,
			String balance) {
		this.userId = userId;
		this.email = email;
		this.phone = phone;
		this.fullname = fullname;
		this.balance = balance;
	}
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
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}

}

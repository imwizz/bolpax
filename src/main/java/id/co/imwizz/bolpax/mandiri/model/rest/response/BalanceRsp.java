package id.co.imwizz.bolpax.mandiri.model.rest.response;

public class BalanceRsp extends BaseRsp {

	private String creditLimit;
	private String accountBalance;
	
	public String getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(String creditLimit) {
		this.creditLimit = creditLimit;
	}
	public String getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(String accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	
	
}

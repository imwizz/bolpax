package id.co.imwizz.bolpax.model.rest.response;

/**
*
* @author Sangbas
*/
public class MerchantRsp {
	
	private String merchantName;
	private long merchantId;
	private UserRsp user;
	
	public MerchantRsp() {}
	
	public MerchantRsp(String merchantName, long merchantId, UserRsp user) {
		this.merchantName = merchantName;
		this.merchantId = merchantId;
		this.user = user;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	public long getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(long merchantId) {
		this.merchantId = merchantId;
	}
	public UserRsp getUser() {
		return user;
	}
	public void setUser(UserRsp user) {
		this.user = user;
	}

}

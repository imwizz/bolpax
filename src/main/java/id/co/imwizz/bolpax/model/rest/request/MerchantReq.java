package id.co.imwizz.bolpax.model.rest.request;

/**
*
* @author Sangbas
*/
public class MerchantReq {

	private String name;
	private long userId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
}

package id.co.imwizz.bolpax.model.rest.response;

public class LoginRsp {
	
	private long userId;
	private String token;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
}

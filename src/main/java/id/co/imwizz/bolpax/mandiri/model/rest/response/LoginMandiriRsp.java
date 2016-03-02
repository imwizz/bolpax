package id.co.imwizz.bolpax.mandiri.model.rest.response;

/**
* Simple JavaBean domain object representing an Mandiri login response
*
* @author Sangbas
*/
public class LoginMandiriRsp extends BaseRsp {

	private String token;
	private String msisdn;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	
	
	
}

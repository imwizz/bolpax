package id.co.imwizz.bolpax.mandiri.client;

import id.co.imwizz.bolpax.mandiri.model.rest.response.BalanceRsp;
import id.co.imwizz.bolpax.mandiri.model.rest.response.LoginMandiriRsp;
import id.co.imwizz.bolpax.mandiri.model.rest.response.LogoutRsp;
import id.co.imwizz.bolpax.mandiri.model.rest.response.TransferRsp;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
* 
* 
* @author Sangbas
*/
@Service
public class MandiriService {
	
	@Autowired private RestTemplate restTemplate;
	
	private static final String MANDIRI_URI =
	        "https://api.apim.ibmcloud.com/ex-icha-fmeirisidibmcom-ecash-be/sb/emoney/v1";
	
	private static final String UID = "XXXXXXXXXXX";
	
	/**
	 * Login into Mandiri API in order to acquire token
	 * @param msisdn
	 * @param credentials
	 * @return
	 */
	public LoginMandiriRsp doLogin(String msisdn, String credentials) {
		URI targetUrl= UriComponentsBuilder.fromUriString(MANDIRI_URI)
			    .path("/loginMember")
			    .queryParam("msisdn", msisdn)
			    .queryParam("uid", UID)
			    .queryParam("credentials", credentials)
			    .build()
			    .toUri();
		LoginMandiriRsp login = restTemplate.getForObject(targetUrl, LoginMandiriRsp.class);
		return login;
	}
	
	/**
	 * Logout from Mandiri in order to cleanup token session
	 * @param msisdn
	 * @param token
	 * @return
	 */
	public LogoutRsp doLogout(String msisdn, String token) {
		URI targetUrl= UriComponentsBuilder.fromUriString(MANDIRI_URI)
			    .path("/logoutMember")
			    .queryParam("msisdn", msisdn)
			    .queryParam("token", token)
			    .build()
			    .toUri();
		LogoutRsp logout = restTemplate.getForObject(targetUrl, LogoutRsp.class);
		return logout;
	}
	
	/**
	 * Inquiry balance from Mandiri
	 * @param msisdn
	 * @param token
	 * @return
	 */
	public BalanceRsp inquiryBalance(String msisdn, String token) {
		URI targetUrl= UriComponentsBuilder.fromUriString(MANDIRI_URI)
			    .path("/balanceInquiry")
			    .queryParam("msisdn", msisdn)
			    .queryParam("token", token)
			    .build()
			    .toUri();
		BalanceRsp login = restTemplate.getForObject(targetUrl, BalanceRsp.class);
		return login;
	}

	/**
	 * Transfer payment action between e-cash members
	 * @param from
	 * @param to
	 * @param amount
	 * @param description
	 * @param credentials
	 * @param token
	 * @return
	 */
	public TransferRsp doTransfer(String from, String to, String amount, String description, String credentials, String token) {
		URI targetUrl= UriComponentsBuilder.fromUriString(MANDIRI_URI)
			    .path("/transferMember")
			    .queryParam("from", from)
			    .queryParam("to", to)
			    .queryParam("amount", amount)
			    .queryParam("description", description)
			    .queryParam("credentials", credentials)
			    .queryParam("token", token)
			    .build()
			    .toUri();
		TransferRsp login = restTemplate.getForObject(targetUrl, TransferRsp.class);
		return login;
	}

}

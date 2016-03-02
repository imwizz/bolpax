package id.co.imwizz.bolpax.controller;

import id.co.imwizz.bolpax.dao.MerchantDao;
import id.co.imwizz.bolpax.dao.UserDao;
import id.co.imwizz.bolpax.mandiri.client.MandiriService;
import id.co.imwizz.bolpax.mandiri.model.rest.response.BalanceRsp;
import id.co.imwizz.bolpax.mandiri.model.rest.response.LoginMandiriRsp;
import id.co.imwizz.bolpax.mandiri.model.rest.response.LogoutRsp;
import id.co.imwizz.bolpax.model.Merchant;
import id.co.imwizz.bolpax.model.User;
import id.co.imwizz.bolpax.model.rest.request.MerchantReq;
import id.co.imwizz.bolpax.model.rest.response.LoginRsp;
import id.co.imwizz.bolpax.model.rest.response.MerchantRsp;
import id.co.imwizz.bolpax.model.rest.response.UserRsp;
import id.co.imwizz.bolpax.util.JsonMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
*
* @author Sangbas
*/
@RestController
@RequestMapping("/profile")
public class ProfileController {
	
	@Autowired private UserDao userDao;
	@Autowired private MerchantDao merchantDao;
	@Autowired private MandiriService mandiriService;
	
	/**
	 * Login into Mandiri API to get token which will be used for check balance and transfer e-cash
	 * @param phone
	 * @param pass
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json", value = "dologin")
    @ResponseBody
	public ResponseEntity<String> doLogin(@RequestParam("phone") String phone, @RequestParam("pass") String pass) {
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        
        User user = userDao.findUserByPhone(phone);
        Merchant merchant = merchantDao.findMerchantByUserId(user.getUserId());
        
        LoginMandiriRsp loginMandiri = mandiriService.doLogin(phone, pass);
        
        LoginRsp login = new LoginRsp();
        login.setUserId(user.getUserId());
        login.setToken(loginMandiri.getToken());
        login.setStatus(loginMandiri.getStatus());
        login.setFullname(user.getFullname());
        login.setPhone(user.getPhone());
        if(merchant != null) {
        	login.setMerchantId(merchant.getMerchantId());
            login.setMerchantName(merchant.getMerchantName());
        }
        
        return new ResponseEntity<String>(JsonMapper.fromObjectToJson(login), headers, HttpStatus.OK);
	}
	
	/**
	 * Logout from mandiri API
	 * @param phone
	 * @param token
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json", value = "dologout")
    @ResponseBody
	public ResponseEntity<String> doLogout(@RequestParam("phone") String phone, @RequestParam("token") String token) {
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");

        LogoutRsp logout = mandiriService.doLogout(phone, token);
        
        return new ResponseEntity<String>(JsonMapper.fromObjectToJson(logout), headers, HttpStatus.OK);
	}

	/**
	 * Return buyer info from Bolpax and balance info from Mandiri by user id
	 * @param userid
	 * @param token
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json", value = "user")
    @ResponseBody
	public ResponseEntity<String> findUserById(@RequestParam("userid") long userid, @RequestParam("token") String token) {
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        User user = userDao.get(userid);
        
        BalanceRsp balance = mandiriService.inquiryBalance(user.getPhone(), token);
        UserRsp userRsp = new UserRsp(user.getUserId(), user.getEmail(), user.getPhone(), user.getFullname(), balance.getAccountBalance());
        
        return new ResponseEntity<String>(JsonMapper.fromObjectToJson(userRsp), headers, HttpStatus.OK);
	}
	
	/**
	 * Return merchant info from Bolpax and balance info from Mandiri by user id
	 * @param userid
	 * @param token
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json", value = "merchant")
    @ResponseBody
	public ResponseEntity<String> findMerchantById(@RequestParam("userid") long userId, @RequestParam("token") String token) {
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        Merchant merchant = merchantDao.findMerchantByUserId(userId);
        
        MerchantRsp merchantRsp = null;
        
        if(merchant != null) {
        	BalanceRsp balance = mandiriService.inquiryBalance(merchant.getUser().getPhone(), token);
            UserRsp userRsp = new UserRsp(merchant.getUser().getUserId(), merchant.getUser().getEmail(), merchant.getUser().getPhone(), merchant.getUser().getFullname(), balance.getAccountBalance());
            merchantRsp = new MerchantRsp(merchant.getMerchantName(), merchant.getMerchantId(), userRsp);
        }
        
        return new ResponseEntity<String>(JsonMapper.fromObjectToJson(merchantRsp), headers, HttpStatus.OK);
	}
	
	/**
	 * Create a new user by insert data into table user
	 * @param json => accepted json format {"email":"","password":"","phone":"","fullname":""}
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json", value = "createUser")
	public ResponseEntity<String> createUser(@RequestBody String json) {
		JsonMapper<User> jMapper = new JsonMapper<User>(User.class);
		User obj = jMapper.fromJsonToObject(json);
		
		userDao.persist(obj);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	/**
	 * Create a new merchant by insert data into table merchant
	 * @param json => accepted json format {"name":"","userId":""}
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json", value = "createMerchant")
	public ResponseEntity<String> createMerchant(@RequestBody String json) {
		JsonMapper<MerchantReq> jMapper = new JsonMapper<MerchantReq>(MerchantReq.class);
		MerchantReq merhcantReq = jMapper.fromJsonToObject(json);
		
		String merchantName = merhcantReq.getName();
		User user = userDao.get(merhcantReq.getUserId());
		
		Merchant merchant = new Merchant(merchantName, user);
		
		merchantDao.persist(merchant);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
}

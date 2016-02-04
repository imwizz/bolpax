package id.co.imwizz.bolpax.controller;

import id.co.imwizz.bolpax.dao.MerchantDao;
import id.co.imwizz.bolpax.dao.UserDao;
import id.co.imwizz.bolpax.model.Merchant;
import id.co.imwizz.bolpax.model.User;
import id.co.imwizz.bolpax.model.rest.request.MerchantReq;
import id.co.imwizz.bolpax.util.JsonMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/profile")
public class ProfileController {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private MerchantDao merchantDao;

	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json", value = "user")
    @ResponseBody
	public ResponseEntity<String> findUserByPhone(@RequestParam("phone") String phone) {
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        User result = userDao.findUserByPhone(phone);
        return new ResponseEntity<String>(JsonMapper.fromObjectToJson(result), headers, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json", value = "merchant")
    @ResponseBody
	public ResponseEntity<String> findMerchantById(@RequestParam("userid") long userId) {
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        Merchant result = merchantDao.findMerchantByUserId(userId);
        return new ResponseEntity<String>(JsonMapper.fromObjectToJson(result), headers, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json", value = "createUser")
	public ResponseEntity<String> createUser(@RequestBody String json) {
		JsonMapper<User> jMapper = new JsonMapper<User>(User.class);
		User obj = jMapper.fromJsonToObject(json);
		userDao.persist(obj);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
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

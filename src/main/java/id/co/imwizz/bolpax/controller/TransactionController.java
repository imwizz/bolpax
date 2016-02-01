package id.co.imwizz.bolpax.controller;

import id.co.imwizz.bolpax.dao.MerchantDao;
import id.co.imwizz.bolpax.dao.TransactionDao;
import id.co.imwizz.bolpax.dao.TransactionStatusDao;
import id.co.imwizz.bolpax.dao.TransactionTrailDao;
import id.co.imwizz.bolpax.dao.UserDao;
import id.co.imwizz.bolpax.model.Merchant;
import id.co.imwizz.bolpax.model.Transaction;
import id.co.imwizz.bolpax.model.TransactionStatus;
import id.co.imwizz.bolpax.model.TransactionTrail;
import id.co.imwizz.bolpax.model.User;
import id.co.imwizz.bolpax.model.rest.TransactionRS;
import id.co.imwizz.bolpax.util.JsonMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/trx")
public class TransactionController {
	
	@Autowired
	private TransactionDao trxDao;
	
	@Autowired
	private TransactionTrailDao trxTrailDao;

	@Autowired
	private TransactionStatusDao trxStatusDao;
	
	@Autowired
	private MerchantDao merchantDao;
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json", value = "payment")
	public ResponseEntity<String> createPayment(@RequestBody String json) {
		JsonMapper<TransactionRS> jMapper = new JsonMapper<TransactionRS>(TransactionRS.class);
		TransactionRS trxRs = jMapper.fromJsonToObject(json);
		
		Double amt = trxRs.getAmount();
		Merchant merchant = merchantDao.get(trxRs.getMerchantId());
		User user = userDao.get(trxRs.getUserId());
		String prod = trxRs.getProduct();
		
		Transaction trx = new Transaction(prod, amt, user, merchant);
		trxDao.persist(trx);
		
		TransactionStatus trxStatus = trxStatusDao.get(Long.valueOf("1"));
		
		TransactionTrail trxTrail = new TransactionTrail();
		trxTrail.setTrx(trx);
		trxTrail.setTrxStatus(trxStatus);
		trxTrailDao.persist(trxTrail);
		
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json", value = "insertTrail")
	public ResponseEntity<String> insertTrail(@RequestBody String json) {
		JsonMapper<TransactionTrail> jMapper = new JsonMapper<TransactionTrail>(TransactionTrail.class);
		TransactionTrail trxTrail = jMapper.fromJsonToObject(json);
		
		trxTrailDao.persist(trxTrail);
		
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

}

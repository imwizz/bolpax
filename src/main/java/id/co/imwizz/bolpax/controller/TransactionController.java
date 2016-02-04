package id.co.imwizz.bolpax.controller;

import java.util.List;

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
import id.co.imwizz.bolpax.model.rest.request.TransactionReq;
import id.co.imwizz.bolpax.model.rest.request.TransactionTrailReq;
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
	
	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json", value = "listbybuyer")
    @ResponseBody
	public ResponseEntity<String> getListByBuyer(@RequestParam("userid") long userid) {
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        
        List<Transaction> trxs = trxDao.findTrxByUserId(userid);
        return new ResponseEntity<String>(JsonMapper.fromObjectListtoJsonArray(trxs), headers, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json", value = "listbymerchant")
    @ResponseBody
	public ResponseEntity<String> getListByMerchant(@RequestParam("userid") long userid) {
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        
        List<Transaction> trxs = trxDao.findTrxByUserId(userid);
        return new ResponseEntity<String>(JsonMapper.fromObjectListtoJsonArray(trxs), headers, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json", value = "detail")
    @ResponseBody
	public ResponseEntity<String> getDetail(@RequestParam("trxid") long trxid) {
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        
        Transaction trx = trxDao.get(trxid);
        return new ResponseEntity<String>(JsonMapper.fromObjectToJson(trx), headers, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json", value = "payment")
	public ResponseEntity<String> createPayment(@RequestBody String json) {
		JsonMapper<TransactionReq> jMapper = new JsonMapper<TransactionReq>(TransactionReq.class);
		TransactionReq trxRs = jMapper.fromJsonToObject(json);
		
		Double amt = trxRs.getAmount();
		Merchant merchant = merchantDao.get(trxRs.getMerchantId());
		User user = userDao.get(trxRs.getUserId());
		String prod = trxRs.getProduct();
		
		//insert into transaction
		Transaction trx = new Transaction(prod, amt, user, merchant);
		trxDao.persist(trx);
		
		//insert into transaction_trail
		TransactionStatus trxStatus = trxStatusDao.get(Long.valueOf("1"));
		TransactionTrail trxTrail = new TransactionTrail(trx, trxStatus);
		trxTrailDao.persist(trxTrail);
		
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json", value = "insertTrail")
	public ResponseEntity<String> insertTrail(@RequestBody String json) {
		JsonMapper<TransactionTrailReq> jMapper = new JsonMapper<TransactionTrailReq>(TransactionTrailReq.class);
		TransactionTrailReq trxTrailRS = jMapper.fromJsonToObject(json);
		
		Transaction trx = trxDao.get(trxTrailRS.getTrxId());
		TransactionStatus trxStatus = trxStatusDao.get(trxTrailRS.getTrxStatusId());
		
		//insert into transaction_trail
		TransactionTrail trxTrail = new TransactionTrail(trx, trxStatus);
		
		trxTrailDao.persist(trxTrail);
		
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

}

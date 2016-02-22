package id.co.imwizz.bolpax.controller;

import id.co.imwizz.bolpax.dao.IssueDao;
import id.co.imwizz.bolpax.dao.IssueStatusDao;
import id.co.imwizz.bolpax.dao.IssueTrailDao;
import id.co.imwizz.bolpax.dao.MerchantDao;
import id.co.imwizz.bolpax.dao.TransactionDao;
import id.co.imwizz.bolpax.dao.TransactionStatusDao;
import id.co.imwizz.bolpax.dao.TransactionStatusMappingDao;
import id.co.imwizz.bolpax.dao.TransactionTrailDao;
import id.co.imwizz.bolpax.dao.UserDao;
import id.co.imwizz.bolpax.mandiri.client.MandiriService;
import id.co.imwizz.bolpax.mandiri.model.rest.response.LoginMandiriRsp;
import id.co.imwizz.bolpax.mandiri.model.rest.response.TransferRsp;
import id.co.imwizz.bolpax.model.Issue;
import id.co.imwizz.bolpax.model.IssueStatus;
import id.co.imwizz.bolpax.model.IssueTrail;
import id.co.imwizz.bolpax.model.Merchant;
import id.co.imwizz.bolpax.model.Transaction;
import id.co.imwizz.bolpax.model.TransactionStatusMapping;
import id.co.imwizz.bolpax.model.TransactionTrail;
import id.co.imwizz.bolpax.model.User;
import id.co.imwizz.bolpax.model.rest.request.TransactionMappingStatusReq;
import id.co.imwizz.bolpax.model.rest.request.TransactionReq;
import id.co.imwizz.bolpax.model.rest.request.TransactionTrailReq;
import id.co.imwizz.bolpax.model.rest.request.TransferReq;
import id.co.imwizz.bolpax.model.rest.response.TransactionDbRsp;
import id.co.imwizz.bolpax.model.rest.response.TransactionDetailDbRsp;
import id.co.imwizz.bolpax.model.rest.response.TransactionDetailRsp;
import id.co.imwizz.bolpax.model.rest.response.TransactionRsp;
import id.co.imwizz.bolpax.model.rest.response.TransactionTrailRsp;
import id.co.imwizz.bolpax.util.JsonMapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
	private TransactionStatusMappingDao trxStatusMappingDao;
	
	@Autowired
	private MerchantDao merchantDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private IssueDao issueDao;
	
	@Autowired
	private IssueTrailDao issueTrailDao;
	
	@Autowired 
	private IssueStatusDao issueStatusDao;
	
	@Autowired
	private MandiriService mandiriService;
	
	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json", value = "listbybuyer")
    @ResponseBody
	public ResponseEntity<String> getListByBuyer(@RequestParam("userid") long userid) {
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        
        List<Transaction> trxs = trxDao.findTrxByUserId(userid);
        List<TransactionRsp> trxRsps = null;
        
        if(trxs.size() > 0) {
        	trxRsps = new ArrayList<TransactionRsp>();
        	for (Transaction trx : trxs) {
    			TransactionRsp trxRsp = new TransactionRsp();
    			trxRsp.setTrxId(trx.getTrxId());
    			trxRsp.setAmount(trx.getAmount());
    			trxRsp.setMerchant(trx.getMerchant().getMerchantName());
    			trxRsp.setProduct(trx.getProductName());
    			
    			Iterator<TransactionTrail> itr = trx.getTrxTrails().iterator();
    		    String trxLastDate = null;
    		    String trxLastStatus = null;
    		    while(itr.hasNext()) {
    		    	TransactionTrail trxTrail = (TransactionTrail) itr.next();
    		    	if(trxTrail.getTrxStatusMapping().getBuyerTrxStatus().getStatus() != null) {
    		    		trxLastDate = trxTrail.getStsDate().toString();
        		    	trxLastStatus = trxTrail.getTrxStatusMapping().getBuyerTrxStatus().getStatus();
    		    	}
    		    }
    			
    			trxRsp.setTrxDate(trxLastDate); 
    			trxRsp.setTrxLastStatus(trxLastStatus); 
    			
    			trxRsps.add(trxRsp);
    		}
        }
        
        return new ResponseEntity<String>(JsonMapper.fromObjectListtoJsonArray(trxRsps), headers, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json", value = "listbymerchant")
    @ResponseBody
	public ResponseEntity<String> getListByMerchant(@RequestParam("merchantid") long merchantId) {
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        
        List<Transaction> trxs = trxDao.findTrxByMerchantId(merchantId);
        List<TransactionRsp> trxRsps = null;
        
        if(trxs.size() > 0) {
        	trxRsps = new ArrayList<TransactionRsp>();
        	for (Transaction trx : trxs) {
    			TransactionRsp trxRsp = new TransactionRsp();
    			trxRsp.setTrxId(trx.getTrxId());
    			trxRsp.setAmount(trx.getAmount());
    			trxRsp.setMerchant(trx.getMerchant().getMerchantName());
    			trxRsp.setProduct(trx.getProductName());
    			
    			Iterator<TransactionTrail> itr = trx.getTrxTrails().iterator();
    		    String trxLastDate = null;
    		    String trxLastStatus = null;
    		    while(itr.hasNext()) {
    		    	TransactionTrail trxTrail =(TransactionTrail) itr.next();
    		    	trxLastDate = trxTrail.getStsDate().toString();
    		    	trxLastStatus = trxTrail.getTrxStatusMapping().getMerchantTrxStatus().getStatus();
    		    }
    			
    			trxRsp.setTrxDate(trxLastDate); 
    			trxRsp.setTrxLastStatus(trxLastStatus); 
    			
    			trxRsps.add(trxRsp);
    		}
        }
        
        return new ResponseEntity<String>(JsonMapper.fromObjectListtoJsonArray(trxRsps), headers, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json", value = "detail")
    @ResponseBody
	public ResponseEntity<String> getDetail(@RequestParam("trxid") long trxid, @RequestParam("role") String role) {
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        
        Transaction trx = trxDao.get(trxid);
        
        TransactionDetailRsp trxDetailRsp = new TransactionDetailRsp();
        trxDetailRsp.setAmount(trx.getAmount());
        trxDetailRsp.setMerchant(trx.getMerchant().getMerchantName());
        trxDetailRsp.setProduct(trx.getProductName());
		
		Iterator<TransactionTrail> itr = trx.getTrxTrails().iterator();
		List<TransactionTrailRsp> trxTrailRsps = new ArrayList<TransactionTrailRsp>();
		String lastStatus = null;
	    while(itr.hasNext()) {
	    	TransactionTrail trxTrail =(TransactionTrail) itr.next();
	    	TransactionTrailRsp trxTrailRsp = new TransactionTrailRsp();
	    	trxTrailRsp.setTime(trxTrail.getStsDate().toString());
	    	
	    	if(role.equalsIgnoreCase("buyer")) {
	    		if(trxTrail.getTrxStatusMapping().getBuyerTrxStatus().getStatus() != null) {
	    			trxTrailRsp.setStatus(trxTrail.getTrxStatusMapping().getBuyerTrxStatus().getStatusDesc());
			    	lastStatus = trxTrail.getTrxStatusMapping().getBuyerTrxStatus().getStatus();
			    	trxTrailRsps.add(trxTrailRsp);
	    		}
	    	} else if(role.equalsIgnoreCase("merchant")) {
	    		if(trxTrail.getTrxStatusMapping().getMerchantTrxStatus().getStatus() != null) {
	    			trxTrailRsp.setStatus(trxTrail.getTrxStatusMapping().getMerchantTrxStatus().getStatusDesc());
			    	lastStatus = trxTrail.getTrxStatusMapping().getMerchantTrxStatus().getStatus();
			    	trxTrailRsps.add(trxTrailRsp);
	    		}
	    	}
	    }
		trxDetailRsp.setTrxHistory(trxTrailRsps);
		trxDetailRsp.setTrxLastStatus(lastStatus);
		
        return new ResponseEntity<String>(JsonMapper.fromObjectToJson(trxDetailRsp), headers, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json", value = "payment")
	public ResponseEntity<String> createPayment(@RequestBody String json) {
		JsonMapper<TransactionReq> jMapper = new JsonMapper<TransactionReq>(TransactionReq.class);
		TransactionReq trxRs = jMapper.fromJsonToObject(json);
		
		Double amt = trxRs.getAmount();
		Merchant merchant = merchantDao.get(trxRs.getMerchantId());
		User user = userDao.get(trxRs.getUserId());
		String prod = trxRs.getProduct();
		
		User userAdmin = userDao.get(Long.valueOf(99));

		// create new transaction
		Transaction trx = new Transaction(prod, amt, user, merchant);
		trxDao.persist(trx);

		// insert into transaction_trail initiate payment
		TransactionStatusMapping trxStatusMapping = trxStatusMappingDao.get(Long.valueOf("1"));
		TransactionTrail trxTrail = new TransactionTrail(trx, trxStatusMapping);
		trxTrailDao.persist(trxTrail);

		//transfer to pool account
		TransferRsp transfer = mandiriService.doTransfer(user.getPhone(), userAdmin.getPhone(), amt.toString(), trxRs.getProduct(), user.getPassword(), trxRs.getToken());
		transfer.setTrxId(trx.getTrxId());
		
		//insert into transaction_trail payment completed by buyer
		if(transfer.getStatus().equals("PROCESSED")) {
			//insert into transaction_trail
			trxStatusMapping = trxStatusMappingDao.get(Long.valueOf("2"));
			trxTrail = new TransactionTrail(trx, trxStatusMapping);
			trxTrailDao.persist(trxTrail);
		}
		
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<String>(JsonMapper.fromObjectToJson(transfer), headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json", value = "insertTrail")
	public ResponseEntity<String> insertTrail(@RequestBody String json) {
		JsonMapper<TransactionTrailReq> jMapper = new JsonMapper<TransactionTrailReq>(TransactionTrailReq.class);
		TransactionTrailReq trxTrailRS = jMapper.fromJsonToObject(json);
		
		List<TransactionMappingStatusReq> trxStatusMappingReqs = trxTrailRS.getTrxStatusMapping();
		for (TransactionMappingStatusReq trxMappingStatusReq : trxStatusMappingReqs) {
			Transaction trx = trxDao.get(trxTrailRS.getTrxId());
			TransactionStatusMapping trxStatusMapping = trxStatusMappingDao.get(trxMappingStatusReq.getId());
			
			//insert into transaction_trail
			TransactionTrail trxTrail = new TransactionTrail(trx, trxStatusMapping);
			
			trxTrailDao.persist(trxTrail);
			
			if(trxMappingStatusReq.getId() == 6) {
				User userAdmin = userDao.get(Long.valueOf(99));
				LoginMandiriRsp loginMandiri = mandiriService.doLogin(userAdmin.getPhone(), userAdmin.getPassword());
				
				String destination = trx.getMerchant().getUser().getPhone();
				TransferRsp transfer = mandiriService.doTransfer(userAdmin.getPhone(), destination, trx.getAmount().toString(), trx.getProductName(), userAdmin.getPassword(), loginMandiri.getToken());
				
				//transaction changed to completed
				TransactionTrail trxTrailTransfer = new TransactionTrail(trx, trxStatusMapping);
				trxTrailDao.persist(trxTrailTransfer);
				
				System.out.println(JsonMapper.fromObjectToJson(transfer));
			}
		}
		
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json", value = "list")
    @ResponseBody
	public ResponseEntity<String> getAll() {
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        
        List<Transaction> trxs = trxDao.getAll();
        List<TransactionDbRsp> trxRsps = new ArrayList<TransactionDbRsp>();
        String buyerStatus = null; 
        String merchantStatus = null; 
        String lastTrxDate = null;
        
        for (Transaction trx : trxs) {
        	TransactionDbRsp trxRsp = new TransactionDbRsp();
        	trxRsp.setAmount(trx.getAmount());
        	trxRsp.setBuyer(trx.getUser().getFullname());
        	trxRsp.setMerchant(trx.getMerchant().getMerchantName());
        	trxRsp.setProduct(trx.getProductName());
        	trxRsp.setTrxId(trx.getTrxId());
        	
        	Iterator<TransactionTrail> itr = trx.getTrxTrails().iterator();
    	    while(itr.hasNext()) {
    	    	TransactionTrail trxTrail = itr.next();
    	    	buyerStatus = trxTrail.getTrxStatusMapping().getBuyerTrxStatus().getStatus();
    	    	merchantStatus = trxTrail.getTrxStatusMapping().getMerchantTrxStatus().getStatus();
    	    	lastTrxDate = trxTrail.getStsDate().toString();
    	    }
        	
        	trxRsp.setBuyerTrxStatus(buyerStatus);
        	trxRsp.setMerchantTrxStatus(merchantStatus);
        	trxRsp.setLastTrxDate(lastTrxDate);
        	
        	if(isRefund(trx)) trxRsp.setRefund("Yes");
        	
        	trxRsps.add(trxRsp);
		}
		
		return new ResponseEntity<String>(JsonMapper.fromObjectToJson(trxRsps), headers, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json", value = "detailcomplete")
    @ResponseBody
	public ResponseEntity<String> getDetailCompelete(@RequestParam("trxid") long trxId) {
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        
        Transaction trx = trxDao.get(trxId);
        List<TransactionDetailDbRsp> trxDetails = new ArrayList<TransactionDetailDbRsp>();
        
        Iterator<TransactionTrail> itr = trx.getTrxTrails().iterator();
        while(itr.hasNext()) {
        	TransactionTrail trxTrail = itr.next();
        	TransactionDetailDbRsp trxTrailRsp = new TransactionDetailDbRsp();
        	trxTrailRsp.setTrxDate(trxTrail.getStsDate().toString());
        	trxTrailRsp.setBuyerTrxHistory(trxTrail.getTrxStatusMapping().getBuyerTrxStatus().getStatusDesc());
        	trxTrailRsp.setBuyerTrxStatus(trxTrail.getTrxStatusMapping().getBuyerTrxStatus().getStatus());
        	trxTrailRsp.setMerchantTrxHistory(trxTrail.getTrxStatusMapping().getMerchantTrxStatus().getStatusDesc());
        	trxTrailRsp.setMerchantTrxStatus(trxTrail.getTrxStatusMapping().getMerchantTrxStatus().getStatus());
        	trxDetails.add(trxTrailRsp);
        }
        
		
        return new ResponseEntity<String>(JsonMapper.fromObjectToJson(trxDetails), headers, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json", value = "refund")
	public ResponseEntity<String> doTransfer(@RequestBody String json) {
		JsonMapper<TransferReq> jMapper = new JsonMapper<TransferReq>(TransferReq.class);
		TransferReq transferReq = jMapper.fromJsonToObject(json);
		
		long trxId = transferReq.getTrxId();
//		String refund = transferReq.getRefund();
		
		Transaction trx = trxDao.get(trxId);
		
		User userAdmin = userDao.get(Long.valueOf(99));
		LoginMandiriRsp loginMandiri = mandiriService.doLogin(userAdmin.getPhone(), userAdmin.getPassword());
		
		String destination = null;
		TransferRsp transfer = null;
//		if(refund.equalsIgnoreCase("Y")) {
			destination = trx.getUser().getPhone();
			transfer = mandiriService.doTransfer(userAdmin.getPhone(), destination, trx.getAmount().toString(), trx.getProductName(), userAdmin.getPassword(), loginMandiri.getToken());
			
			//transaction changed to cancelled
			TransactionStatusMapping trxStatusMapping = trxStatusMappingDao.get(Long.valueOf(7));
			TransactionTrail trxTrail = new TransactionTrail(trx, trxStatusMapping);
			trxTrailDao.persist(trxTrail);
			
			//issue changed to refund
			Issue issue = issueDao.findIssueByTrxId(trxId);
			IssueStatus issueRefund = issueStatusDao.get(Long.valueOf(5));
			IssueTrail issueTrailRefund = new IssueTrail(Character.valueOf('Y'), "Proses refund telah dilakukan", issue, issueRefund);
			issueTrailDao.persist(issueTrailRefund);
			
			//issue changed to closed
			IssueStatus issueClosed = issueStatusDao.get(Long.valueOf(6));
			IssueTrail issueTrailClosed = new IssueTrail(Character.valueOf('Y'), "Closed", issue, issueClosed);
			issueTrailDao.persist(issueTrailClosed);
//		} else {
//			destination = trx.getMerchant().getUser().getPhone();
//			transfer = mandiriService.doTransfer(userAdmin.getPhone(), destination, trx.getAmount().toString(), trx.getProductName(), userAdmin.getPassword(), loginMandiri.getToken());
//			
//			//transaction changed to completed
//			TransactionStatusMapping trxStatusMapping = trxStatusMappingDao.get(Long.valueOf("6"));
//			TransactionTrail trxTrail = new TransactionTrail(trx, trxStatusMapping);
//			trxTrailDao.persist(trxTrail);
//		}
		
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        
        return new ResponseEntity<String>(JsonMapper.fromObjectToJson(transfer), headers, HttpStatus.CREATED);
	}
	
	private boolean isRefund(Transaction trx) {
		Iterator<Issue> itrIssue = trx.getIssues().iterator();
    	while(itrIssue.hasNext()) {
    		Issue issue = itrIssue.next();
    		Iterator<IssueTrail> itrIssueTrail = issue.getIssueTrails().iterator();
    		while(itrIssueTrail.hasNext()) {
    			IssueTrail issueTrail = itrIssueTrail.next();
    			String refund = issueTrail.getIssueStatus().getStatus();
    			
    			if(refund.equals("Refund")) {
    				return true;
    			}
    		}
    	}
    	
    	return false;
	}

}
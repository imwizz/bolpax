package id.co.imwizz.bolpax.controller;

import id.co.imwizz.bolpax.dao.IssueDao;
import id.co.imwizz.bolpax.dao.IssueStatusDao;
import id.co.imwizz.bolpax.dao.IssueTrailDao;
import id.co.imwizz.bolpax.dao.TransactionDao;
import id.co.imwizz.bolpax.model.Issue;
import id.co.imwizz.bolpax.model.IssueStatus;
import id.co.imwizz.bolpax.model.IssueTrail;
import id.co.imwizz.bolpax.model.Transaction;
import id.co.imwizz.bolpax.model.rest.request.IssueReq;
import id.co.imwizz.bolpax.model.rest.request.IssueTrailReq;
import id.co.imwizz.bolpax.model.rest.response.IssueCreationRsp;
import id.co.imwizz.bolpax.model.rest.response.IssueDbRsp;
import id.co.imwizz.bolpax.model.rest.response.IssueDetailDbRsp;
import id.co.imwizz.bolpax.model.rest.response.IssueDetailRsp;
import id.co.imwizz.bolpax.model.rest.response.IssueRsp;
import id.co.imwizz.bolpax.model.rest.response.IssueTrailRsp;
import id.co.imwizz.bolpax.util.DateConverter;
import id.co.imwizz.bolpax.util.JsonMapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
@RequestMapping("/issue")
public class IssueController {
	
	@Autowired private IssueDao issueDao;
	@Autowired private IssueTrailDao issueTrailDao;
	@Autowired private IssueStatusDao issueStatusDao;
	@Autowired private TransactionDao trxDao;
	
	/**
	 * Returns list of issues by user id
	 * @param userid
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json", value = "listbyuser")
    @ResponseBody
	public ResponseEntity<String> getListByUserId(@RequestParam("userid") long userid) {
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        
        List<Issue> issues = issueDao.findIssueByUserId(userid);
        List<IssueRsp> issueRsps = new ArrayList<>();
        for (Issue issue : issues) {
        	IssueRsp issueRsp = new IssueRsp();
        	issueRsp.setIssueId(issue.getIssueId());
        	issueRsp.setAmount(issue.getTrx().getAmount());
        	issueRsp.setSuspect(getSuspect(issue));
        	issueRsp.setIssueLastStatus(issue.getSubject());
        	
        	Iterator<IssueTrail> itr = issue.getIssueTrails().iterator();
		    String issueLastDate = null;
		    while(itr.hasNext()) {
		    	IssueTrail issueTrail = (IssueTrail) itr.next();
		    	issueLastDate = DateConverter.parseDate(DateConverter.SIMPLE_DATE, issueTrail.getStsDate());
		    }
        	issueRsp.setIssueDate(issueLastDate);
        	
        	issueRsps.add(issueRsp);
		}
        
        return new ResponseEntity<String>(JsonMapper.fromObjectListtoJsonArray(issueRsps), headers, HttpStatus.OK);
	}
	
	/**
	 * Returns list of issues by merchant id
	 * @param merchantid
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json", value = "listbymerchant")
    @ResponseBody
	public ResponseEntity<String> getListByMerchantId(@RequestParam("merchantid") long merchantId) {
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        
        List<Issue> issues = issueDao.findIssueByMerchantId(merchantId);
        List<IssueRsp> issueRsps = new ArrayList<>();
        for (Issue issue : issues) {
        	IssueRsp issueRsp = new IssueRsp();
        	issueRsp.setIssueId(issue.getIssueId());
        	issueRsp.setAmount(issue.getTrx().getAmount());
        	issueRsp.setSuspect(getSuspect(issue));
        	issueRsp.setIssueLastStatus(issue.getSubject());
        	
        	Iterator<IssueTrail> itr = issue.getIssueTrails().iterator();
		    String issueLastDate = null;
		    while(itr.hasNext()) {
		    	IssueTrail issueTrail = (IssueTrail) itr.next();
		    	issueLastDate = DateConverter.parseDate(DateConverter.SIMPLE_DATE, issueTrail.getStsDate());
		    }
        	issueRsp.setIssueDate(issueLastDate);
        	
        	issueRsps.add(issueRsp);
		}
        
        return new ResponseEntity<String>(JsonMapper.fromObjectListtoJsonArray(issueRsps), headers, HttpStatus.OK);
	}
	
	/**
	 * Returns issue detail by its id
	 * @param issueid
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json", value = "detail")
    @ResponseBody
	public ResponseEntity<String> getDetail(@RequestParam("issueid") long issueid) {
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        
        Issue issue = issueDao.get(issueid);
        
        IssueDetailRsp issueRsp = new IssueDetailRsp();
        issueRsp.setSuspect(getSuspect(issue));
        issueRsp.setAmount(issue.getTrx().getAmount());
        issueRsp.setProduct(issue.getTrx().getProductName());
        issueRsp.setSubject(issue.getSubject());
        issueRsp.setReporter(issue.getReporterRole());
        
        List<IssueTrailRsp> issueTrailRsps = new ArrayList<IssueTrailRsp>();
        Iterator<IssueTrail> itr = issue.getIssueTrails().iterator();
        String lastStatus = null;
        while(itr.hasNext()) {
        	IssueTrail issueTrail = itr.next();
        	lastStatus = issueTrail.getIssueStatus().getStatus();
        	IssueTrailRsp issueTrailRsp = new IssueTrailRsp();
        	issueTrailRsp.setFromAdmin(issueTrail.getFromAdmin().toString());
        	issueTrailRsp.setMessage(issueTrail.getIssueMessage());
        	issueTrailRsp.setTime(DateConverter.parseDate(DateConverter.COMPLETE_DATE, issueTrail.getStsDate()));
        	issueTrailRsp.setIssueStatus(issueTrail.getIssueStatus().getStatus());
        	issueTrailRsps.add(issueTrailRsp);
        }
        
        issueRsp.setIssueLastStatus(lastStatus);
        issueRsp.setIssueHistory(issueTrailRsps);
        
        return new ResponseEntity<String>(JsonMapper.fromObjectToJson(issueRsp), headers, HttpStatus.OK);
	}
	
	/**
	 * Create a new issue by insert data into table issue and issue_trail
	 * @param json => accepted json format {"subject":"","desc":"","role":"","trxId":""}
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json", value = "create")
	public ResponseEntity<String> create(@RequestBody String json) {
		JsonMapper<IssueReq> jMapper = new JsonMapper<IssueReq>(IssueReq.class);
		IssueReq issueReq = jMapper.fromJsonToObject(json);
		
		String subject = issueReq.getSubject();
		String issueMessage = issueReq.getDesc();
		String reporterRole = issueReq.getRole();
		Transaction trx = trxDao.get(issueReq.getTrxId());
		
		Issue issue = new Issue(subject, reporterRole, trx);
		issueDao.persist(issue);
		
		IssueStatus issueStatus = issueStatusDao.get(Long.valueOf(1));
		Character fromAdmin = new Character('N');
		IssueTrail issueTrail = new IssueTrail(fromAdmin, issueMessage, issue, issueStatus);
		issueTrailDao.persist(issueTrail);
		
		IssueCreationRsp issueCreation = new IssueCreationRsp(issue.getIssueId(), "SUCCESS");
		
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<String>(JsonMapper.fromObjectToJson(issueCreation), headers, HttpStatus.CREATED);
	}
	
	/**
	 * Create a new issue trail by insert data into table issue_trail
	 * @param json => accepted json format {"fromAdmin":"","message":"","issueId":"","issueStatusId":""}
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json", value = "insertTrail")
	public ResponseEntity<String> insertTrail(@RequestBody String json) {
		JsonMapper<IssueTrailReq> jMapper = new JsonMapper<IssueTrailReq>(IssueTrailReq.class);
		IssueTrailReq issueTrailReq = jMapper.fromJsonToObject(json);
		
		Character fromAdmin = issueTrailReq.getFromAdmin();
		String issueMessage = issueTrailReq.getMessage();
		Issue issue = issueDao.get(issueTrailReq.getIssueId());
		IssueStatus issueStatus = issueStatusDao.get(issueTrailReq.getIssueStatusId());
		
		IssueTrail issueTrail = new IssueTrail(fromAdmin, issueMessage, issue, issueStatus);
		issueTrailDao.persist(issueTrail);
		
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");			
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	/**
	 * Returns all issues
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json", value = "list")
    @ResponseBody
	public ResponseEntity<String> getAll() {
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");			
        
        List<Issue> issues = issueDao.getAll();
        List<IssueDbRsp> issueRsps = new ArrayList<IssueDbRsp>();
        for (Issue issue : issues) {
        	IssueDbRsp issueRsp = new IssueDbRsp();
        	issueRsp.setBuyer(issue.getTrx().getUser().getFullname());
        	issueRsp.setIssueTitle(issue.getSubject());
        	issueRsp.setMerchant(issue.getTrx().getMerchant().getMerchantName());
        	issueRsp.setReporterRole(issue.getReporterRole());
        	issueRsp.setIssueId(issue.getIssueId());
        	issueRsp.setTrxId(issue.getTrx().getTrxId());
        	
        	Iterator<IssueTrail> itr = issue.getIssueTrails().iterator();
		    while(itr.hasNext()) {
		    	IssueTrail issueTrail = (IssueTrail) itr.next();
		    	issueRsp.setLastIssueDate(DateConverter.parseDate(DateConverter.COMPLETE_DATE, issueTrail.getStsDate()));
	        	issueRsp.setLastIssueHistory(issueTrail.getIssueMessage());
	        	issueRsp.setLastStatus(issueTrail.getIssueStatus().getStatus());
		    }
        	
        	issueRsps.add(issueRsp);
		}
		
		return new ResponseEntity<String>(JsonMapper.fromObjectToJson(issueRsps), headers, HttpStatus.OK);
	}
	
	/**
	 * Returns complete issue detail by its id
	 * @param issueid
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json", value = "detailcomplete")
    @ResponseBody
	public ResponseEntity<String> getDetailCompelete(@RequestParam("issueId") long issueId) {
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");	
        
        Issue issue = issueDao.get(issueId);
        List<IssueDetailDbRsp> issueDetails = new ArrayList<IssueDetailDbRsp>();
        
        Iterator<IssueTrail> itr = issue.getIssueTrails().iterator();
        while(itr.hasNext()) {
        	IssueTrail issueTrail = itr.next();
        	IssueDetailDbRsp issueTrailRsp = new IssueDetailDbRsp();
        	issueTrailRsp.setDate(DateConverter.parseDate(DateConverter.COMPLETE_DATE, issueTrail.getStsDate()));
        	issueTrailRsp.setHistory(issueTrail.getIssueMessage());
        	issueTrailRsp.setStatus(issueTrail.getIssueStatus().getStatus());
        	issueTrailRsp.setFromAdmin(issueTrail.getFromAdmin());
        	
        	issueDetails.add(issueTrailRsp);
        }
        
		
        return new ResponseEntity<String>(JsonMapper.fromObjectToJson(issueDetails), headers, HttpStatus.OK);
	}
	
	/**
	 * Returns suspect name from transaction issue
	 * @param issue
	 * @return
	 */
	private String getSuspect(Issue issue) {
		String suspect = null;
		String role = issue.getReporterRole();
		if(role.equals("buyer")) {
			suspect = issue.getTrx().getMerchant().getMerchantName();
		} else if(role.equals("merchant")) {
			suspect = issue.getTrx().getUser().getFullname();
		}
		
		return suspect;
	}
	
}

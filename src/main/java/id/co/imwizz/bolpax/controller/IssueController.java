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
import id.co.imwizz.bolpax.util.JsonMapper;

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
@RequestMapping("/issue")
public class IssueController {
	
	@Autowired
	private IssueDao issueDao;
	
	@Autowired
	private IssueTrailDao issueTrailDao;
	
	@Autowired 
	private IssueStatusDao issueStatusDao;
	
	@Autowired
	private TransactionDao trxDao;
	
	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json", value = "listbyuser")
    @ResponseBody
	public ResponseEntity<String> getListByUserId(@RequestParam("userid") long userid) {
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        
        List<Issue> trxs = issueDao.findIssueByUserId(userid);
        return new ResponseEntity<String>(JsonMapper.fromObjectListtoJsonArray(trxs), headers, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json", value = "listbymerchant")
    @ResponseBody
	public ResponseEntity<String> getListByMerchantId(@RequestParam("merchantId") long merchantId) {
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        
        List<Issue> trxs = issueDao.findIssueByMerchantId(merchantId);
        return new ResponseEntity<String>(JsonMapper.fromObjectListtoJsonArray(trxs), headers, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json", value = "detail")
    @ResponseBody
	public ResponseEntity<String> getDetail(@RequestParam("issueid") long issueid) {
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        
        Issue issue = issueDao.get(issueid);
        return new ResponseEntity<String>(JsonMapper.fromObjectToJson(issue), headers, HttpStatus.OK);
	}
	
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
		
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
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
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
}

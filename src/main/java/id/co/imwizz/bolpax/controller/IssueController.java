package id.co.imwizz.bolpax.controller;

import id.co.imwizz.bolpax.dao.IssueDao;
import id.co.imwizz.bolpax.dao.IssueTrailDao;
import id.co.imwizz.bolpax.model.Issue;
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
@RequestMapping("/issue")
public class IssueController {
	
	@Autowired
	private IssueDao issueDao;
	
	@Autowired
	private IssueTrailDao issueTrailDao;
	
	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json", value = "createUser")
	public ResponseEntity<String> createUser(@RequestBody String json) {
		JsonMapper<Issue> jMapper = new JsonMapper<Issue>(Issue.class);
		Issue issue = jMapper.fromJsonToObject(json);
		issueDao.persist(issue);
		
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
}
